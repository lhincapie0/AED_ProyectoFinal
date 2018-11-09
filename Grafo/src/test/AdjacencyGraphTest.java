package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.AdjacencyGraph;
import modelo.Graph;

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
	
}
