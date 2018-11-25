package structure;


public class Edge<T> implements Comparable<Edge<T>>{

	private Node<T> node1;
	private Node<T> node2;
	
	private int weight;
	
	public Edge(Node<T> node1, Node<T> node2, int weight)
	{
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	
	public Node<T> getNode1()
	{
		return node1;
	}
	
	public Node<T> getNode2()
	{
		return node2;
	}
	
	public int getWeigth()
	{
		return weight;
	}	

	public void setWeight(int weight )
	{
		this.weight = weight;
	}


	@Override
	public int compareTo(Edge<T> e1) {
		Edge<T> edge = (Edge<T>) e1;
		if(edge.getWeigth() > weight)
		{
			return -1;
		} else if (edge.getWeigth() < weight)
		{
			return 1;
		}else {
			return 0;
		}
	}

	
}
