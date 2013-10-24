import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionWriteBinTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		//Create a paper collection from text file
		PaperCollection testCollection = new PaperCollection("papers.txt");
		
		testCollection.printBinFile("testexport.ppr");
		
		PaperCollection testExportCollection = new PaperCollection("testexport.ppr");
		
		Assert.assertEquals(testExportCollection.size(), testCollection.size());
		
	}

}
