package modelo;

import java.util.ArrayList;

//GRAFO NO DIRIGIDO CON PONDERACION
public class ListGraph<T,U> {

	
	// https://github.com/anvicordova/Estructura-de-Datos/blob/master/Grafo%20Dirigido%20con%20Listas%20de%20Adyacencia/src/Grafo.java
	private Node<T>[] graph;
	private int no_Vertex;
	private int vert;
	private int edges;
	
	public ListGraph(int no_Vertex)
	{
		vert = 0;
		edges = 0;
		this.no_Vertex = no_Vertex;
		graph = new Node[no_Vertex];
		for(int i = 0; i<no_Vertex; i++)
		{
			graph[i] = null;
		}
	}
	
	public boolean isEdge(T origen, T destiny)
	{
		int vertex = searchVertex(origen);
		boolean found = false;
		
		if(graph[vertex] == null)
		{
			return found;
		}else 
			{
				Node actual = graph[vertex];
				while(actual!= null && !found)
				{
					if(actual.getVertex().equals(destiny)) {
						found = true;
					}
					actual = actual.getNext();
				}
			}
		return found;
	}

	
	//If you are adding a vertex the value has to be 0
	
	public void addVertex(T v)
	{
		if( vert <no_Vertex)
		{	
			Node<T> vertex = new Node<T>(v,0);
			graph[vert] = vertex;
			vert++;
			//System.out.println("New vertex added: "+ v);
		} else {
			{
				System.out.println("You have exceed the quantity of nodes");
			}
		}
	}
	
	public void addEdge(T origen, T destiny, int value)
	{
		int v1 = searchVertex(origen);
		int v2 = searchVertex(destiny);
		
		if(v1>-1 && v2 > -1)
		{
		
				Node<T> n1 = new Node<T>(destiny, value);
				Node<T> n2 = new Node<T>(origen,value);
				Node<T> actual1 = graph[v1];
				Node<T> actual2 = graph[v2];					
				
				while(actual1.getNext() != null)
				{
					actual1 = actual1.getNext();
				} actual1.setNext(n1); 
				while(actual2.getNext() != null)
				{
					actual2 = actual2.getNext();
				}actual2.setNext(n2); 
				edges++;
			}
		}
	
	public void deleteVertex(T v)
	{
		int vertex = searchVertex(v);
		if(vertex >-1)
		{
			graph[vertex] = null;
		}
	}
	
	public int searchVertex(T vertex)
	{
		int a = -1;
		boolean found = false;
		int i = 0;
		while( i<no_Vertex &&!found)
		{
			if(graph[i].getVertex().equals(vertex))
			{
				a = i;
				found = true;
			}
			i++;
		}
		return a;
	}
	
	public int getNoVertex()
	{
		return vert;
	}
	
	public int getEdges()
	{
		return edges;
	}
	
	public ArrayList<Node> getSucesors(T vertex)
	{
		ArrayList<Node> ad = new ArrayList<>();
		
		int v = searchVertex(vertex);
		
		
		Node<T> actual = graph[v];
		while(actual.getNext()!= null)
		{
			ad.add(actual.getNext());
			actual = actual.getNext();
		}
		
		for(int i = 0; i<ad.size();i++)
		{
			System.out.println(ad.get(i).getVertex());	
		}
		
		return ad;
	}
	
	
	
}
