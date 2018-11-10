package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.ListGraph;

public class ListGraphTest {

	private ListGraph<String, Integer> graph;
	
	private void setUp1()
	{
		graph = new ListGraph<>(4);
	}
	
	private void setUp2()
	{
		graph = new ListGraph<>(4);
		graph.addVertex("Cali");
		graph.addVertex("Bogota");
		graph.addVertex("Santa Marta");
		graph.addVertex("Barranquilla");
	}
	
	private void setUp3()
	{
		graph = new ListGraph<>(4);
		graph.addVertex("Cali");
		graph.addVertex("Bogota");
		graph.addVertex("Santa Marta");
		graph.addVertex("Barranquilla");
		graph.addEdge("Cali", "Bogota", 30);
		graph.addEdge("Cali", "Barranquilla", 80);
		graph.addEdge("Cali", "Santa Marta", 100);
		graph.addEdge("Bogota", "Cali", 30);
		graph.addEdge("Bogota", "Santa Marta", 20);

		
	}
	
	@Test 
	public void addVertexTest()
	{
		setUp1();
		assertEquals(graph.getNoVertex(),0);
		graph.addVertex("Cali");
		graph.addVertex("Bogota");
		graph.addVertex("Santa Marta");
		graph.addVertex("Barranquilla");
		assertEquals(graph.getNoVertex(),4);
	}
	
	@Test 
	public void addEdgeTest() {
		setUp2();
		graph.addEdge("Cali", "Bogota", 30);
		assertEquals(graph.getEdges(),1);
	}
	
	
	@Test 
	public void isEdgeTest() {
		setUp3();
		assertTrue(graph.isEdge("Cali", "Bogota"));
	}
}
