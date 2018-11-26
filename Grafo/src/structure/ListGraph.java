
package structure;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;


import Exception.NodeNotFoundException;

public class ListGraph<T> implements Graph<T>{

	
	//Characteristics of the Graph
	private boolean isDirected;
	private boolean isWeighted;
	private ArrayList<Edge<T>> edges;
	private ArrayList<LinkedList<Node<T>>> nodes;
	private Hashtable<T, Hashtable<T, Integer>> weights;
	
	
	
	public ListGraph(boolean isDirected, boolean isWeighted)
	{
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		nodes = new ArrayList<LinkedList<Node<T>>>();
		edges = new ArrayList<Edge<T>>();
		
		if(isWeighted == true)
		{
			weights = new Hashtable<T, Hashtable<T, Integer>>();
		}
	}
	
	
	
	
	public Hashtable<T, Hashtable<T, Integer>> getWeights()
	{
		return weights;
	}

	@Override
	public boolean isDirected() {
		return isDirected;
	}

	public boolean isWeighted()
	{
		return isWeighted;
	}
	
	public void setAristas(ArrayList<Edge<T>> edges) {
		this.edges = edges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addNode(T node) {
		
		boolean founded = false;
		
		//We verify that the node doesnt already exist
		
		for(int i = 0;i<nodes.size() && !founded; i++) {
			if(nodes.get(i).get(0).getValue().equals(node))
			{
				founded = true;
			}
		}
		
		//If the node wasn´t found we add the new node to the arrayList of nodes, creating a new LinkedList to save its adjacency nodes
		if(!founded)
		{
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
			Node<T> newNode = new Node<T>(node);
			list.add(newNode);
			nodes.add(list);
		}
		
		if(isWeighted)
		{
			if(weights.get(node) == null)
			{
				weights.put(node, new Hashtable<T, Integer>());
			}
		}
	}
	
	public void addNodeXY(T node, int x, int y) {
		
		boolean founded = false;
		
		//We verify that the node doesnt already exist
		
		for(int i = 0;i<nodes.size() && !founded; i++) {
			if(nodes.get(i).get(0).getValue().equals(node))
			{
				founded = true;
			}
		}
		
		//If the node wasn´t found we add the new node to the arrayList of nodes, creating a new LinkedList to save its adjacency nodes
		if(!founded)
		{
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
			Node<T> newNode = new Node<T>(node, x,  y);
			list.add(newNode);
			nodes.add(list);
		}
		
		if(isWeighted)
		{
			if(weights.get(node) == null)
			{
				weights.put(node, new Hashtable<T, Integer>());
			}
		}
	}


	@Override
	public void addEdge(T n1, T n2, int weight)   {
		
		if (isNode(n1) && isNode(n2)) {

			if (isDirected) {

				boolean c = false;
				for (int i = 0; i < nodes.size() && !c; i++) {
					if (nodes.get(i).get(0).getValue().equals(n1)) {
						c = true;
						boolean c1 = false;
						for (int j = 0; j < nodes.get(i).size() && !c1; j++) {
							if (nodes.get(i).get(j).getValue().equals(n2)) {
								c1 = true;
							}
						}
						if (!c1) {
							nodes.get(i).add(new Node<T>(n2));
						}
					}

				}

			} else {


			//	Edge<T> e = new Edge<>(searchNode(n1), searchNode(n2), weight);
			//	edges.add(e);
				int n = 0;

				while (n < 2) {

					if (n == 1) {
						T n3 = n1;
						n1 = n2;
						n2 = n3;
					}

					boolean c = false;
					for (int i = 0; i < nodes.size() && !c; i++) {
						if (nodes.get(i).get(0).getValue().equals(n1)) {
							c = true;
							boolean c1 = false;
							for (int j = 0; j < nodes.get(i).size() && !c1; j++) {
								if (nodes.get(i).get(j).getValue().equals(n2)) {
									c1 = true;
								}
							}
							if (!c1) {
								nodes.get(i).add(new Node<T>(n2));
							}
						}

					}

					n++;
				}

			}

			if (isWeighted) {
				if (isDirected) {
					if (weights.get(n1).get(n2) == null) {
						weights.get(n1).put(n2, weight);
					}

				} else {
					if (weights.get(n1).get(n2) == null) {
						weights.get(n1).put(n2, weight);
					}
					if (weights.get(n2).get(n1) == null) {
						weights.get(n2).put(n1, weight);
					}

				}
			}

		}


	
	}

	@Override
	public Node<T> searchNode(T node) throws NodeNotFoundException {
	
		Node<T> n = null;
	
		if(isNode(node))
		{
			
			boolean founded = false;
			for(int i = 0; i<nodes.size() && !founded; i++)
			{
				if(nodes.get(i).get(0).getValue().equals(node))
				{
					founded = true;
					n = nodes.get(i).get(0);				}
			}
		}
		
		return n;
	}
	

	@Override
	public Edge<T> searchEdge(T node1, T node2) {
		
		if(edges.size() == 0)
		{
			getEdges();
		}
		
		Edge<T> edge = null;
		boolean found = false;
		for(int i = 0; i<edges.size() && !found;i++)
		{
			if(edges.get(i).getNode1().getValue().equals(node1) && edges.get(i).getNode2().getValue().equals(node2))
			{
				edge = edges.get(i);
				found = true;
			}
		}
		
		return edge;
	}



	@Override
	public ArrayList<T> getAdjacents(T node) {

		ArrayList<T> ady = new ArrayList<T>();

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).get(0).getValue().equals(node)) {
				for (int j = 1; j < nodes.get(i).size(); j++) {
					ady.add(nodes.get(i).get(j).getValue());
				}
			}
		}

		return ady;
	}

	@Override
	public ArrayList<T> getNodes() {
		
		ArrayList<T> nodesList = new ArrayList<T>();
		for(int i = 0; i<nodes.size();i++)
		{
			nodesList.add(nodes.get(i).get(0).getValue());
		}
		return nodesList;
	}

	
	public ArrayList<Node<T>> getNodes1()
	{
		ArrayList<Node<T>> n = new ArrayList<Node<T>>();
		for(int i = 0; i<nodes.size();i++)
		{
			n.add(nodes.get(i).get(0));
		}
		return n;
	}
	@Override
	public ArrayList<Edge<T>> getEdges() {
		if (isDirected) {

			for (int i = 0; i < nodes.size(); i++) {
				for (int j = 1; j < nodes.get(i).size(); j++) {
					Node<T> nodeI = nodes.get(i).get(0);
					Node<T> nodeF = nodes.get(i).get(j);
					Integer weigth = weights.get(nodeI.getValue()).get(nodeF.getValue());
					Edge<T> edge = new Edge<T>(nodeI, nodeF, weigth);
					edges.add(edge);
				}
			}

		} else {

			for (int i = 0; i < nodes.size(); i++) {
				for (int j = 1; j < nodes.get(i).size(); j++) {
					Node<T> nodeI = nodes.get(i).get(0);
					Node<T> nodeF = nodes.get(i).get(j);
					Integer weigth = weights.get(nodeI.getValue()).get(nodeF.getValue());
					Edge<T> edge = new Edge<>(nodeI, nodeF, weigth);
					edges.add(edge);
					}
				}
			}

		

		return edges;

	}

	@Override
	public ArrayList<Edge<T>> getAdjacentEdges(T node) throws NodeNotFoundException {
		
		ArrayList<Edge<T>> adjacents = new ArrayList<Edge<T>>();
		if(edges.size() == 0)
		{
			getEdges();
		}
		for(int i = 0; i<edges.size();i++)
		{
			if(edges.get(i).getNode1().getValue().equals(node))
			{
				adjacents.add(edges.get(i));
			}
		}
		return edges;
	}

	@Override
	public boolean deleteNode(T node) throws NodeNotFoundException {
		
		boolean founded = false;
		
		for (int i = 0; i<nodes.size(); i++)
		{
			if(!founded)
			{
				for(int j = 0; j<nodes.get(i).size(); j++) {
					if(nodes.get(i).get(j).getValue().equals(node))
					{
						if(nodes.get(i).remove(j) != null)
						{
							founded = true;
						}
					}
				}
			} else 
			{
				for(int j = 0; j<nodes.get(i).size(); j++) {
					if(nodes.get(i).get(j).getValue().equals(node)){
						nodes.get(i).remove(j);
					}
				}
			}
		}
		
			
			//Delete in the weighted table
			if(isWeighted)
			{
				weights.remove(node);
				for(int i= 0; i<nodes.size();i++)
				{
					if(weights.get(nodes.get(i).get(0).getValue()).get(node) != null)
					{
						weights.get(nodes.get(i).get(0).getValue()).remove(node);
					}
				
				}	
				}
			
			return founded;
	}
	

	@Override
	public boolean deleteEdge(T node1, T node2) {
		boolean found = false;

		if (isDirected) {

			for (int i = 0; i < nodes.size() && !found; i++) {
				if (nodes.get(i).get(0).getValue().equals(node1)) {
					for (int j = 0; j < nodes.get(i).size() && !found; j++) {
						if (nodes.get(i).get(j).getValue().equals(node2)) {
							if (nodes.get(i).remove(j) != null) {
								found = true;
							}
						}
					}
				}
			}

		} else {
			int c = 0;
			for (int i = 0; i < nodes.size(); i++) {
				if (nodes.get(i).get(0).getValue().equals(node1)) {
					for (int j = 0; j < nodes.get(i).size(); j++) {
						if (nodes.get(i).get(j).getValue().equals(node2)) {
							if (nodes.get(i).remove(j) != null) {
								c++;
							}
						}
					}
				}
				if (nodes.get(i).get(0).getValue().equals(node2)) {
					for (int j = 0; j < nodes.get(i).size(); j++) {
						if (nodes.get(i).get(j).getValue().equals(node1)) {
							if (nodes.get(i).remove(j) != null) {
								c++;
							}
						}
					}
				}
			}
			if (c == 2) {
				found = true;
			}
		}

		if (isNode(node1) && isNode(node2)) {
			if (isWeighted) {
				if (isDirected) {
					weights.get(node1).remove(node2);
				} else {
					weights.get(node1).remove(node2);
					weights.get(node2).remove(node1);
				}
			}
		}

		return found;
	}

	@Override
	public boolean isEdge(T node1, T node2) {
		
		
		boolean founded = false;

		if (isNode(node1) && isNode(node2)) {

			for (int i = 0; i < nodes.size() && !founded; i++) {
				if (nodes.get(i).get(0).getValue().equals(node1)) {
					for (int j = 1; j < nodes.get(i).size(); j++) {
						if (nodes.get(i).get(j).getValue().equals(node2)) {
							founded = true;
						}
					}
				}
			}
		}

		return founded;
	
	
	}

	@Override
	public boolean isNode(T node) {
		
		
		boolean founded = false;
		for(int i = 0; i<nodes.size() &!founded; i++)
		{
			if(nodes.get(i).get(0).getValue().equals(node))
			{
				founded = true;
			}
		}
		
		return founded;
	}

	@Override
	public void cleanGraph() {
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = 0; j < nodes.get(i).size(); j++) {
				nodes.get(i).get(j).setVisited(false);
			}
	}
	}
	
	

	
}
