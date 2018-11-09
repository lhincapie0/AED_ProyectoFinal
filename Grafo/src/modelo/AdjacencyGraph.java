package modelo;

import java.util.ArrayList;

public class AdjacencyGraph<T, U> {

	public static int MAXIMUM = 1000;
	private int[][] adjacencyMatrix;
	private int no_Vertex;
	private Vertex[] vertexs;
	
	private int vert;
	private int edges;
	
	public AdjacencyGraph(int no_Vertex)
	{
		this.no_Vertex = no_Vertex;
		adjacencyMatrix = new int[no_Vertex][no_Vertex];
		vertexs = new Vertex[no_Vertex];
		vert = 0;
		edges = 0;
		
		//the adjacencyMatrix starts with no edges
		for(int origen = 0; origen < no_Vertex;origen++)
		{
			for(int destiny = 0; destiny < no_Vertex; destiny++)
			{
				adjacencyMatrix[origen][destiny] = 0;
			}

		}
	}
	
	
	public void addVertex(T id)
	{
		Vertex<T> v = new Vertex<T>(id);
		vertexs[vert] = v;
		vert++;
	}
	
	
	
	public void addEdge( T origen, T destiny, int value)
	{
		int v1 = searchVertex(origen);
		int v2 = searchVertex(destiny);
		
		if(v1>-1 && v2>-1)
		{
			if (adjacencyMatrix[v1][v2] == 0)
			{
				adjacencyMatrix[v1][v2] = value;
				edges++;
			}
			else
			{
				//For no multigraphs
				System.out.println("Edge allready defined"); 
			}
		}else 
		{
			System.out.println("One of the vertexs doesn´t exist");
		}
		
	}
	
	
	
	
	public void deleteEdge(T origen, T destiny)
	{
		int v1 = searchVertex(origen);
		int v2 = searchVertex(destiny);
		
		if(v1 >-1 && v2>-1)
		{
			if( 	adjacencyMatrix[v1][v2] !=0)
			{
				adjacencyMatrix[v1][v2] = 0;
				edges--;
			}
		}
	}
	
	public void deleteVertex(T vertex)
	{
		int v = searchVertex(vertex);
		vertexs[v] = null;
		vert--;
		for(int i = 0; i< no_Vertex; i++)
		{
			if( adjacencyMatrix[v][i] !=0)
			{
				adjacencyMatrix[v][i] = 0;
				edges--;
			}
			if( adjacencyMatrix[i][v] !=0)
			{
				adjacencyMatrix[i][v] = 0;
				edges--;
			}		
				
		}
	}

	public int getNoVertex()
	{
		return vert;
	}
	
	public int getNoEdges()
	{
		return edges;
	}
	
	
	
	//make a more efficent method
	public int searchVertex(T v)
	{
		int vf = -1;
		boolean found = false;
		for(int i = 0; i<no_Vertex && !found; i++)
		{
			if(v.equals(vertexs[i].getId()))
			{
				vf = i;
				found = true;
			}
		}
		return vf;
	}
	
	

	public int searchEdge(T origen, T destiny)
	{
		int v1 = searchVertex(origen);
		int v2 = searchVertex(destiny);
		if(v1 >-1 && v2>-1)
		{
			return adjacencyMatrix[v1][v2];	
		}
		else
			return 0;
	}
	
	
	public ArrayList<Vertex> getSucesors(T v)
	{
		ArrayList<Vertex> ad = new ArrayList<>();
		int v1 =searchVertex(v);
		for(int i = 0; i< no_Vertex; i++)
		{
			if (adjacencyMatrix[v1][i] != 0)
			{
				ad.add(vertexs[i]);
			}
		}
		
		return ad;
		
	}
	
	
	public int[] dijkstra(int source) 
	{ 
		boolean visited[] = new boolean[no_Vertex];
		int[] distance = new int[no_Vertex];

	
		for(int i = 0;i<no_Vertex; i++)
		{
			distance[i] = MAXIMUM;
			visited[i] = false;
		}
		distance[source] = 0;	
		for(int counter = 0; counter < no_Vertex-1; counter++)
		{
			int picked = minimunDistance(distance, visited);
			
			visited[picked] = true;
			
			 for (int v = 0; v < no_Vertex; v++) 
				  
	                if (!visited[v] && adjacencyMatrix[picked][v]!=0 && 
	                        distance[picked] != Integer.MAX_VALUE && 
	                        distance[v]+adjacencyMatrix[picked][v] < distance[v]) 
	                    distance[v] = distance[picked] + adjacencyMatrix[picked][v]; 
		}
		
		return distance;
	}
	
	public int minimunDistance(int[] distance, boolean[] visited)
	{
		int min = MAXIMUM;
		int min_index=-1; 
		  
        for (int v = 0; v < no_Vertex; v++) 
            if (visited[v] == false && distance[v] <= min) 
            { 
                min = distance[v]; 
                min_index = v; 
            } 
  
        return min_index; 
		
	}
	
	
	
}
