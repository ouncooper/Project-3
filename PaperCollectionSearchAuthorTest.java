import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionSearchAuthorTest {

	@Test
	public void test() throws IOException {
		//Make a new collection from file
		PaperCollection testCollection = new PaperCollection("papers.txt");
		
		ArrayList<Paper> paperArray = testCollection.searchAuthor("Hougen, Dean F.");
		//This needs to be fixed
		
		//Test to see if the first paper is the expected paper
		Assert.assertEquals("Conference Paper // Woehrer, Mark; Hougen, Dean; Schlupp, Ingo // Mexual Selection, Resource Distribution, and Population Size in Synthetic Sympatric Speciation // Subinternational Conference on the Synthesis and Simulation of Living Systems // 135-145 // July 2012 // http://dx.doi.org/10.7551/978-0-262-31050-5-ch020", paperArray[0].toString());
	}

}
