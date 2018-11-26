package structure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Exception.NodeNotFoundException;
import view.EdgeView;



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
	private ArrayList<EdgeView> edgesXY;
	
	
	public Main() throws Exception
	{
		
		//By default we start working with the graph represented by a list
		actualGraph = LIST;
		list = new ListGraph<String>(false, true);
		matrix = new MatrixGraph<String>(false, true, 65);
		menu = new Algorithms<String>();

		
	 edgesXY = new ArrayList<>();
		readNodes();
		readEdges();

		ArrayList<String> g = menu.BFS(list, "Berlin");
		for(int i = 0; i<g.size();i++)
		{
			System.out.println(g.get(i));
		}
		
		
		
	}
	
	//opcion 0 DFS
	//opcion 1 BFS
	//opcion 0 List
	//opcion 1 Graph
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getAllCities(int opcion, int graph, String origen ) throws NodeNotFoundException
	{
		ArrayList<String> listM = new ArrayList<>();
		System.out.println(origen);
		listM = menu.BFS((Graph) list, "Berlin");

		for(int i = 0; i<listM.size(); i++)
		{
			System.out.println(listM.get(i));
		}		return listM;
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
	@SuppressWarnings("unchecked")
	public void readNodes() throws IOException
	{

		BufferedReader bf = new BufferedReader(new FileReader(new File("Data/CitiesXY")));
		String city;
		while((city = bf.readLine())!=null) {
			
			String[] data = city.split(",");
			String name = data[0];
			int x = Integer.parseInt(data[1]);
			int y = Integer.parseInt(data[2]);

			matrix.addNodeXY(name,x,y);
			list.addNodeXY(name,x,y);
		}			
		
		bf.close();
	}
	

	public ArrayList<EdgeView> getEdgesData()
	{
		return edgesXY;
	}
	
	/**
	 * Reads a file with all the edges that are needed in the map
	 * @param none
	 * @return none
	 * @throws NodeNotFoundException 
	 */
	public void readEdges() throws IOException, NodeNotFoundException
	{

		
		BufferedReader bf = new BufferedReader(new FileReader(new File("Data/Edges")));
		String edge;
		while((edge = bf.readLine())!=null) {
			String[] data = edge.split(",");
			int weight = Integer.parseInt(data[2]);
			matrix.addEdge(data[0],data[1], weight);
			list.addEdge(data[0],data[1], weight);

			Node<String> n1 = matrix.searchNode(data[0]);
			Node<String> n2 = matrix.searchNode(data[1]);
			
			EdgeView ev = new EdgeView(n1.getX(), n2.getX(), n1.getY(), n2.getY());
			edgesXY.add(ev);
			

			
			
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
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Node<String>> getNodesData()
	{
		ArrayList<Node<String>> nodes = new ArrayList<Node<String>>() ;
		
		if(actualGraph == MATRIX)
		{
			nodes = matrix.getNodes1();
		}
		else
		{
			nodes = list.getNodes1();
		}
		
		return nodes;
	}
	
	
	public List<String> calculateShortestPath(String origen, String destiny) throws Exception
	{
		AuxDijkstra<Integer,List<String>> path;
		List<String> names = new ArrayList<String>();

		if(actualGraph== LIST)
		{
			path = menu.DijkstraAlgorithm(list, origen, destiny);
			names = path.getPath();
		}else 
		{
			path = menu.DijkstraAlgorithm(matrix, origen, destiny);
			names = path.getPath();

		}
		

		return names;
	}

	
	public int getShortestDistance(String origen, String destiny) throws Exception
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
	
	public ArrayList<String> getJourney() throws NodeNotFoundException
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
		
		for( int i = 0; i<edges.size(); i++)
			{
			System.out.println(edges.get(i));
			}
		
		return edges;
	}
	
	
	
}
