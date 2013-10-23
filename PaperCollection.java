import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class PaperCollection {
	
	private ArrayList<Paper> paperCollection = new ArrayList<Paper>();
	private HashMap<String, Author> nameAuthorMap = new HashMap<String, Author>();
	
	/**
	 * Default constructor for the class.
	 */
	public PaperCollection() { }
	
	/**
	 * Preferred constructor for the class.
	 * Reads in a text file and constructs the proper paper based on the information given.
	 * @param filepath File path of the text file that contains the list of papers and their details.
	 * @throws IOException Thrown if a readLine error occurs.
	 */
	public PaperCollection(String filepath) throws IOException
	{
		if (filepath.endsWith(".txt"))
			readTextFile(filepath);
		else
			try {
				readBinFile(filepath);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Sorts the collection by a certain criteria.
	 * @param method Which element to sort by (ex. BI for bibliographic, AU for author, etc.)
	 */
	public void sort(String method)
	{
		
	}
	
	/**
	 * Reads in the objects from a file
	 * @param filename The file you want to read
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void readBinFile(String filePath) throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream(filePath);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        
        //Get the titleAuthorMap from the file
        ////titleAuthorMap = (HashMap<String, ArrayList<Paper>>) objectStream.readObject();
        paperCollection = (ArrayList<Paper>) objectStream.readObject();
        nameAuthorMap = (HashMap<String, Author>) objectStream.readObject();
        //TODO
        System.out.println("AuthorMap size: " + nameAuthorMap.size());
        /*
        //Create a Hash set to remove duplicate Papers
        Collection<Paper> noDuplicates = new HashSet<Paper>();
        
        //Go through each ArrayList of papers in titleAuthorMap and add each paper to noDuplicates
        //noDuplicates will remove any duplicates because it's a HashSet
        for(ArrayList<Paper> eachCollection: titleAuthorMap.values()){
                        noDuplicates.addAll(eachCollection);
        }
        
        //Add all the papers in noDuplicates to the paperCollection
        paperCollection.addAll(noDuplicates);
        
        //Close to prevent memory leak*/
        objectStream.close();
	}
	
	/**
	 * Reads in objects from a text file
	 * @param filename The file you want to read
	 * @throws IOException 
	 */
	public void readTextFile(String filePath) throws IOException{
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine(); //Initial line grab
		
		String[] paperInfo = new String[7]; //Holds the info for the current paper. Will be used in the construction of a new paper object.
		int i = 0;

		while (line != null) { //Until the end of the file
			do { //Loops until a new magazine is found.
				paperInfo[i++] = line;
				line = br.readLine();
				if (line == null) //End of file, break from the while loop since it's difficult to conditional this.
					break;
			} while (!(line.equalsIgnoreCase(""))); //Detection of a new paper.
			Paper paperToAdd = null;
			if (paperInfo[0].equalsIgnoreCase("Journal Article")) //Create the appropriate constructor
				paperToAdd = new JournalArticle(paperInfo[0], paperInfo[1], paperInfo[2], paperInfo[3], paperInfo[4], paperInfo[5], paperInfo[6]);
			else if (paperInfo[0].equalsIgnoreCase("Conference Paper"))
				paperToAdd = new ConferencePaper(paperInfo[0], paperInfo[1], paperInfo[2], paperInfo[3], paperInfo[4], paperInfo[5], paperInfo[6]);
			else System.out.println("There's a major problem!"); //Should never be reached or we have a problem.
			//Add the newly created paper to the collection
			paperCollection.add(paperToAdd);
			
			//Create a new author if necessary
			//Add the paper to the Author's paperList.
			for (String author:paperInfo[1].split("; "))
			{
				if (!nameAuthorMap.containsKey(author))
					nameAuthorMap.put(author, new Author(author));
				nameAuthorMap.get(author).addPaper(paperToAdd);
			}
			paperInfo = new String[7]; //Reset the information arrays
			i = 0;
			line = br.readLine();
		}
		System.out.println("\n\n");
		
		br.close();
	}
	
	/**
	 * Prints the objects to a file
	 * @param filename The file you want to print to
	 * @throws IOException 
	 */
	public void printBinFile(String filePath) throws IOException{
		FileOutputStream fileStream = new FileOutputStream(filePath);
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		

		//Save the hashMap (contains the paperCollection)
		objectStream.writeObject(paperCollection);
		objectStream.writeObject(nameAuthorMap);
		
		//Close to prevent memory leak
		objectStream.close();
	}
	
	/**
	 * Prints the objects to a text file
	 * @param filename The file you want to print to
	 * @throws IOException 
	 */
	public void printTextFile(String filePath) throws IOException
	{
		//Make a file to print to and open a buffer
		FileWriter outputFile = new FileWriter(filePath);
		BufferedWriter bw = new BufferedWriter(outputFile);

		//Go through each paper in the collection and print it to the file
		for(Paper eachPaper: paperCollection){
			bw.write(eachPaper.toString().replace(" // null", "").replace(" // ", "\n"));
			bw.newLine();
			bw.newLine();
		}
		//Close the buffer
		bw.close(); 
	}
	
	/**
	 * Prints the data in the collection to the screen for the user to view
	 */
	public void printToScreen()
	{
		for(Paper eachPaper:paperCollection)
			System.out.println(eachPaper.toString().replace(" // null", "").replace(" // ", "\n") + "\n");
	}
	
	/**
	 * Searches the collection for a keyword.
	 * @param query The search query.
	 * @return The corresponding paper to the title or null if it does not exist.
	 */
	public Paper searchTitle(String query)
	{
		return null;	
	}

	/**
	 * Searches the collection for an author
	 * @param query The author you want to search for
	 * @return The papers associated with that author
	 * @throws IOException FIIIIIIIIIIIIIIX
	 * @throws ClassNotFoundException 
	 */
	public void searchAuthor(String authorQuery) throws IOException, ClassNotFoundException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

		//Reorder so the author is found/not found
		Author searchedAuthor = nameAuthorMap.get(authorQuery);
		if (searchedAuthor == null)
		{
			System.out.println("No author was found by the name " + authorQuery + ".");
			return;
		}
		
		for(Paper eachPaper:searchedAuthor.getPaperList())
			System.out.println(eachPaper.toString());

		String input = "something";
		
		do {
			
			System.out.print("Would you like to load (LD), save(SV), generate a graphic(G), or go back(B): ");
			input = inputReader.readLine();
			
			if (input.equalsIgnoreCase("LD"))
			{
				System.out.print("Please input a filename to load from: ");
				String input2 = inputReader.readLine();
				readBinFile(input2);
			}
			else if (input.equalsIgnoreCase("SV"))
			{
				System.out.print("Please input a filename to save to: ");
				String input2 = inputReader.readLine();
				printBinFile(input2);
			}
			else if (input.equalsIgnoreCase("G"))
			{
				Graph authorGraph = new Graph();
				System.out.print("What would you like to graph? ");
				String input2 = inputReader.readLine();
				if (input2.equalsIgnoreCase("TP"))
				{
					
				}
				else if (input2.equalsIgnoreCase("PY"))
				{
					
				}
				else if (input2.equalsIgnoreCase("CPY"))
				{
					
				}
				else if (input2.equalsIgnoreCase("JPY"))
				{
					
				}
				else if (input2.equalsIgnoreCase("NC"))
				{
					
				}
				else
				{
					System.out.println("Please choose a valid action.");
				}
			}
		} while (!input.equalsIgnoreCase("B"));
	}
	
	/**
	 * Gets the size of the list that contains the papers.
	 * @return The size of the arrayList that the papers are stored in.
	 */
	public int size() {
		return paperCollection.size();
	}
	
	/**
	 * Converts the collection to a string
	 * @return A string representing the collection
	 */
	public String toString()
	{
		return "";
	}
}
