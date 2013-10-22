import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionWriteTextTest {

	@Test
	public void test() throws IOException {
		String fileToOpen = "papers.txt";
		String savedFile = "testexport.txt";
		
		//Print to file
		PaperCollection testCollection = new PaperCollection(fileToOpen);
		testCollection.printTextFile(savedFile);
		
		//Open both files
		//Make a file reader
		FileReader fileA = new FileReader(savedFile);
		FileReader fileB = new FileReader(fileToOpen);
		//Make a buffered reader from the file reader
		BufferedReader bufferA = new BufferedReader(fileA);
		BufferedReader bufferB = new BufferedReader(fileB);
		
		//Check to see if the files are equal by comparing each line
		while(bufferB.ready()){
			Assert.assertEquals(bufferB.readLine(), bufferA.readLine());
		}
		//Close buffer to avoid memory leak
		bufferA.close();
		bufferB.close();
	}

}
