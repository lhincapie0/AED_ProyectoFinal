package test;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;


import Exception.NodeNotFoundException;
import structure.ListGraph;
import structure.MatrixGraph;
import structure.Algorithms;
import structure.AuxDijkstra;
import structure.Graph;


public class MenuTest {
	
	private Graph<String> matrixGraph;
	private Graph<String> listGraph;
	private Algorithms<String> menu;
	
	
	
	public MenuTest() throws Exception
	{
		menu = new Algorithms<String>();
	}
	
	
	public void setUp1()
	{
		listGraph = new ListGraph<String>(false, false);
		listGraph.addNode( "Cali");
		listGraph.addNode("Bogota");
		listGraph.addNode("Medellin");
		listGraph.addNode("Cartagena");
		listGraph.addNode("Santa Marta");
		listGraph.addNode("Barranquilla");
		listGraph.addEdge("Cali", "Bogota",0);
		listGraph.addEdge("Bogota", "Medellin",0);
		listGraph.addEdge("Santa Marta","Barranquilla",0);
		listGraph.addEdge("Cartagena", "Cali",0);
		listGraph.addEdge("Cali", "Santa Marta",0);
	}
	
	public void setUp2()
	{
		matrixGraph = new MatrixGraph<String>(false, false,6);
		matrixGraph.addNode( "Cali");
		matrixGraph.addNode("Bogota");
		matrixGraph.addNode("Medellin");
		matrixGraph.addNode("Cartagena");
		matrixGraph.addNode("Santa Marta");
		matrixGraph.addNode("Barranquilla");
		matrixGraph.addEdge("Cali", "Bogota",0);
		matrixGraph.addEdge("Bogota", "Medellin",0);
		matrixGraph.addEdge("Santa Marta","Barranquilla",0);
		matrixGraph.addEdge("Cartagena", "Cali",0);
		matrixGraph.addEdge("Cali", "Santa Marta",0);
	}
	
	public void setUp3()
	{
		listGraph = new ListGraph<String>(true, false);
		listGraph.addNode("A");
		listGraph.addNode("B");
		listGraph.addNode("C");
		listGraph.addNode("D");
		listGraph.addNode("E");
		listGraph.addNode("F");
		listGraph.addNode("G");
		listGraph.addNode("H");
		listGraph.addEdge("A","B",0);
		listGraph.addEdge("A","D",0);
		listGraph.addEdge("B","C",0);
		listGraph.addEdge("D","E",0);
		listGraph.addEdge("D","F",0);
		listGraph.addEdge("C","A",0);
		listGraph.addEdge("C","E",0);
		listGraph.addEdge("F","E",0);
		listGraph.addEdge("F","B",0);
		listGraph.addEdge("F","B",0);
		listGraph.addEdge("D","A",0);
		listGraph.addEdge("G","H",0);
		listGraph.addEdge("H","B",0);


	}
	
	public void setUp4() throws Exception
	{
		listGraph = new ListGraph<String>(false, true);
		listGraph.addNode("A");
		listGraph.addNode("B");
		listGraph.addNode("C");
		listGraph.addNode("D");
		listGraph.addNode("E");
		listGraph.addNode("F");
		listGraph.addEdge("A","B",2);
		listGraph.addEdge("B", "D",4);
		listGraph.addEdge("D","E",5);
		listGraph.addEdge("E", "F",3);
		listGraph.addEdge("A","C",20);
		listGraph.addEdge("C","F",40);
	
	}
	
	
	public void setUp5()
	{
		matrixGraph = new MatrixGraph<String>(false, true, 8);
		matrixGraph.addNode("A");
		matrixGraph.addNode("B");
		matrixGraph.addNode("C");
		matrixGraph.addNode("D");
		matrixGraph.addNode("E");
		matrixGraph.addNode("F");
		matrixGraph.addEdge("A","B",2);
		matrixGraph.addEdge("B", "D",4);
		matrixGraph.addEdge("D","E",5);
		matrixGraph.addEdge("E", "F",3);
		matrixGraph.addEdge("A","C",20);
		matrixGraph.addEdge("C","F",40);
		
	}
	//List Graph
	@Test
	public void BFSTest() throws NodeNotFoundException
	{
		setUp1();
		ArrayList<String> returnBFS = menu.BFS(listGraph, "Cali");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Cali");
		expected.add("Bogota");
		expected.add("Cartagena");
		expected.add("Santa Marta");
		expected.add("Medellin");
		expected.add("Barranquilla");
		assertTrue(expected.equals(returnBFS));
		assertNull(returnBFS = menu.BFS(listGraph, "Pereira"));
	}
	
	
	@Test
	public void BFSTest1() throws NodeNotFoundException
	{
		setUp3();
		ArrayList<String> returnBFS = menu.BFS(listGraph, "B");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("B");
		expected.add("C");
		expected.add("A");
		expected.add("E");
		expected.add("D");
		expected.add("F");
		assertTrue(expected.equals(returnBFS));
	}
	
	
	//Not directed
	@Test 
	public void DFSTest() throws NodeNotFoundException
	{	setUp1();
		ArrayList<String> returnDFS = menu.DFS(listGraph, "Cali");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Cali");
		expected.add("Bogota");
		expected.add("Medellin");
		expected.add("Cartagena");
		expected.add("Santa Marta");
		expected.add("Barranquilla");
		assertTrue(expected.equals(returnDFS));
	}
	
	//Directed
	@Test
	public void DFSTest2() throws NodeNotFoundException
	{
		setUp3();
		ArrayList<String> expected = new ArrayList<>();
		ArrayList<String> returnDFS = menu.DFS(listGraph, "A");
		expected.add("A");
		expected.add("B");
		expected.add("C");
		expected.add("E");
		expected.add("D");
		expected.add("F");
		assertTrue(expected.equals(returnDFS));
	}
	
	
	//Test for ListGraph
	@Test
	public void DijkstraAlgorithmTest() throws Exception
	{
		
		setUp4();
		
		ArrayList<String> expected = new ArrayList();
			
		expected.add("A");
		expected.add("B");
		expected.add("D");
		expected.add("E");
		expected.add("F");
		AuxDijkstra<Integer,List<String>> path = menu.DijkstraAlgorithm(listGraph,"A","F");
		
		for(int i = 0; i<expected.size(); i++){
			assertTrue(path.getPath().get(i).equals(expected.get(i)));
		}

		
	}
	
	//Test for Matrix
		@Test
		public void DijkstraAlgorithmTest1() throws Exception
		{
			
			setUp5();
			
			ArrayList<String> expected = new ArrayList();
				
			expected.add("A");
			expected.add("B");
			expected.add("D");
			expected.add("E");
			expected.add("F");
			AuxDijkstra<Integer,List<String>> path = menu.DijkstraAlgorithm(matrixGraph,"A","F");
			
			for(int i = 0; i<expected.size(); i++){
				assertTrue(path.getPath().get(i).equals(expected.get(i)));
			}

			
		}
	
	
	
}
