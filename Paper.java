import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Paper implements Comparable<Paper>, Serializable
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
	
	/**
	 * Default constructor.
	 */
	public Paper() {}
	
	/**
	 * Compares one paper to another by the given criteria.
	 * @param otherPaper The paper you want to compare against.
	 */
	public int compareTo(Paper otherPaper){
		//Compare titles, then serial titles, then authors, then date, then pageRange and finally DOI
		if(title.compareTo(otherPaper.getTitle()) != 0)
			return title.compareTo(otherPaper.getTitle());
		if(serialTitle.compareTo(otherPaper.getSerialTitle()) != 0)
			return title.compareTo(otherPaper.getSerialTitle());
		for(int i = 0; i < authors.size(); i++)
			if(authors.get(i).toString().compareTo(otherPaper.getAuthors().get(i).toString()) != 0)
				return authors.get(i).toString().compareTo(otherPaper.getAuthors().get(i).toString());
		if(date.compareTo(otherPaper.getDate()) != 0)
			return date.compareTo(otherPaper.getDate());
		if(pageRange.compareTo(otherPaper.getPageRange()) != 0)
			return pageRange.compareTo(otherPaper.getPageRange());
		if(DOI.compareTo(otherPaper.getDOI()) != 0)
			return DOI.compareTo(otherPaper.getDOI());
		
		//They are exactly the same		
		return 0;
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

	public static class Comparators {

		public static Comparator<Paper> compareNames = new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {return o1.getName().compareTo(o2.getName());}
        };
        public static Comparator<Paper> compareTitles = new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {return o1.getTitle().compareTo(o2.getTitle());}
        };
        public static Comparator<Paper> compareSerialTitles = new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {return o1.getSerialTitle().compareTo(o2.getSerialTitle());}
        };
        public static Comparator<Paper> compareDates = new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {
            	int dateInMonthsA = Integer.parseInt(o1.getDate().split(" ")[1])*12;
            	
            	switch(o1.getDate().split(" ")[0]){
	            	case "January": dateInMonthsA += 1;
	        		break;
	            	case "February": dateInMonthsA += 2;
	        		break;
	            	case "March": dateInMonthsA += 3;
	        		break;
	            	case "April": dateInMonthsA += 4;
	        		break;
	            	case "May": dateInMonthsA += 5;
	        		break;
	            	case "June": dateInMonthsA += 6;
	        		break;
	            	case "July": dateInMonthsA += 7;
	        		break;
	            	case "August": dateInMonthsA += 8;
	        		break;
	            	case "September": dateInMonthsA += 9;
	        		break;
	            	case "October": dateInMonthsA += 10;
	        		break;
	            	case "November": dateInMonthsA += 11;
	        		break;
	            	case "December": dateInMonthsA += 12;
	        		break;
            	}
            	int dateInMonthsB = Integer.parseInt(o2.getDate().split(" ")[1])*12;
            	
            	switch(o2.getDate().split(" ")[0]){
	            	case "January": dateInMonthsB += 1;
	        		break;
	            	case "February": dateInMonthsB += 2;
	        		break;
	            	case "March": dateInMonthsB += 3;
	        		break;
	            	case "April": dateInMonthsB += 4;
	        		break;
	            	case "May": dateInMonthsB += 5;
	        		break;
	            	case "June": dateInMonthsB += 6;
	        		break;
	            	case "July": dateInMonthsB += 7;
	        		break;
	            	case "August": dateInMonthsB += 8;
	        		break;
	            	case "September": dateInMonthsB += 9;
	        		break;
	            	case "October": dateInMonthsB += 10;
	        		break;
	            	case "November": dateInMonthsB += 11;
	        		break;
	            	case "December": dateInMonthsB += 12;
	        		break;
            	}
            	
            	return dateInMonthsA - dateInMonthsB;
            }
        };
        public static Comparator<Paper> randomize = new Comparator<Paper>() {
        	@Override
        	public int compare(Paper o1, Paper o2) {return -100 + (int)(Math.random()*200);}
        };
        public static Comparator<Paper> compareAuthors = new Comparator<Paper>() {
        	@Override
        	public int compare(Paper o1, Paper o2) {
        		String s1 = "";
        		String s2 = "";
        		for(Author eachAuthor: o1.getAuthors())
        			s1 += eachAuthor.toString();
        		for(Author eachAuthor: o2.getAuthors())
        			s2 += eachAuthor.toString();
        		return s1.compareTo(s2);
        	}
        };
    }
	
}
