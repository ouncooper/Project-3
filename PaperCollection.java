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
	 * Reads in the objects from a file
	 * @param filename The file you want to read
	 */
	public void readBinFile(String filename){
		
	}
	
	/**
	 * Reads in objects from a text file
	 * @param filename The file you want to read
	 */
	public void readTextFile(String filename){
		
	}
	
	/**
	 * Prints the objects to a file
	 * @param filename The file you want to print to
	 */
	public void printBinFile(String filename){
		
	}
	
	/**
	 * Prints the objects to a text file
	 * @param filename The file you want to print to
	 */
	public void printTextFile(String filename){
		
	}
	
	/**
	 * Prints the data in the collection to the screen for the user to view
	 */
	public void printToScreen()
	{

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
	 */
	public Paper[] searchAuthor(String query)
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
