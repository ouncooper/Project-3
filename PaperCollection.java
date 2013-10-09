import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class PaperCollection {
	
	private ArrayList<Paper> paperCollection = new ArrayList<Paper>();
	private HashMap<String, ArrayList<Paper>> authorMap = new HashMap<String, ArrayList<Paper>>();
	
	/**
	 * Default constructor for the class.
	 */
	public PaperCollection() {}
	
	/**
	 * Preferred constructor for the class.
	 * Reads in a text file and constructs the proper paper based on the information given.
	 * @param filepath File path of the text file that contains the list of papers and their details.
	 * @throws IOException Thrown if a readLine error occurs.
	 */
	public PaperCollection(String filepath) throws IOException
	{
		//Read in
	}
	
	/**
	 * Sorts the collection by a certain criteria.
	 * @param method Which element to sort by (ex. BI for bibliographic, AU for author, etc.)
	 */
	public void sort(String method)
	{
		
	}
	
	/**
	 * Prints the data in the collection to a file on the drive
	 * @param filepath Where you want to print the file to
	 * @throws IOException Error in reading the file, in our out.
	 */
	public void printToFile(String filepath) throws IOException
	{

	}
	
	/**
	 * Prints the data in the collection to the screen for the user to view
	 */
	public void printToScreen()
	{

	}
	
	/**
	 * Searches the collection for a keyword.
	 * @param searchCriteria The search query.
	 * @return The corresponding paper to the title or null if it does not exist.
	 */
	public Paper search(String searchTitle)
	{
		return null;	
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
