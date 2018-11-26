package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import Exception.NodeNotFoundException;

public class MatrixGraph<T> implements Graph<T>{

	
	
	
	private boolean isDirected;
	private boolean isWeighted;
	private ArrayList<Edge<T>>[][] matrix;
	private ArrayList<Node<T>> nodes;
	private HashMap<T, Integer> nodesMap;
	private int size;
	private ArrayList<Edge<T>> edges;
	private int nnodes;
	
	
	public MatrixGraph(boolean isDirected, boolean isWeighted, int n)
	{
		nnodes = n;
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		nodes = new ArrayList<Node<T>>();
		matrix = new ArrayList[n][n];
		nodesMap = new HashMap<T, Integer>();
		size = 0;
		edges = new ArrayList<Edge<T>>();
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize( int size)
	{
		this.size = size;
	}
	
	
	public boolean isWeighted()
	{
		return isWeighted;
	}
	@Override
	public boolean isDirected() {
		return isDirected;
	}
	
	
	public ArrayList<Node<T>> getNodes1()
	{
		return nodes;
	}
	
	public ArrayList<Edge<T>>[][] getMatrix()
	{
		return matrix;
	}

	@Override
	public void addNode(T node) {
		
		if(nodesMap.containsKey(node) == false)
		{
			Node<T> n = new Node<T>(node);
			nodesMap.put(node,nodes.size());
			nodes.add(n);
			size = nodes.size();
		}
	}
	
	public void addNodeXY(T node, int x, int y)
	{
		if(nodesMap.containsKey(node) == false)
		{
			Node<T> n = new Node<T>(node,x,y);
			nodesMap.put(node,nodes.size());
			nodes.add(n);
			size = nodes.size();
		}
	}

	@Override
	public void addEdge(T node1, T node2, int weight) {
		
			@SuppressWarnings("unchecked")
			Node<T> n1 = searchNode(node1);
			@SuppressWarnings("unchecked")
			Node<T> n2 = searchNode(node2);
		
			
		int i1 = nodesMap.get(n1.getValue());
		int i2 = nodesMap.get(n2.getValue());
		Edge<T> edge = new Edge<T>(n1,n2, weight);
		
		if(matrix[i1][i2] == null)
		{
			matrix[i1][i2] = new ArrayList<Edge<T>>();
		
			matrix[i1][i2].add(edge);
		} else {
			if (weight < matrix[i1][i2].get(0).getWeigth()) {
				if (isWeighted) {
					edge.setWeight(weight);
				}

				matrix[i1][i2].set(0, edge);
			}
		}
		edges.add(edge);
	}

	@Override
	public Node searchNode(T node) {
		
		if(nodesMap.containsKey(node))
		{
			return nodes.get(nodesMap.get(node));
		}else
		{
			return null;
		}
	}

	@Override
	public Edge searchEdge(T node1, T node2) {
		Edge<T> edge = null;

		int i1 = nodesMap.get(node1);
		int i2 = nodesMap.get(node2);

		if (matrix[i1][i2] != null) {

			edge = matrix[i1][i2].get(0);
		}

		return edge;
	}

	@Override
	public ArrayList<T> getAdjacents(T node) {
		ArrayList<T> ady = new ArrayList<T>();
		int nodo = nodesMap.get(node);
		System.out.println("NODO NUMERO" + nodo);

		for (int i = 0; i < matrix.length; i++) {
		
				if (matrix[nodo][i] != null) {
					ady.add(nodes.get(i).getValue());
				
				}
			}
		return ady;
	}

	@Override
	public ArrayList<Edge<T>> getEdges() {
		return edges;
	}

	
	public HashMap<T, Integer> getNodesMap()
	{
		return nodesMap;
	}
	@Override
	public ArrayList getAdjacentEdges(T node) throws NodeNotFoundException {
		int j = nodesMap.get(node);
		ArrayList<Edge<T>> adjacents = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[j][i] != null) {
				if (matrix[j][i].get(0) != null) {
					adjacents.add(matrix[j][i].get(0));
				}
			}
		}
		return adjacents;
	}

	@Override
	public boolean deleteNode(T node) throws NodeNotFoundException {
			
		boolean resp = false;

		if (searchNode(node) != null) {
			Node<T> dele = searchNode(node);
			nodes.remove(dele);
			size = nodes.size();
			resp = true;
		}
		return resp;
	}

	
	

	
	@Override
	public boolean deleteEdge(T node1, T node2) {
		
		int n1 = nodes.indexOf(node1);
		int n2 = nodes.indexOf(node2);
		matrix[n1][n2] = null;
		
		return false;
	}

	@Override
	public boolean isEdge(T node1, T node2) {
		
		boolean found = false;
		int n1 = nodesMap.get(node1);
		int n2 = nodesMap.get(node2);
		
		if(isNode(node1) && isNode(node2))
		{
			if(matrix[n1][n2] != null)
			{
				found = true;
			}
		}
		return found;
		
	}

	@Override
	public boolean isNode(T node) {
		boolean found = false;
		for(int i = 0; i<nodes.size() & !found ; i++)
		{
			if(nodes.get(i).getValue().equals(node));
			{
				found = true;
			}
		}
		return found;
	}

	@Override
	public void cleanGraph() {
			for (int i = 0; i < nodes.size(); i++) {
			
					nodes.get(i).setVisited(false);
			}
	}
		
		
	

	@Override
	public ArrayList<T> getNodes() {
		ArrayList<T> nodesValues = new ArrayList<>();
		for(int i = 0; i<nodes.size();i++)
		{
			nodesValues.add(nodes.get(i).getValue());
		}
		
		return nodesValues;
	}

}
