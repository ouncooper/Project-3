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
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input a filepath for the papers file.  Leave blank for default.");
		String input = inputReader.readLine();
		PaperCollection academicPapers = new PaperCollection(input);
		
		do {
			System.out.println("Please input either a sort criteria or other action command: ");
			input = inputReader.readLine();
			if (input.equalsIgnoreCase("BI")) {
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
				academicPapers.printTextFile("papersOutput.txt");
			} else if (input.equalsIgnoreCase("S")) {
				System.out.print("Please input a title to find: ");
				academicPapers.searchTitle(inputReader.readLine());
			} else if (input.equalsIgnoreCase("FA")) {
				System.out.print("Please input an author to find: ");
				try {
					academicPapers.searchAuthor(inputReader.readLine());
				} catch (ClassNotFoundException e) { }
			}
				
		} while (input != "E");
		
		System.out.println("Thank you, exiting.");
	}
}
