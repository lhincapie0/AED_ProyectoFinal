package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Exception.NodeNotFoundException;
import structure.Algorithms;
import structure.AuxDijkstra;
import structure.Graph;
import structure.ListGraph;
import structure.MatrixGraph;



/**
 * Main class using the two types of Graph implementation
 * @author Laura Hincapie
 *
 * @param <T> Generic Type.
 */
public class Main {

	
	
	public static final String LIST = "Graph by List";
	public static final String MATRIX = "Graph by Matrix";

	
	private ListGraph list;
	private MatrixGraph matrix;
	private Algorithms menu;
	private String actualGraph;
	
	
	public Main() throws Exception
	{
		
		//By default we start working with the graph represented by a list
		actualGraph = LIST;
		list = new ListGraph<String>(false, true);
		matrix = new MatrixGraph<String>(false, true, 65);
		menu = new Algorithms<String>();

		readNodes();
		readEdges();


	}
	
	public void changeGraphRepresentation()
	{
		if(actualGraph.equals(LIST))
		{
			actualGraph = MATRIX;
		} else 
		{
			actualGraph = LIST;
		}
	}
	
	
	public ArrayList<String> getNodes()
	{
		ArrayList<String> nodes;
		
		if(actualGraph.equals(LIST))
		{
			nodes = list.getNodes();
		} else 
		{
			nodes = matrix.getNodes();
		}
		
		return nodes;
	}


	public String getGraphRepresentation()
	{
		return actualGraph;
	}
	
	/**
	 * Reads a file with all the cities that are needed in the map
	 * @param none
	 * @return none
	 */
	public void readNodes() throws IOException
	{

		BufferedReader bf = new BufferedReader(new FileReader(new File("Data/Cities")));
		String city;
		while((city = bf.readLine())!=null) {
			matrix.addNode(city);
			list.addNode(city);
		}			
		
		bf.close();
	}
	

	/**
	 * Reads a file with all the edges that are needed in the map
	 * @param none
	 * @return none
	 */
	public void readEdges() throws IOException
	{

		BufferedReader bf = new BufferedReader(new FileReader(new File("Data/Edges")));
		String edge;
		while((edge = bf.readLine())!=null) {
			String[] data = edge.split(",");
			int weight = Integer.parseInt(data[2]);
			matrix.addEdge(data[0],data[1], weight);
			list.addEdge(data[0],data[1], weight);

			
		}			
		
		bf.close();
	}
	
	public ArrayList<String> getAdyacents(String city)
	{
		ArrayList<String> adjacents;
		if(actualGraph == LIST)
		{
			adjacents = list.getAdjacents(city);
		}else 
		{
			adjacents = matrix.getAdjacents(city);
		}
		
		return adjacents;
	}
	
	
	
	
	
	public ArrayList<String> calculateShortestPath(String origen, String destiny) throws Exception
	{
		AuxDijkstra<Integer,List<String>> path;
		ArrayList<String> names = new ArrayList<String>();

		if(actualGraph== LIST)
		{
			path = menu.DijkstraAlgorithm(list, origen, destiny);
		}else 
		{
			path = menu.DijkstraAlgorithm(matrix, origen, destiny);

		}
		

		return names;
	}
	
	public int calculateDistance(String origen, String destiny) throws Exception
	{
		AuxDijkstra<Integer,List<String>> path;
		
		if(actualGraph== LIST)
		{
			path = menu.DijkstraAlgorithm(list, origen, destiny);
		}else 
		{
			path = menu.DijkstraAlgorithm(matrix, origen, destiny);

		}
		
		return path.getDistance();
	}
	
	public ArrayList<String> getJourney()
	{
		
		Graph<String> graph;
		if(actualGraph == LIST)
		{
			graph = menu.Kruskal(list, LIST);
		}else {

			graph = menu.Kruskal(list, MATRIX);
		}
		
		
		ArrayList<String> edges = new ArrayList<>();
		
		for(int i = 0; i<graph.getEdges().size();i++)
		{
			edges.add(graph.getEdges().get(i).getNode1() + "  --->" +graph.getEdges().get(i).getNode2());
		}
		
		return edges;
	}
	
	
	
}
