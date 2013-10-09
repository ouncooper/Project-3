import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 */
	public static void main(String[] args)
	{
		//Init gui?
		PaperCollection blah = new PaperCollection();
		System.out.println(blah.getClass());
	}
}
