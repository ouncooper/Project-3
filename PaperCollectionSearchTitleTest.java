import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionSearchTitleTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		//Make a new collection from file
		PaperCollection testCollection = new PaperCollection("papers.txt");
		
		Paper result = testCollection.searchTitle("Mexual Selection, Resource Distribution, and Population Size in Synthetic Sympatric Speciation");
		
		//Test to see if the first paper is the expected paper
		Assert.assertEquals("Conference Paper // Woehrer, Mark; Hougen, Dean; Schlupp, Ingo // Mexual Selection, Resource Distribution, and Population Size in Synthetic Sympatric Speciation // Subinternational Conference on the Synthesis and Simulation of Living Systems // 135-145 // July 2012 // http://dx.doi.org/10.7551/978-0-262-31050-5-ch020", result.toString());
	}

}
