package modelo;



//GRAFO NO DIRIGIDO CON PONDERACION
public class ListGraph<T,U> {

	
	// https://github.com/anvicordova/Estructura-de-Datos/blob/master/Grafo%20Dirigido%20con%20Listas%20de%20Adyacencia/src/Grafo.java
	@SuppressWarnings("rawtypes")
	private Node[] graph;
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
	
	
	public static void main(String[] args)
	{
		ListGraph<String, Integer>graph = new ListGraph<>(4);
		graph.addVertex("Cali");
		graph.addVertex("Bogota");
		graph.addVertex("Santa Marta");
		graph.addVertex("Barranquilla");
		graph.addEdge("Cali", "Bogota", 30);
		graph.addEdge("Cali", "Barranquilla", 80);
		graph.addEdge("Cali", "Santa Marta", 100);
		graph.addEdge("Bogota", "Cali", 30);
		graph.addEdge("Bogota", "Santa Marta", 20);
		System.out.println("puta");
		System.out.println(graph.isEdge("Bogota", "Cali"));
	}
	
}
