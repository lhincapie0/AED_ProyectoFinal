package modelo;

public class Vertex<T> {
	
	private T id;
	
	public Vertex(T id)
	{
		this.id = id;
	}
	
	public void setId(T id)
	{
		this.id = id;
	}
	
	public T getId()
	{
		return id;
	}

}
