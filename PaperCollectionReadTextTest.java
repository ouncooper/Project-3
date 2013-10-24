import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionReadTextTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		//Filename containing exactly 4 test papers
		String filepath = "papers.txt";

		PaperCollection testCollection = new PaperCollection(filepath);
		
		//For visual inspection
		testCollection.printToScreen();
		
		//See if there are exactly 4 papers in the collection
		Assert.assertEquals(testCollection.size(), 4);
	}

}
