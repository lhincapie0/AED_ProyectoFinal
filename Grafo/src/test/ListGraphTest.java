package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Exception.NodeNotFoundException;
import structure.ListGraph;

public class ListGraphTest {

	
	
	
	private ListGraph<Integer> graph;
	
	public void setUp1()
	{
		
		//Not directed and not weighted graph.
		graph = new ListGraph<Integer>(false,false);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 4, 0);
		graph.addEdge(3, 2, 0);
		graph.addEdge(1, 2, 0);
	}
	
	public void setUp2()
	{
		
		//Directed graph
		graph = new ListGraph<Integer>(true, false);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 4, 0);
		graph.addEdge(3, 2, 0);
		graph.addEdge(1, 2, 0);
	}
	
	public void setUp3()
	{
		//Not directed and weighted graph
		graph = new ListGraph<Integer>(false, true);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 4, 15);
		graph.addEdge(3, 2, 4);
		graph.addEdge(1, 2, 20);
	}
	
	public void setUp4()
	{
		//Directed and weighted graph
		graph = new ListGraph<Integer>(true, true);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 4, 15);
		graph.addEdge(3, 2, 4);
		graph.addEdge(1, 2, 20);
	}
	
	
	//NotDirected Graph
	@Test
	public void addEdgeTest()
	{
		
		setUp3();
		int w1 = graph.getWeights().get(1).get(4);
		int w2 = graph.getWeights().get(3).get(2);
		int w3 = graph.getWeights().get(1).get(2);
		graph.addEdge(3, 4, 12);
		
		
		assertTrue(w1 == 15);
		assertTrue(w2 == 4);
		assertTrue(w3 == 20);
		assertTrue(graph.getWeights().get(3).get(4) == 12 && graph.getWeights().get(4).get(3) == 12);
		
	}
	
	//Directed Graph
	@Test
	public void addEdgeTest1()
	{
		setUp4();
		graph.addEdge(3, 4, 8);
		Integer w1 = graph.getWeights().get(1).get(4);
		Integer w2 = graph.getWeights().get(2).get(1);
		
		assertTrue(w1 == 15);
		assertTrue(w2 == null);
		assertTrue(graph.getWeights().get(3).get(4) == 8 && graph.getWeights().get(4).get(3) == null);
	}
	
	//Not Directed Graph
	@Test
	public void deleteNodeTest() throws NodeNotFoundException
	{
		setUp3();
		try {
			graph.deleteNode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(graph.getWeights().get(1));
		assertNull(graph.getWeights().get(2).get(1));
		assertNull(graph.getWeights().get(3).get(1));
	}

	//Directed Graph
	@Test
	public void deleteNodeTest1()
	{
		setUp4();
		assertNull(graph.getWeights().get(2).get(1));
		assertNull(graph.getWeights().get(4).get(1));
		try {
			graph.deleteNode(1);
		} catch (NodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(graph.getWeights().get(1));
	}
	
	
	//Not Directed Graph
	@Test 
	public void deleteEdgeTest()
	{
		setUp3();
		graph.deleteEdge(1, 2);
		assertNull(graph.getWeights().get(1).get(2));
		assertNull(graph.getWeights().get(2).get(1));
		
	}
	
	//Directed Graph
	@Test
	public void deleteEdgeTest1()
	{
		setUp4();
		assertNull(graph.getWeights().get(2).get(1));
		graph.deleteEdge(1,2);
		assertNull(graph.getWeights().get(1).get(2));
	}
	
	@Test
	public void addNodeTest()
	{
		
		setUp1();
		graph.addNode(10);
		assertTrue(graph.isNode(10));
	}
	
	@Test
	public void addEdgeTest2()
	{
		setUp1();
		assertTrue(graph.isEdge(1, 2) == true);
		assertTrue(graph.isEdge(2, 1) == true);
		assertTrue(graph.isEdge(4, 1) == true);
	}
	
	
	@Test 
	public void isEdgeNotDirectedTest()
	{
		setUp1();
		assertTrue(graph.isEdge(2,1)== true);
		assertTrue(graph.isEdge(1,2)== true);
		assertTrue(graph.deleteEdge(1, 2) == true);
		assertTrue(graph.deleteEdge(1, 2) == false);

	}
	@Test
	public void isEdgeDirectedTest()
	{
		setUp2();
		assertTrue(graph.isEdge(2,1) == false);
		assertTrue(graph.isEdge(1,2) == true);
		assertTrue(graph.deleteEdge(2, 1) == false);
		assertTrue(graph.deleteEdge(1,2)== true);
		assertTrue(graph.deleteEdge(2, 4) == false);
		assertTrue(graph.isEdge(1, 2) ==false);
		assertTrue(graph.isEdge(2, 1) == false);
	}
}

