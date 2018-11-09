package modelo;

public class Edge<T,U> {

	
	private Vertex<T> origen;
	private Vertex<T> destiny;
	private U value;

	public Edge(Vertex<T> origen, Vertex<T> destiny, U value)
	{
		this.origen = origen;
		this.destiny = destiny;
		this.value = value;
	}
	
	public U getValue()
	{
		return value;
	}
	
	public Vertex<T> getOrigen() {
		return origen;
	}
	
	
	public Vertex<T> getDestiny()
	{
		return destiny;
	}

	public void setValue(U value)
	{
		this.value = value;
	}

}
