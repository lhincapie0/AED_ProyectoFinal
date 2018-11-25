package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.NodeNotFoundException;
import structure.MatrixGraph;

public class MatrixGraphTest {

	
	private MatrixGraph<String> graph;
	
	
	public void setUp1() {
		graph = new MatrixGraph<>(false, true, 10);
	}
	
	public void setUp2()
	{
		graph = new MatrixGraph<>(false, false, 5);
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		
		graph.addEdge("A", "D",0);
		graph.addEdge("C", "B",0);
		graph.addEdge("A", "B",0);
	}
	
	public void setUp3()
	{
		graph = new MatrixGraph<>(false,true, 5);
		graph = new MatrixGraph<>(false, false, 5);
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		
		graph.addEdge("A", "D",10);
		graph.addEdge("C", "B",20);
		graph.addEdge("A", "B",30);
	}
	
	@Test
	public void addNodeTest()
	{
		setUp1();
		graph.addNode("Cali");
		graph.addNode("Bogota");
		graph.addNode("Medellin");
		graph.addNode("Cartagena");
		
		assertTrue(graph.getNodes().size() ==4);

	}
	
	@Test
	public void addEdgeTest()
	{

		setUp1();
		graph.addNode("Cali");
		graph.addNode("Bogota");
		graph.addNode("Medellin");
		graph.addNode("Cartagena");
		graph.addNode("Santa Marta");
		graph.addNode("Pereira");
		
		graph.addEdge("Cali","Bogota",0);
		graph.addEdge("Bogota","Medellin",0);
		graph.addEdge("Cartagena","Santa Marta",0);
		graph.addEdge("Cartagena","Cali",0);
		graph.addEdge("Pereira","Medellin",0);
		graph.addEdge("Bogota", "Cali", 0);

		assertTrue(graph.getMatrix()[0][1] != null);
		assertTrue(graph.getMatrix()[1][2] != null );
		assertTrue(graph.getMatrix()[3][4] != null);
		assertTrue(graph.getMatrix()[5][2] != null) ;
		assertTrue(graph.getMatrix()[1][0] != null );
		assertTrue(graph.getMatrix()[1][1] == null);
		assertTrue(graph.getMatrix()[3][2] == null);
		

	}
	
	@Test
	public void isEdgeTest()
	{
		setUp3();
		graph.isEdge("A","D");
		graph.isEdge("C", "B");
		graph.isEdge("A","B");
		
	}
	
	@Test
	public void isNodeTest()
	{
		setUp3();
		assertTrue(graph.isNode("D"));
	}
	
	//	@Test
//	public void deleteNodeTest() throws NodeNotFoundException
	//{
	//setUp3();
	//graph.deleteNode("D");
	//assertTrue(graph.isNode("D") == false);
	//}
	
	
	@Test
	public void searchEdgeTest()
	{
		setUp3();
		assertNull(graph.searchEdge("A", "C"));
		assertNotNull(graph.searchEdge("A", "D"));
	}
	
	@Test
	public void getAdjacentsTest() throws NodeNotFoundException
	{
		setUp3();
		assertNotNull(graph.getAdjacentEdges("A"));
	}
}
