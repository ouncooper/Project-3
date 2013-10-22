import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionWriteBinTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		//Create a paper collection from bin file
		PaperCollection testCollection = new PaperCollection("papers.ppr");
		
		testCollection.printBinFile("outputfile.ppr");
		
		
		//Open the files
		FileInputStream fileStreamA = new FileInputStream("papers.ppr");
		ObjectInputStream objectsA = new ObjectInputStream(fileStreamA);
		
		FileInputStream fileStreamB = new FileInputStream("outputFile.ppr");
		ObjectInputStream objectsB = new ObjectInputStream(fileStreamB);
		
		
		//Don't know what the expected is yet
		Assert.assertEquals(objectsA.readObject(), objectsB.readObject());
		
	}

}
