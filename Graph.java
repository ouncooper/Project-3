import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Graph extends JFrame {

	private static final long serialVersionUID = -9016628330098315510L;
	private JFrame histogram = null;
	MyPanel hPanel = null;
	
	/**
	 * Default constructor for the class
	 */
	public Graph() { }
	
	public Graph(String title) {
		System.out.println("x");
		histogram = new JFrame(title);
		histogram.setSize(750, 400);
		histogram.setAlwaysOnTop(true);
		hPanel = new MyPanel();
		histogram.add(hPanel);
		pack();
		setLocationRelativeTo(null);
		histogram.setVisible(true);
		repaint();
		graphType(null);
	}
	
	public void addBar(int value, String label)
	{
		hPanel.addBar(new Integer(value), label);
	}
	
	/**
	 * Graphs the number of journal articles vs. the number of conference papers 
	 * @param input The author who's data you want to graph
	 */
	public void graphType(Author input){
		System.out.println("c");
		repaint();
	}
	
	/**
	 * Graphs the number of publications the author produced each year
	 * @param input The author who's data you want to graph
	 */
	public void graphPublicationsPerYear(Author input){
		
	}
	
	/**
	 * Graphs the number of conference papers the author produced each year
	 * @param input The author who's data you want to graph
	 */
	public void graphConferencePerYear(Author input){
		
	}

	/**
	 * Graphs the number of journal articles the author produced each year
	 * @param input The author who's data you want to graph
	 */
	public void graphJournalPerYear(Author input){
		
	}
	
	/**
	 * Graphs the number of coauthors for each publication
	 * @param input The author who's data you want to graph
	 */
	public void graphNumberCoauthors(Author input){
		
	}
	
	public void setGraphicTitle(String newTitle)
	{
		histogram.setTitle(newTitle);
	}
	
	@Override
	public void paint(Graphics graphic)
	{
		super.paintComponents(graphic);
		System.out.println("a");
		histogram.paint(graphic);
		graphic.drawRect(0, 0, 50, 50);
		graphic.drawRect(100, 100, 100, 100);
	}
	
	class MyPanel extends JPanel {
		
		private static final long serialVersionUID = 9103733522947634373L;
		private ArrayList<Integer> bars = new ArrayList<Integer>();
		private ArrayList<String> labels = new ArrayList<String>();
		
		public MyPanel() { }

		public void addBar(Integer value, String label)
		{
			bars.add(value);
			labels.add(label);
		}
		
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g); 
	        int maxValue = -1;
	        for(Integer value:bars)
	        	maxValue = Math.max(maxValue, value);
	        
	        for(Integer value:bars)
	        {
	        	int height = (int)((double)(value / maxValue) * 200);
	        	int indexAt = bars.indexOf(value);
	        	System.out.println(height + " // " + indexAt);
	        	g.fillRect(indexAt * 100 + 25, 300 - height, 80, height);
	        	g.drawString(labels.get(indexAt), indexAt * 100 + 25, 325);
	        	g.drawString(value.toString(), indexAt * 100 + 45, 280 - height);
	        }
	    }  
	}
}
