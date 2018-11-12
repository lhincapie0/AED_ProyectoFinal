package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyGraph<T, U> {

	public static int MAXIMUM = 1000;
	public int[][] adjacencyMatrix;
	private int no_Vertex;
	private static Vertex[] vertexs;
	
	
	//for the Dijsktra algorithm
	private int[] distance; 
	@SuppressWarnings("rawtypes")
	private static ArrayList<Vertex> path;
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
		
		distance = new int[no_Vertex+1];
	}
	
	
	public int[] getDistances()
	{
		return distance;
	}
	
	public void reviewPath(int w)
	{
		if(path.size()==1)
		{
			
				path.add(vertexs[w]);
				
			
		}	
	}
	
	
	
	
	 public void calc(int n,int origen, int end)
	 {
	  int flag[] = new int[n];
	  int i,minpos=0,k,c,minimum;
	  
	  path = new ArrayList<Vertex>();
	  
	  
	  for(i=0;i<n;i++)
	  {  
	            flag[i]=0; 
	      this.distance[i]=this.adjacencyMatrix[origen][i]; 
	    }
	     c=1;
	  while(c<n)
	  {
	   minimum=99;
	   for(k=0;k<n;k++)
	   { 
	          if(this.distance[k]<minimum && flag[k]!=1)
	       {
	        minimum=this.distance[i];
	        minpos=k;
	       }
	      } 
	            flag[minpos]=1;
	      c++;
	      for(k=0;k<n;k++)
	 {
	         if(this.distance[minpos]+this.adjacencyMatrix[minpos][k] <  this.distance[k] && flag[k]!=1 )
	    this.distance[k]=this.distance[minpos]+this.adjacencyMatrix[minpos][k];
	         if(k == end)
				{
					path.add(vertexs[minpos]);
					//path.add(vertexs[k]);
				}
	         	
	 }   
	  } 
	  reviewPath(end);
	 }
	
	//Dijsktra
	public void calculateMinimunDistance(int n, int origen, int end)
	{
		int flag[] = new int[n];
		path = new ArrayList<Vertex>();
		path.add(vertexs[origen]);

		int i = 0;
		int k = 0;
		int c = 0;
		int minimum = 0;
		int minimumPosition = 1;
		
		for( i = 0; i<n; i++)
		{
			flag[i] = 0;
			distance[i] = adjacencyMatrix[origen][i];
		}
		
		c = 1;
		while(c<n)
		{
			minimum = 99;
			for(k = 0; k<n; k++)
			{
				if((distance[k] < minimum) && flag[k] != 1)
				{
					minimum = distance[i-1];
				
					

				}
			}
			flag[minimumPosition] = 1 ;
			c++;
			
			for(k = 0; k<n; k++)
			{
				if(distance[minimumPosition] + adjacencyMatrix[minimumPosition][k] < distance[k] && flag[k] != 1)
				{
	
					distance[k] = distance[minimumPosition] + adjacencyMatrix[minimumPosition][k];
					if(k == end)
					{
						path.add(vertexs[minimumPosition]);
						path.add(vertexs[k]);
					}
				}
			}
		}
		System.out.println(distance[end]);
		reviewPath(end);
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
	
	
	@SuppressWarnings("rawtypes")
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
		
		
		for(int i = 0; i<ad.size(); i++)
		{
			System.out.println( ad.get(i).getId());
		}
		return ad;
		
	}
	
	
	public static void main(String[] args) 
	{
	
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el numero de nodos");
		int n = in.nextInt();
		AdjacencyGraph<String, Integer > graph = new AdjacencyGraph<>(n);
		in.nextLine();
		for(int i = 0; i<n;i++)
		{
			vertexs[i] = new Vertex<String>(in.nextLine());
		}
		
		System.out.println("Ingrese la matriz con las distancias respectivas");	
		for(int i = 0; i<n;i++)
		{
			String cad = in.nextLine();
			String[] w = cad.split(" ");
			for(int j = 0; j<n; j++)
			{
				
				if((w[j].equals("0")))
				{
					graph.adjacencyMatrix[i][j] = 0;
				}else
				{int a =Integer.parseInt(w[j]);
				graph.adjacencyMatrix[i][j] = a;
				}
				
			}
		}
		

		for(int i = 0; i<graph.adjacencyMatrix.length; i++)
		{
			for(int j = 0; j< graph.adjacencyMatrix[0].length;j++)
			{
				System.out.print(graph.adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Ingrese un origen");
		String origen = in.nextLine();

		System.out.println("Ingrese un destino");
		String destino = in.nextLine();
		
		int v1 = graph.searchVertex(origen);

		int v2 = graph.searchVertex(destino);
		graph.calc(n, v1,v2);
		System.out.println("PATH");
		for(int i = 0; i<path.size(); i++) {
			System.out.println(path.get(i).getId());
		}
		
		for(int w = 0; w< n; w++)
		{
			System.out.println("Distance to :" + vertexs[w].getId() +"-->"+ graph.distance[w]);
		}
	
	}
	

	
	
	
	

	
	
	
}

