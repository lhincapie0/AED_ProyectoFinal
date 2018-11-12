package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.AdjacencyGraph;
import modelo.Graph;
import modelo.Node;
import modelo.Vertex;

public class AdjacencyGraphTest {

	
	private AdjacencyGraph<String, Integer> graph;
	
	public void setUp1()
	{
		 graph = new AdjacencyGraph<String, Integer>(10);
			graph.addVertex("a");
			graph.addVertex("b");
			graph.addVertex("c");
			graph.addVertex("d");
			graph.addVertex("e");
			graph.addVertex("f");
			graph.addVertex("g");
			graph.addVertex("h");
	}
	
	public void setUp2()
	{
		 graph = new AdjacencyGraph<String, Integer>(10);
			graph.addVertex("Cali");
			graph.addVertex("Bogota");
			graph.addVertex("Barranquilla");
			graph.addVertex("Santa Marta");
			graph.addEdge("Cali","Bogota", 30);
			graph.addEdge("Cali","Santa Marta", 100);
			graph.addEdge("Cali","Barranquilla", 80);
			graph.addEdge("Bogota","Cali", 30);
			graph.addEdge("Bogota","Barranquilla", 20);

	
	}
	
	public void setUp3()
	{
		graph = new AdjacencyGraph<String, Integer>(5);
		
	}
	
	public void setUp4()
	{
		graph = new AdjacencyGraph<String, Integer>(6);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "F", 10);
		graph.addEdge("A", "E", 7);
		graph.addEdge("B", "A", 5);
		graph.addEdge("F", "A", 10);
		graph.addEdge("E", "A", 7);
		graph.addEdge("C", "D", 3);
		graph.addEdge("C", "F", 2);
		graph.addEdge("D", "C", 3);
		graph.addEdge("F", "C", 2);
		graph.addEdge("E", "B", 8);	
		graph.addEdge("B", "E", 8);
		
	}
	
	public void setUp5()
	{
		graph = new AdjacencyGraph<String, Integer>(4);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");	
		graph.adjacencyMatrix[0][1] = 3;
		graph.adjacencyMatrix[0][2] = 999;
		graph.adjacencyMatrix[0][3] = 7;
		graph.adjacencyMatrix[1][0] = 3;
		graph.adjacencyMatrix[1][2] = 4;
		graph.adjacencyMatrix[1][3] = 2;
		graph.adjacencyMatrix[2][0] = 999;
		graph.adjacencyMatrix[2][1] = 4;
		graph.adjacencyMatrix[2][3] = 5;
		graph.adjacencyMatrix[3][0] = 7;
		graph.adjacencyMatrix[3][1] = 2;
		graph.adjacencyMatrix[3][2] = 5;
	}
	
	@Test
	public void addVertexTest()
	{
		setUp1();
		
		graph.addVertex("i");
		graph.addVertex("j");
		
		assertEquals(graph.getNoVertex(), 10);

	}
	
	
	@Test
	public void searchVertexTest()
	{
		setUp1();
		assertTrue(graph.searchVertex("b")>-1);
	}
	
	@Test 
	public void addEdgeTest()
	{
		setUp1();
		graph.addEdge("a", "b", 4);
		graph.addEdge("a", "d",5);
		graph.addEdge("a", "f",7);
		graph.addEdge("b", "c", 1);
		graph.addEdge("c", "a",2);
		graph.addEdge("d", "b",10);
		graph.addEdge("e", "h", 3);
		graph.addEdge("f", "c",2);
		graph.addEdge("g", "f",1);
		graph.addEdge("h", "d",7);
		
		assertEquals(graph.getNoEdges(),10);
		
	}
	
	
	@Test 
	public void deleteVertexTest()
	{
		setUp2();
		assertEquals(graph.getNoEdges(),5);
		assertEquals(graph.getNoVertex(),4);
		graph.deleteVertex("Cali");
		assertEquals(graph.getNoVertex(),3);
		assertEquals(graph.getNoEdges(),1);
	}
	
	
	@Test 
	public void deleteEdgeTest()
	{
		setUp2();
		graph.deleteEdge("Bogota", "Cali");
		assertEquals(graph.getNoEdges(),4);
		
	}
	
	

	@Test 
	public void searchEdgeTest()
	{
		setUp2();
		assertEquals(graph.searchEdge("Bogota", "Cali"),30);
	}
	

	
	
	
	//HACER DISEÑO DE ESTAS PRUEBAS
	@Test
	public void getSucesorsTest()
	{
		setUp4();
		String[] expectedSucesors  = {"B", "E","F"};
		ArrayList<Vertex> nodes = graph.getSucesors("A");
		int[] b = graph.getDistances();
		
		
		String a1 = (String) nodes.get(0).getId();
		assertTrue(expectedSucesors[0].equals((a1)));

		String a2 = (String) nodes.get(1).getId();
		assertTrue(expectedSucesors[1].equals((a2)));

		String a3 = (String) nodes.get(2).getId();
		assertTrue(expectedSucesors[2].equals((a3)));
		
	}
	
	
	@Test
	public void calculateMinimunDistanceTest()
	{
		setUp5();
		int[] expectedDistances = {0,3,7,5};
		graph.calculateMinimunDistance(4, 0,2);
		int[] b = graph.getDistances();
		
		for(int i = 0; i<b.length; i++)
		{
			assertTrue(b[i] == expectedDistances[i]);
		}

	}
}

