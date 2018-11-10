package modelo;

public class Node<T>
{
	private T vertex;
	private int valueEdge;
	private Node next;
	
	public Node(T vertex, int valueEdge)
	{
		this.vertex = vertex;
		this.valueEdge = valueEdge;
		this.next = null;
	}
	
	public T getVertex()
	{
		return vertex;
	}
	
	public int getValue()
	{
		return valueEdge;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}
