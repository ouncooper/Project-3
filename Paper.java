import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Paper implements Comparable<Paper>, Serializable, Comparator<Paper>
{	
	private static final long serialVersionUID = -8913776819739550541L;
	
	/* A variable to store the name of the paper.*/
	private String name;
	/* A variable to store the authors of the paper.*/
	private ArrayList<Author> authors = new ArrayList<Author>();
	/* A variable to store the title of the paper.*/
	private String title;
	/* A variable to store the serial title of the paper.*/
	private String serialTitle;
	/* A variable to store the date of publication of the paper.*/
	private String date;
	/* A variable to store the pages the paper is on.*/
	private String pageRange;
	/* A variable to store the digital object identifier of the paper.*/
	private String DOI;
	
	/* A variable to store the method of sorting and searching. */
	private static String sortCriteria;
	
	/**
	 * Default constructor.
	 */
	public Paper() {}
	
	/**
	 * Compares one paper to another by the given criteria.
	 * @param otherPaper The paper you want to compare against.
	 */
	public int compareTo(Paper otherPaper)
	{
		//TODO
		return -2;
	}
	
	/**
	 * Sets the search criteria
	 * @param method The search criteria ("BI", "AN", "PT", "ST", "CH", "R")
	 */
	public static void setSortCriteria(String method)
	{
		sortCriteria = method;
	}
	
	/**
	 * @return the name of the paper
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param the name of the paper
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the authors of the paper
	 */
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param the authors of the paper
	 */
	public void addAuthor(String authorName) {
		authors.add(new Author(authorName));
	}

	/**
	 * @return the title of the paper
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param the title of the paper
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the Serial title of the paper
	 */
	public String getSerialTitle() {
		return serialTitle;
	}

	/**
	 * @param the serial title of the paper
	 */
	public void setSerialTitle(String serialTitle) {
		this.serialTitle = serialTitle;
	}

	/**
	 * @return the date of publication
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param the date of publication
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the pages the paper is found on in the format "start-end"
	 */
	public String getPageRange() {
		return pageRange;
	}

	/**
	 * @param the pages the paper is found on in the format "start-end"
	 */
	public void setPageRange(String pageRange) {
		this.pageRange = pageRange;
	}

	/**
	 * @return the digital object identifier of the paper
	 */
	public String getDOI() {
		return DOI;
	}

	/**
	 * @param the digital object identifier of the paper
	 */
	public void setDOI(String DOI) {
		this.DOI = DOI;
	}
}
