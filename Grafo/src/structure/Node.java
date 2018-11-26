package structure;

public class Node<T> {

	private T value;
	private boolean visited;
	
	
	private int x;
	private int y;
	
	public Node(T value)
	{
		this.value = value;
	}
	
	public Node(T value, int x,int y)
	{
		this.value = value;
		this.x = x;
		this.y = y;
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

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
