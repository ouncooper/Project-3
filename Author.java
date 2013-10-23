import java.io.Serializable;
import java.util.ArrayList;


public class Author implements Serializable {

	private static final long serialVersionUID = 7929672306452724030L;
	/* Last name of the author */
	private String secondaryName = "";
	/* First and middle name(s) of the author */
	private String primaryName = "";
	/* List of papers that the author has written */
	private ArrayList<Paper> paperList = new ArrayList<Paper>();
	
	/**
	 * Default constructor for the class.
	 */
	public Author()
	{
		
	}
	/**
	 * Preferred constructor, takes the full name of the author in either
	 * primary, secondary or secondary primary format.
	 * @param name The name of the Author
	 */
	public Author(String name)
	{
		if (name.contains(",")) //Check the input format (primary, secondary or secondary primary)
		{
			//Case primary, secondary (last, first middle)
			secondaryName = name.split(", ")[1];
			setPrimaryName(name.split(", ")[0]);
			
		}
		else
		{
			//Case secondary primary (first middle last)
			String[] temp = name.split(" "); //Creating this for temporary usage so there are not ugly lines of code.
			for (int i = 0; i < temp.length - 1;i++)
				secondaryName += " " + temp[i];
			secondaryName = secondaryName.substring(1);
			setPrimaryName(temp[temp.length - 1]);
		}
	}
	
	/**
	 * @return the primaryName
	 */
	public String getPrimaryName() {
		return primaryName;
	}
	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(String newPrimaryName) {
		primaryName = newPrimaryName;
	}
	
	/**
	 * @return The Secondary name of the author (first middle).
	 */
	public String getSecondaryName() {
		return secondaryName;
	}
	/**
	 * @param secondaryName The secondary name of the author
	 */
	public void setSecondaryName(String newSecondaryName) {
		secondaryName = newSecondaryName;
	}
	
	public void addPaper(Paper newPaper)
	{
		paperList.add(newPaper);
	}
	
	public String toString(){
		return primaryName + ", " + secondaryName;
	}
	
	public ArrayList<Paper> getPaperList(){
		return paperList;
	}
}
