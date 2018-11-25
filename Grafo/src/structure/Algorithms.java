package structure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import Exception.NodeNotFoundException;
import modelo.Main;

public class Algorithms<T> {

	
	
	private Main main;
	
	@SuppressWarnings("unchecked")
	public Algorithms(  ) throws Exception 
	{
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		Algorithms m = new Algorithms();
	}

	
	public ArrayList<T> BFS(Graph<T> graph, T startNode) throws NodeNotFoundException   {

		graph.cleanGraph();

		if (graph.isNode(startNode)) {

			LinkedList<T> queue = new LinkedList<T>();
			queue.add(startNode);
			graph.searchNode(startNode).setVisited(true);
			ArrayList<T> array = new ArrayList<T>();
			while (!queue.isEmpty()) {
				T actual = queue.poll();
				array.add(actual);
				ArrayList<T> aux = graph.getAdjacents(actual);
				for (int i = 0; i < aux.size(); i++) {
					T next = aux.get(i);
					if (graph.searchNode(next).isVisited() == false) {
						graph.searchNode(next).setVisited(true);
						queue.add(next);
					}
				}

			}

			return array;
		} else {
			return null;
		}
	}
	

	public ArrayList<T> DFS(Graph<T> graph, T startNode) throws NodeNotFoundException   {

	if (graph.isNode(startNode)) {

			ArrayList<T> array = new ArrayList<T>();
			graph.searchNode(startNode).setVisited(true);
			array.add(startNode);
			ArrayList<T> aux = graph.getAdjacents(startNode);
			for (int i = 0; i < aux.size(); i++) {
				T next = aux.get(i);
				if (graph.searchNode(next).isVisited() == false) {
					ArrayList<T> array2 = DFS(graph, next);
					for (int j = 0; j < array2.size(); j++) {
						array.add(array2.get(j));
					}
				}
			}

			return array;

		} else {
			return null;
		}
	}

	
	public AuxDijkstra<Integer,List<T>> DijkstraAlgorithm(Graph<T>graph, T start, T end) throws Exception{
		if(!graph.getNodes().contains(start) || !graph.getNodes().contains(end)) {
			throw new Exception("Some of the specified elements are not part of the Graph");
		}
		Set<T> Q = new HashSet<T>(graph.getNodes());
		HashMap<T,AuxDijkstra<Integer,T>>table=new HashMap<T,AuxDijkstra<Integer,T>>(graph.getNodes().size());
		for (T aux : graph.getNodes()) {
			table.put(aux, new AuxDijkstra<Integer,T>(Integer.MAX_VALUE,null));
		}
		table.replace(start, new AuxDijkstra<Integer,T>(0,null));
		while(!Q.isEmpty()) {
			T minV=null;
			double minD=Integer.MAX_VALUE;
			for (T aux : Q) {
				if(table.get(aux).distance<=minD) {
					minV=aux;
					minD=table.get(aux).distance;
				}
			}
			T u=minV;
			Q.remove(minV);	
			for (T v : graph.getAdjacents((u)) ){
				int alt=table.get(u).distance+graph.searchEdge(u,v).getWeigth();
				if(alt<table.get(v).distance) {
					table.get(v).distance=(int) alt;
					table.get(v).path=u;
				}
			}
		}
		for (T aux: table.keySet()) {
			System.out.println(aux+" : "+table.get(aux).distance+" : "+table.get(aux).path);
		}
		ArrayList<T>path=new ArrayList<T>();
		T current1=end;
		while(current1!=null) {
			path.add(0, current1);
			current1=table.get(current1).path;
		}
		if(table.get(end).distance==Integer.MAX_VALUE) {
			path=new ArrayList<T>();
		}
		return new AuxDijkstra<Integer,List<T>>(table.get(end).distance,path);
	}
	
	
	public AuxDijkstra<Integer,List<T>> DijkstraAlgorithm2(Graph<T>graph, T start, T end) throws Exception{
		if(!graph.getNodes().contains(start) || !graph.getNodes().contains(end)) {
			throw new Exception("Some of the specified elements are not part of the Graph");
		}
		Set<T>Q=new HashSet<T>(graph.getNodes());
		HashMap<T,AuxDijkstra<Integer,T>>table=new HashMap<T,AuxDijkstra<Integer,T>>(graph.getNodes().size());
		for (T aux : graph.getNodes()) {
			table.put(aux, new AuxDijkstra<Integer,T>(Integer.MAX_VALUE,null));
		}
		table.replace(start, new AuxDijkstra<Integer,T>(0,null));
		
		while(!Q.isEmpty()) {
			T minV=null;
			double minD=Integer.MAX_VALUE;
			for (T aux : Q) {
				if(table.get(aux).distance<=minD) {
					minV=aux;
					minD=table.get(aux).distance;
				}
			}
			T u=minV;
			
			Q.remove(minV);
			
			for (T v : graph.getAdjacents(u)) {
				int alt=table.get(u).distance+graph.searchEdge(u, v).getWeigth();
				if(alt<table.get(v).distance) {
					table.get(v).distance=alt;
					table.get(v).path=u;
				}
			}
		}
		
		for (T aux: table.keySet()) {
			System.out.println(aux+" : "+table.get(aux).distance+" : "+table.get(aux).path);
		}
		
		ArrayList<T>path=new ArrayList<T>();
		T current1=end;
		while(current1!=null) {
			path.add(0, current1);
			current1=table.get(current1).path;
		}
		
		if(table.get(end).distance==Integer.MAX_VALUE) {
			path=new ArrayList<T>();
		}
		
		return new AuxDijkstra<Integer,List<T>>(table.get(end).distance,path);
	}
	
	
	
	
	public Graph<T> Kruskal(Graph<T> graph, String type)
	{
		
		
		Graph<T> g;
		if(type.equals(main.LIST))
		{
			if(graph.isDirected())
			{
				g = new ListGraph<T>(true, true);

			}else
			{
				g = new ListGraph<T>(false, true);
			}
		}else {

			if(graph.isDirected())
			{
				g = new MatrixGraph<T>(true, true,100);

			}else
			{
				g = new MatrixGraph<T>(false, true,100);
			}
		}
		
		ArrayList<Edge<T>> edges = graph.getEdges();
		edges.sort(null);
		
		ArrayList<T> nodes = graph.getNodes();
		
		
		for(int i = 0; i<nodes.size();i++)
		{
			g.addNode(nodes.get(i));
		}
		
		ArrayList<AuxKruskal<T>> joins = new ArrayList<AuxKruskal<T>>();
		for(int i= 0; i<nodes.size();i++)
		{
			joins.add(new AuxKruskal<T>(nodes.get(i)));
		}
		
		for (int i = 0; i < edges.size() && joins.size() > 1; i++) {
			int n = joins.size();
			Edge<T> edge = edges.get(i);
			T node1 = edge.getNode1().getValue();
			T node2 = edge.getNode2().getValue();
			for (int j = 0; j < joins.size(); j++) {
				if (joins.get(j).isNode(node1) && !joins.get(j).isNode(node2)) {
					AuxKruskal<T> c1 = joins.get(j);
					AuxKruskal<T> c2 = null;
					int ind = -1;
					for (int h = 0; c2 == null && h < joins.size(); h++) {
						if (joins.get(h).isNode(node2)) {
							c2 = joins.get(h);
							ind = h;
						}
					}
					if (c2 != null) {
						c1.getTogether(c2);
						joins.remove(ind);
					}
				}
			}
			if (n > joins.size()) {
				g.addEdge(node1, node2, edge.getWeigth());
			}
		}
		return g;
	}
	
	
}
