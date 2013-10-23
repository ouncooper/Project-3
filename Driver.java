import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 * Project #2
 * CS 2334, Section 012
 * October 9, 2013
 * <P>
 * This class implements a program that will store, read, and write an ADT of academic papers.	
 * </P>
 * @version 0.1
 */
 
 // FOR THE LOVE OF EVERYTHING HOLY, DO NOT FORGET
 //TO GENERATE THE JAVADOC
 //Or for one point.
 //DO NOT FORGET KTHX ME.  -Me, 2:19
 
public class Driver
{
	/**
	 * Main method for the program.
	 * Prompts the user for a filepath on the command line,
	 * then creates a PaperCollection that stores the papers read in.
	 * @param args Command line arguments.
	 * @throws IOException Error in I/O.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input a filepath for the papers file.");
		String input = inputReader.readLine();
		PaperCollection academicPapers = new PaperCollection(input);
		
		do {
			System.out.println("Please input either a sort criteria or other action command: ");
			input = inputReader.readLine();
			if (input.equalsIgnoreCase("help")){
				System.out.println("----- Help Menu -----");
				System.out.println("------ General ------");
				System.out.println("E - Exit");
				System.out.println("-- Sorting Methods --");
				System.out.println("BI - Sort biblographically");
				System.out.println("AN - Sort by author name");
				System.out.println("PT - Sort by paper title");
				System.out.println("ST - Sort by serial title");
				System.out.println("CH - Sort chronologically");
				System.out.println("R - Randomize the papers");
				System.out.println("------ File IO ------");
				System.out.println("PS - Print to Screen");
				System.out.println("PF - Print to File");
				System.out.println("----- Searching -----");
				System.out.println("S - Search by title");
				System.out.println("FA - Search by author\n");
			} else if (input.equalsIgnoreCase("BI")) {
				academicPapers.sort("BI");
			} else if (input.equalsIgnoreCase("AN")) {
				academicPapers.sort("AN");
			} else if (input.equalsIgnoreCase("PT")) {
				academicPapers.sort("PT");
			} else if (input.equalsIgnoreCase("ST")) {
				academicPapers.sort("ST");
			} else if (input.equalsIgnoreCase("CH")) {
				academicPapers.sort("CH");
			} else if (input.equalsIgnoreCase("R")) {
				academicPapers.sort("R");
			} else if (input.equalsIgnoreCase("PS")) {
				academicPapers.printToScreen();
			} else if (input.equalsIgnoreCase("PF")) {
				System.out.println("Please enter the location you would like to save to: ");
				input = inputReader.readLine();
				if(input.endsWith(".txt")){
					System.out.println("Saving as " + input);
					academicPapers.printTextFile(input);
				}
				else if(input.endsWith(".ppr")){
					System.out.println("Saving as " + input);
					academicPapers.printBinFile(input);
				}
				else{
					System.out.println("Saving as " + input + ".ppr");
					academicPapers.printBinFile(input+".ppr");
				}
				System.out.println("Saved.");
			} else if (input.equalsIgnoreCase("S")) {
				System.out.print("Please input a title to find: ");
				System.out.println(academicPapers.searchTitle(inputReader.readLine()).toString().replaceAll(" // ", "\n"));
			} else if (input.equalsIgnoreCase("FA")) {
				System.out.print("Please input an author to find: ");
				try {
					academicPapers.searchAuthor(inputReader.readLine());
				} catch (ClassNotFoundException e) { }
			}
				
		} while (!input.equalsIgnoreCase("E"));
		
		System.out.println("Thank you, exiting.");
	}
}
