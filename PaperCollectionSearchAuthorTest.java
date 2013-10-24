import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class PaperCollectionSearchAuthorTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		//Make a new collection from file
		PaperCollection testCollection = new PaperCollection("papers.txt");
		
		testCollection.searchAuthor("Schlupp, Ingo");
		
		//User will need to decide if it works as searchAuthor doesn't return anything.
		
	}

}
