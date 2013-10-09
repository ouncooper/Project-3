import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionReadTextTest {

	@Test
	public void test() {
		//Filename containing exactly 4 test papers
		String filepath = "papers.txt";

		PaperCollection testCollection = null;
		try {
			testCollection = new PaperCollection(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//See if there are exactly 4 papers in the collection
		Assert.assertEquals(testCollection.size(), 4);
	}

}
