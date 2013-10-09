import java.io.Serializable;
import java.util.Comparator;

public class ConferencePaper extends Paper implements Comparator<Paper>
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
		String newAuthorsArray[] = newAuthors.split("; ");
		for(String author:newAuthorsArray)
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
		return getName() + " // " + getAuthors() + " // " + getTitle() + " // " + getSerialTitle() + " // " + getPageRange() + " // " + getDate() + " // " + getDOI();
	}

	@Override
	public int compare(Paper o1, Paper o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
