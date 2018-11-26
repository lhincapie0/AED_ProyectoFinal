package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import structure.Edge;
import structure.Main;
import structure.Node;
public class MainWindow extends JFrame {
	
	
	
	private ImagePanel imagePanel;
	private MenuPanel menuPanel;
	private Main main;
	
	
	public MainWindow() throws Exception
	{
		
		super("EURAIL");
		setSize(1800,1000);
		main = new Main();

		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		imagePanel = new ImagePanel();
		menuPanel = new MenuPanel(this);
		this.add(imagePanel,BorderLayout.CENTER);
		this.add(menuPanel,BorderLayout.SOUTH);
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
			}
		});

	}
	
	
	public ArrayList<Node<String>> getNodesData()
	{
		ArrayList<Node<String>> nodes = main.getNodesData();
				return nodes;	
	}
	
	
	
	public ArrayList<EdgeView> getEdgesData()
	{
		ArrayList<EdgeView> edgesXY = main.getEdgesData();
		
		return edgesXY;
	}
	
	
	public void showMap() {
		
		MapDialog d = new MapDialog(this);
		d.setVisible(true);
		d.setLocationRelativeTo(this);
	}
	public String getShortestDistance(String origen, String destiny) throws Exception
	{
		int d = main.getShortestDistance(origen, destiny);
		String distance = d+" ";
		return distance;
	}
	
	
	public String[] calculateShortestPath(String origen, String destiny) throws Exception
	{
		List<String> path = main.calculateShortestPath(origen, destiny);
		String[] p = new String[path.size()];
		for(int i = 0; i<path.size();i++)
		{
			p[i] = path.get(i);
			System.out.println("?????" + path.get(i));
		}
		
		return p;
	}
	
	public void showRoutes()
	{
		RoutesDialog d = new RoutesDialog(this);
		d.setVisible(true);
		d.setLocationRelativeTo(this);	
	}
	
	
	public void calculatePath()
	{
		PathDialog d = new PathDialog(this);
		d.setVisible(true);
		d.setLocationRelativeTo(this);	
	}
	
	public void changeGraphRepresentation()
	{
		main.changeGraphRepresentation();
	}
	
	public String getGraphRepresentation() {
		return main.getGraphRepresentation();
	}
	
	public String[] showAdjacents(String city)
	{
		
		//TO DO
		ArrayList<String> adj = main.getAdyacents(city);
		String[] adjacents = new String[adj.size()];

		
		for(int i = 0; i<adj.size();i++)
		{
			adjacents[i] = adj.get(i);
		}
		return adjacents;
	}
	
	
	
	
	public String[] getCitiesNames()
	{
		ArrayList<String> names = main.getNodes();
		String[] namesArray = new String[names.size()];
		for(int i = 0; i<names.size();i++)
		{
			namesArray[i] = names.get(i);
		}
		return namesArray;
	}
	public static void main(String[] args) throws Exception
	{
		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
