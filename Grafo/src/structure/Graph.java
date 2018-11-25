package structure;

import java.util.ArrayList;

import Exception.NodeNotFoundException;

public interface Graph<T> {

	
	public boolean isDirected();
	public void addNode(T node);
	public void addEdge(T node1, T node2, int weight);
	public Node<T>  searchNode(T node) throws NodeNotFoundException;
	public Edge<T> searchEdge(T node1, T node2);

	public ArrayList<T> getAdjacents(T node);
	public ArrayList<T> getNodes();
	public ArrayList<Edge<T>> getEdges();
	public ArrayList<Edge<T>> getAdjacentEdges(T node) throws NodeNotFoundException;
	public boolean deleteNode(T node) throws NodeNotFoundException;
	public boolean deleteEdge(T node1, T node2);
	public boolean isEdge(T node1, T node2);
	public boolean isNode(T node1);
	public void cleanGraph();



}
