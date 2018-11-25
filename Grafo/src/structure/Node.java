package structure;

public class Node<T> {

	private T value;
	private boolean visited;
	
	public Node(T value)
	{
		this.value = value;
	}
	
	
	public T getValue()
	{
		return value;
	}
	
	public void setValue()
	{
		this.value = value;
	}
	
	public boolean isVisited()
	{
		return visited;
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

}
