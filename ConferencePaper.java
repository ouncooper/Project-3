import java.io.Serializable;
import java.util.Comparator;

public class ConferencePaper extends Paper implements Serializable
{
	private static final long serialVersionUID = 8507820325335680360L;

	/**
	 * Default constructor for the class.
	 */
	public ConferencePaper() {}
	
	/**
	 * Inherits from the Paper class.
	 * Creates a ConferencePaper Object
	 * @param newName Name of the paper ("Conference Paper").
	 * @param newAuthors Authors of the paper in the format Last, First Middle; Last, First Middle; etc.
	 * @param newTitle Title of the paper.
	 * @param newSerialTitle Serial title of the paper.
	 * @param newDate Date the paper was published.
	 * @param newPageRange Page range specified in the file.
	 * @param newDOI Digital Object Identifier for the paper.
	 */
	public ConferencePaper(String newName, String newAuthors, String newTitle, String newSerialTitle, String newPageRange, String newDate,  String newDOI)
	{
		setName(newName);
		for(String author:newAuthors.split("; "))
			addAuthor(author);
		setTitle(newTitle);
		setSerialTitle(newSerialTitle);
		setPageRange(newPageRange);
		setDate(newDate);
		setDOI(newDOI);
	}
	
	/**
	 * Converts the object to a string separated by " // "
	 */
	public String toString()
	{
		String a = "";
		for(int i = 0; i < getAuthors().size(); i++){
			a += getAuthors().get(i).getPrimaryName() + ", " + getAuthors().get(i).getSecondaryName();
			if(i < getAuthors().size()-1)
				a += "; ";
		}
		return getName() + " // " + a + " // " + getTitle() + " // " + getSerialTitle() + " // " + getPageRange() + " // " + getDate() + " // " + getDOI();
	}
}
