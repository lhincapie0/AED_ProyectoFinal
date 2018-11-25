package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


import Exception.NodeNotFoundException;

public class Algorithms<T> {

	
	@SuppressWarnings("unchecked")
	public Algorithms() throws Exception 
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
			double minD=Double.POSITIVE_INFINITY;
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
	
	
	
	
	
}
