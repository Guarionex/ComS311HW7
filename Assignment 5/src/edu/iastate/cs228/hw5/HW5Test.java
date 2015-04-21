package edu.iastate.cs228.hw5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * @author Jonathan Henze
 *
 */
public class HW5Test {
	
	@Test //simple test that the constructor takes the parameters in the correct order
	public void testPair() 
	{
		Pair<String,Integer> pair = new Pair<String, Integer>("A", 1);
		assertNotNull(pair);
	}
	
	@Test //check that pair can take negatives
	public void testPair1() 
	{
		Pair<String,Integer> pair = new Pair<String, Integer>("A", -1);
		assertNotNull(pair);
	}
	
	@Test //make a pair with different types
	public void testPair2() 
	{
		Pair<ArrayList<Double>,Character> pair = new Pair<ArrayList<Double>, Character>(new ArrayList<Double>(), 'a');
		assertNotNull(pair);
	}
	
	@Test //null input to constructor. Prof Huang said either NullPointerException or IllegalArgumentException is fine
	public void testPairNull() 
	{
		try
		{
			@SuppressWarnings("unused")
			Pair<String,Integer> pair = new Pair<String, Integer>(null, 1);
		}
		catch(Exception e)
		{
			if (e instanceof IllegalArgumentException || e instanceof NullPointerException)
				return;
			fail("Should throw an IllegalArgumentException or a NullPointerException but instead was " + e.getClass().toString());
		}
		fail("Expected an IllegalArgumentException or a NullPointerException but there was no exception thrown");
	}
	
	@Test //null input to constructor. Prof Huang said either NullPointerException or IllegalArgumentException is fine
	public void testPairNull1() 
	{
		try
		{
			@SuppressWarnings("unused")
			Pair<String,Integer> pair = new Pair<String, Integer>("A", null);
		}
		catch(Exception e)
		{
			if (e instanceof IllegalArgumentException || e instanceof NullPointerException)
				return;
			fail("Should throw an IllegalArgumentException or a NullPointerException but instead was " + e.getClass().toString());
		}
		fail("Expected an IllegalArgumentException or a NullPointerException but there was no exception thrown");
	}
	
	@Test //null input to constructor. Prof Huang said either NullPointerException or IllegalArgumentException is fine
	public void testPairNull2() 
	{
		try
		{
			@SuppressWarnings("unused")
			Pair<String,Integer> pair = new Pair<String, Integer>(null, null);
		}
		catch(Exception e)
		{
			if (e instanceof IllegalArgumentException || e instanceof NullPointerException)
				return;
			fail("Should throw an IllegalArgumentException or a NullPointerException but instead was " + e.getClass().toString());
		}
		fail("Expected an IllegalArgumentException or a NullPointerException but there was no exception thrown");
	}
	
	@Test //simple hashCode test, hash code should be determined by the vertex so any 2 pairs with the same vertex
		  //should have the same hash code regardless of what their cost is
	public void testPairHashCode() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("A", 2);
		assertEquals(pair1.hashCode(), pair2.hashCode());
		assertEquals("A".hashCode(), pair1.hashCode());
	}

	@Test //not much to test here
	public void testPairGetVertex() 
	{
		Pair<String,Integer> pair = new Pair<String, Integer>("A", 1);
		assertEquals("A", pair.getVertex());
	}

	@Test //or here either
	public void testPairGetCost() 
	{
		Pair<String,Integer> pair = new Pair<String, Integer>("A", 1);
		assertEquals(new Integer(1), pair.getCost());
	}

	@Test //simple test of compareTo, should only be comparing cost since that is the only thing implementing comparable
	public void testPairCompareTo() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("A", 2);
		assertTrue(pair1.compareTo(pair2) < 0);
		assertTrue(pair2.compareTo(pair1) > 0);
	}
	
	@Test //again with equal costs and different vertices
	public void testPairCompareTo1() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("B", 1);
		assertEquals(new Integer(0), new Integer(pair1.compareTo(pair2)));
		assertEquals(new Integer(0), new Integer(pair2.compareTo(pair1)));
	}
	
	@Test (expected = NullPointerException.class) //null input to compareTo. It looks like from the webCT boards this
												 //should be NullPointerException and not IllegalArgumentException
	public void testPairCompareToNull() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		pair1.compareTo(null);
	}

	@Test //equals is based solely off of the vertex, so different costs shouldn't matter
	public void testPairEqualsObject() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("A", 2);
		assertTrue(pair1.equals(pair2));
		assertTrue(pair2.equals(pair1));
	}
	
	@Test //same costs, different vertices
	public void testPairEqualsObject1() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("B", 1);
		assertFalse(pair1.equals(pair2));
		assertFalse(pair2.equals(pair1));
	}
	
	@Test //different costs and different vertices
	public void testPairEqualsObject2() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		Pair<String,Integer> pair2 = new Pair<String, Integer>("B", 2);
		assertFalse(pair1.equals(pair2));
		assertFalse(pair2.equals(pair1));
	}
	
	@Test //compare to a different class
	public void testPairEqualsObject3() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		assertFalse(pair1.equals(new Object[3]));
	}
	
	@Test //compare to same class as vertex
	public void testPairEqualsObject4() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		assertFalse(pair1.equals("A"));
	}
	
	@Test //compare to same class as cost
	public void testPairEqualsObject5() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		assertFalse(pair1.equals(1));
	}
	
	@Test //compare to null, should not throw exception
	public void testPairEqualsObjectNull() 
	{
		Pair<String,Integer> pair1 = new Pair<String, Integer>("A", 1);
		assertFalse(pair1.equals(null));
	}

	@Test //simple test that the constructor doesn't throw any exceptions
	public void testCS228DirectedGraph() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertNotNull(graph);
	}

	@Test //number of vertices in an empty graph
	public void testNumV() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertEquals(new Integer(0), new Integer(graph.numV()));
	}
	
	@Test //adding a vertex to the graph
	public void testNumV1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		assertEquals(new Integer(1), new Integer(graph.numV()));
	}
	
	@Test //adding many vertices to the graph
	public void testNumV2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		for (int i=0; i<100; i++)
			graph.addVertex(new Integer(i).toString());
		assertEquals(new Integer(100), new Integer(graph.numV()));
	}
	
	@Test //adding an edge where neither of the vertices already exist, so they must both be added
	public void testNumV3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(2), new Integer(graph.numV()));
	}
	
	@Test //adding an edge where only one of the vertices already exist, so the other must be added
	public void testNumV4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(2), new Integer(graph.numV()));
	}
	
	@Test //same as testNumV4 only with the second vertex being the one already in the graph
	public void testNumV5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("B");
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(2), new Integer(graph.numV()));
	}
	
	@Test //adding an edge where both the vertices are already in the graph, so the number of vertices shouldn't change
	public void testNumV6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(2), new Integer(graph.numV()));
	}
	
	@Test //same as testNumV4 only with vertices already being in the graph
	public void testNumV7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addEdge("B", "C", 1);
		assertEquals(new Integer(3), new Integer(graph.numV()));
	}


	@Test //number of edges in an empty graph
	public void testNumE() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertEquals(new Integer(0), new Integer(graph.numE()));
	}
	
	@Test //add an edge to the graph
	public void testNumE1()
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(1), new Integer(graph.numE()));
	}
	
	@Test //add a couple edges
	public void testNumE2()
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 2);
		assertEquals(new Integer(2), new Integer(graph.numE()));
	}
	
	@Test //graph has vertices but no edges
	public void testNumE3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		assertEquals(new Integer(0), new Integer(graph.numE()));
	}
	
	@Test //add vertices, then edges
	public void testNumE4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "C", 1);
		assertEquals(new Integer(3), new Integer(graph.numE()));
	}
	
	@Test //add parallel edges with the same cost
	public void testNumE5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "A", 1);
		graph.addEdge("C", "B", 2);
		graph.addEdge("C", "A", 1);
		assertEquals(new Integer(6), new Integer(graph.numE()));
	}
	
	@Test //try to add the same edge multiple times
	public void testNumE6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(1), new Integer(graph.numE()));
	}
	
	@Test //try to add the same edge multiple times with different costs
	public void testNumE7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "B", 3);
		assertEquals(new Integer(1), new Integer(graph.numE()));
	}

	@Test //degree in a graph with no parallel edges
	public void testDegree() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "C", 1);
		assertEquals(new Integer(2), new Integer(graph.degree("A")));
		assertEquals(new Integer(1), new Integer(graph.degree("B")));
		assertEquals(new Integer(0), new Integer(graph.degree("C")));
	}
	
	@Test //degree in a graph with parallel edges
	public void testDegree1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "A", 1);
		graph.addEdge("C", "B", 2);
		graph.addEdge("C", "A", 1);
		assertEquals(new Integer(2), new Integer(graph.degree("A")));
		assertEquals(new Integer(2), new Integer(graph.degree("B")));
		assertEquals(new Integer(2), new Integer(graph.degree("C")));
	}
	
	@Test //degree on a vertex with no edges
	public void testDegree2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		assertEquals(new Integer(0), new Integer(graph.degree("A")));
	}
	
	@Test //degree with an empty graph
	public void testDegree3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertEquals(new Integer(0), new Integer(graph.degree("A")));
	}
	
	@Test //degree on a vertex not in a non-empty graph
	public void testDegree4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		assertEquals(new Integer(0), new Integer(graph.degree("B")));
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to degree
	public void testDegreeNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.degree(null);
	}

	@Test //most of addEdge is tested by the numE tests, this test is a repeat
	public void testAddEdge() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertEquals(new Integer(1), new Integer(graph.numE()));
	}
	
	@Test //check the edge values added
	public void testAddEdge1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 2);
		Pair<String, Integer> edgeAB = graph.adjacentTo("A").iterator().next();
		Pair<String, Integer> edgeBA = graph.adjacentTo("B").iterator().next();
		assertEquals("B", edgeAB.getVertex());
		assertEquals(new Integer(1), edgeAB.getCost());
		assertEquals("C", edgeBA.getVertex());
		assertEquals(new Integer(2), edgeBA.getCost());
	}
	
	@Test //check the edge values added with parallel edges
	public void testAddEdge2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "A", 2);
		Pair<String, Integer> edgeAB = graph.adjacentTo("A").iterator().next();
		Pair<String, Integer> edgeBA = graph.adjacentTo("B").iterator().next();
		assertEquals("B", edgeAB.getVertex());
		assertEquals(new Integer(1), edgeAB.getCost());
		assertEquals("A", edgeBA.getVertex());
		assertEquals(new Integer(2), edgeBA.getCost());
	}
	
	@Test //check the values don't change after trying to add a duplicate edge
	public void testAddEdge3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 5);
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("A").iterator();
		Pair<String, Integer> edgeAB = edgeIterator.next();
		assertFalse(edgeIterator.hasNext());
		assertEquals("B", edgeAB.getVertex());
		assertEquals(new Integer(1), edgeAB.getCost());
	}
	
	@Test //check that adding an edge doesn't create a parallel edge
	public void testAddEdge4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertFalse(graph.adjacentTo("B").iterator().hasNext());
	}
	
	@Test //check adding an edge with 0 cost, by my understanding of Prof Huang's clarification this is allowed
	public void testAddEdge5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 0);
		assertTrue(graph.adjacentTo("A").iterator().hasNext());
	}
	
	@Test (expected = IllegalArgumentException.class)//check adding an edge with negative cost
	public void testAddEdge6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", -1);
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to add edge
	public void testAddEdgeNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge(null, "B", 1);
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to add edge
	public void testAddEdgeNull1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", null, 1);
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to add edge
	public void testAddEdgeNull2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", null);
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to add edge
	public void testAddEdgeNull3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge(null, null, null);
	}

	@Test //basic add vertex, shouldn't throw any exceptions
	public void testAddVertex() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
	}
	
	@Test //add a couple vertices, see how many are in there
	public void testAddVertex1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		assertEquals(new Integer(3), new Integer(graph.numV()));
	}
	
	@Test //make sure duplicate vertices aren't added
	public void testAddVertex2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("A");
		graph.addVertex("A");
		assertEquals(new Integer(1), new Integer(graph.numV()));
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to addVertex
	public void testAddVertexNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex(null);
	}

	@Test //just checks that vertices is returning something
	public void testVertices() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		assertNotNull(graph.vertices());
	}
	
	@Test //check the values returned by vertices
	public void testVertices1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertTrue(vertices.contains("C"));
		assertEquals(new Integer(3), new Integer(vertices.size()));
	}
	
	@Test //check the values returned by vertices with vertices added by addEdge
	public void testVertices2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertTrue(vertices.contains("C"));
		assertEquals(new Integer(3), new Integer(vertices.size()));
	}
	
	@Test //check the values returned by vertices with some vertices added by addEdge and some by addVertex
	public void testVertices3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("B");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertTrue(vertices.contains("C"));
		assertEquals(new Integer(3), new Integer(vertices.size()));
	}
	
	@Test //check the values returned by vertices all vertices added by addVertex first, then calling addEdge
	public void testVertices4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertTrue(vertices.contains("C"));
		assertEquals(new Integer(3), new Integer(vertices.size()));
	}
	
	@Test //check the values returned by vertices all vertices added by addEdge first, then calling addVertex
	public void testVertices5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertTrue(vertices.contains("C"));
		assertEquals(new Integer(3), new Integer(vertices.size()));
	}
	
	@Test //vertices with an empty graph
	public void testVertices6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		Iterator<String> vertexIterator = graph.vertices().iterator();
		assertNotNull(vertexIterator);
		assertFalse(vertexIterator.hasNext());
	}
	
	@Test //check the values returned after adding duplicate edges
	public void testVertices7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 2);
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertEquals(new Integer(2), new Integer(vertices.size()));
	}
	
	@Test //check the values returned after adding duplicate vertices
	public void testVertices8() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("B");
		graph.addVertex("A");
		Iterator<String> vertexIterator = graph.vertices().iterator();
		ArrayList<String> vertices = new ArrayList<String>();
		while (vertexIterator.hasNext()) 
			vertices.add(vertexIterator.next());
		assertTrue(vertices.contains("A"));
		assertTrue(vertices.contains("B"));
		assertEquals(new Integer(2), new Integer(vertices.size()));
	}

	@Test //some cases with only one edge being returned by adjacentTo are tested in addEdge
		  //this one checks for multiple edges
	public void testAdjacentTo() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 2);
		graph.addEdge("A", "D", 3);
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("A").iterator();
		ArrayList<Pair<String,Integer>> edges = new ArrayList<Pair<String,Integer>>();
		while (edgeIterator.hasNext()) //check that the edges are in there in any order
		{
			Pair<String, Integer> edge = edgeIterator.next();
			edges.add(edge);
			if (edge.getVertex().equals("B"))
				assertEquals(new Integer(1), edge.getCost());
			else if (edge.getVertex().equals("C"))
				assertEquals(new Integer(2), edge.getCost());
			else if (edge.getVertex().equals("D"))
				assertEquals(new Integer(3), edge.getCost());
			else
				fail("Was expecting B, C or D but instead was " + edge.getVertex());
		}
		assertEquals(new Integer(3), new Integer(edges.size()));
		assertTrue(edges.contains(new Pair<String,Integer>("B",1))); //this relies on Pair.equals
		assertTrue(edges.contains(new Pair<String,Integer>("C",2)));
		assertTrue(edges.contains(new Pair<String,Integer>("C",3)));
	}
	
	@Test //checks parallel edges are not created
	public void testAdjacentTo1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("C", "B", 2);
		graph.addEdge("B", "D", 3);
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("B").iterator();
		Pair<String,Integer> edgeBD = edgeIterator.next();
		assertEquals("D", edgeBD.getVertex());
		assertEquals(new Integer(3), edgeBD.getCost());
		assertFalse(edgeIterator.hasNext());
	}
	
	@Test //tests calling adjacentTo with empty graph
	public void testAdjacentTo2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("A").iterator();
		assertNotNull(edgeIterator);
		assertFalse(edgeIterator.hasNext());
	}
	
	@Test //looks for a vertex not in the graph with a non-empty graph
	public void testAdjacentTo3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("B").iterator();
		assertNotNull(edgeIterator);
		assertFalse(edgeIterator.hasNext());
	}
	
	@Test //looks for a vertex with no edges in a non empty graph
	public void testAdjacentTo4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		Iterator<Pair<String,Integer>> edgeIterator = graph.adjacentTo("A").iterator();
		assertNotNull(edgeIterator);
		assertFalse(edgeIterator.hasNext());
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to adjacentTo
	public void testAdjacentToNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex(null);
	}

	@Test //simple test
	public void testHasVertex() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		assertTrue(graph.hasVertex("A"));
	}
	
	@Test //test with more vertices in the graph, also checks some not in the graph
	public void testHasVertex1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		assertTrue(graph.hasVertex("A"));
		assertTrue(graph.hasVertex("B"));
		assertTrue(graph.hasVertex("C"));
		assertFalse(graph.hasVertex("D"));
	}
	
	@Test //checks with an empty graph
	public void testHasVertex2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertFalse(graph.hasVertex("A"));
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to hasVertex
	public void testHasVertexNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex(null);
	}

	@Test //basic test
	public void testHasEdge() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertTrue(graph.hasEdge("A", "B"));
	}
	
	@Test //check there is no parallel edge
	public void testHasEdge1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertTrue(graph.hasEdge("A", "B"));
		assertFalse(graph.hasEdge("B", "A"));
	}
	
	@Test //try with a bunch of edges
	public void testHasEdge2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 2);
		graph.addEdge("C", "D", 3);
		graph.addVertex("E");
		assertTrue(graph.hasEdge("A", "B"));
		assertTrue(graph.hasEdge("A", "C"));
		assertFalse(graph.hasEdge("A", "D"));
		assertFalse(graph.hasEdge("A", "E"));
		assertFalse(graph.hasEdge("B", "A"));
		assertFalse(graph.hasEdge("B", "C"));
		assertFalse(graph.hasEdge("B", "D"));
		assertFalse(graph.hasEdge("B", "E"));
		assertFalse(graph.hasEdge("C", "A"));
		assertFalse(graph.hasEdge("C", "B"));
		assertTrue(graph.hasEdge("C", "D"));
		assertFalse(graph.hasEdge("C", "E"));
		assertFalse(graph.hasEdge("D", "A"));
		assertFalse(graph.hasEdge("D", "B"));
		assertFalse(graph.hasEdge("D", "C"));
		assertFalse(graph.hasEdge("D", "E"));
		assertFalse(graph.hasEdge("E", "A"));
		assertFalse(graph.hasEdge("E", "B"));
		assertFalse(graph.hasEdge("E", "C"));
		assertFalse(graph.hasEdge("E", "D"));
	}
	
	@Test //check that trying to add duplicate doesn't mess up anything
	public void testHasEdge3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "B", 2);
		assertTrue(graph.hasEdge("A", "B"));
		assertFalse(graph.hasEdge("B", "A"));
	}
	
	@Test //check if a vertex in the graph has an edge with a vertex not in the graph
	public void testHasEdge4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertFalse(graph.hasEdge("A", "C"));
	}
	
	@Test //check if a vertex not in the graph has an edge with a vertex in the graph
	public void testHasEdge5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertFalse(graph.hasEdge("C", "A"));
	}
	
	@Test //check if a vertex not in the graph has an edge with another vertex not in the graph
	public void testHasEdge6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		assertFalse(graph.hasEdge("C", "D"));
	}
	
	@Test //call hasEdge with an empty graph
	public void testHasEdge7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertFalse(graph.hasEdge("A", "B"));
	}
	
	@Test //call hasEdge with the same f and t
	public void testHasEdge8() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addVertex("A");
		assertFalse(graph.hasEdge("A", "A"));
	}
	
	@Test(expected = IllegalArgumentException.class) //null input to hasEdge
	public void testHasEdgeNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertFalse(graph.hasEdge(null, "B"));
	}
	
	@Test(expected = IllegalArgumentException.class) //null input to hasEdge
	public void testHasEdgeNull1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertFalse(graph.hasEdge("A", null));
	}
	
	@Test(expected = IllegalArgumentException.class) //null input to hasEdge
	public void testHasEdgeNull2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		assertFalse(graph.hasEdge(null, null));
	}

	@Test //check everything is in the output from toString, though the order it is in does not matter
	public void testToString() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "A", 4);
		graph.addEdge("B", "D", 5);
		graph.addEdge("C", "B", 6);
		graph.addVertex("E");
		Scanner stringReader = new Scanner(graph.toString());
		//System.out.println(graph.toString()); //uncomment this line if you want to see your output
		/*
		 * For comparison, here is my output:
		 * D: 
		 * E:
		 * A: (D, 3), (B, 1), (C, 2)
		 * B: (D, 5), (A, 4)
		 * C: (B, 6)
		 * note that the order things are in doesn't matter, but the formatting does
		 */
		while (stringReader.hasNextLine())
		{
			Scanner lineReader = new Scanner(stringReader.nextLine());
			String vertex = lineReader.next(); //this will have D: or A: or something like that
			ArrayList<String> edges = new ArrayList<String>();
			while (lineReader.hasNext())
				edges.add(lineReader.next() + " " + lineReader.next()); //this will read one vertex cost pair
			if (vertex.equals("A:"))									//assuming it is in the format (V, #)
			{
				assertEquals(new Integer(3), new Integer(edges.size()));
				assertTrue(edges.get(0).endsWith(","));
				assertTrue(edges.get(1).endsWith(","));
				assertFalse(edges.get(2).endsWith(","));
				edges.set(0, edges.get(0).substring(0, edges.get(0).length() - 1));
				edges.set(1, edges.get(1).substring(0, edges.get(1).length() - 1));
				assertTrue(edges.contains("(B, 1)"));
				assertTrue(edges.contains("(C, 2)"));
				assertTrue(edges.contains("(D, 3)"));
			}
			else if (vertex.equals("B:"))
			{
				assertEquals(new Integer(2), new Integer(edges.size()));
				assertTrue(edges.get(0).endsWith(","));
				assertFalse(edges.get(1).endsWith(","));
				edges.set(0, edges.get(0).substring(0, edges.get(0).length() - 1));
				assertTrue(edges.contains("(A, 4)"));
				assertTrue(edges.contains("(D, 5)"));
			}
			else if (vertex.equals("C:"))
			{
				assertEquals(new Integer(1), new Integer(edges.size()));
				assertEquals("(B, 6)", edges.get(0));
			}
			else if (vertex.equals("D:"))
			{
				assertEquals(new Integer(0), new Integer(edges.size()));
			}
			else if (vertex.equals("E:"))
			{
				assertEquals(new Integer(0), new Integer(edges.size()));
			}
			else
				fail("Expected the line to start with A: or B: or C: or D: or E: but was " + vertex);
		}
	}
	
	@Test //make sure the specific constructor takes in the correct input
	public void testCS228Dijkstra() 
	{
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(new CS228DirectedGraph<String>());
		assertNotNull(digimon);
	}

	@Test (timeout = 5000) //just tests that run doesn't throw an exception or infinite loop, the results are tested 
		  //in the getShortestPath and getShortestDistance methods
		  //if you want to step into the test you'll need to comment out the timeout
	public void testRun() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
	}
	
	@Test (timeout = 5000) //just tests that run doesn't throw an exception or infinite loop, the results are tested 
	//in the getShortestPath and getShortestDistance methods
	//if you want to step into the test you'll need to comment out the timeout
	public void testRun1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("D"); //D can only reach E
	}
	
	@Test (timeout = 5000) //just tests that run doesn't throw an exception or infinite loop, the results are tested 
	//in the getShortestPath and getShortestDistance methods
	//if you want to step into the test you'll need to comment out the timeout
	public void testRun2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("C"); //C can't reach any of the other points
	}
	
	@Test (expected = IllegalArgumentException.class) //call run with a vertex not in the graph
	public void testRun3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("F"); //F is not in the graph
	}
	
	@Test (expected = IllegalArgumentException.class) //call run with an empty graph
	public void testRun4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
	}
	
	@Test (expected = IllegalArgumentException.class) //call run with null and an empty graph
	public void testRunNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run(null);
	}
	
	@Test (expected = IllegalArgumentException.class) //call run with null and a non-empty graph
	public void testRunNull1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run(null);
	}

	@Test (timeout = 5000)//run the example in testRun from A to B, where there is only 1 possible path and it is
						  //the immediate edge from A
		//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		ArrayList<String> shortestAB = new ArrayList<String>();
		shortestAB.add("A");
		shortestAB.add("B");
		assertEquals(shortestAB, digimon.getShortestPath("B"));
	}
	
	@Test (timeout = 5000)//run the example in testRun from A to C, where there are 2 possibilities but the shortest is
						  //the immediate edge from A to C
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		ArrayList<String> shortestAC = new ArrayList<String>();
		shortestAC.add("A");
		shortestAC.add("C");
		assertEquals(shortestAC, digimon.getShortestPath("C"));
	}
	
	@Test (timeout = 5000)//run the example in testRun from A to D, where there are 2 possibilities but the shortest is
						  //not the immediate edge
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		ArrayList<String> shortestAD = new ArrayList<String>();
		shortestAD.add("A");
		shortestAD.add("B");
		shortestAD.add("D");
		assertEquals(shortestAD, digimon.getShortestPath("D"));
	}
	
	@Test (timeout = 5000)//run the example in testRun from A to E, where there are multiple paths
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		ArrayList<String> shortestAE = new ArrayList<String>();
		shortestAE.add("A");
		shortestAE.add("B");
		shortestAE.add("E");
		assertEquals(shortestAE, digimon.getShortestPath("E"));
	}
	
	@Test (timeout = 5000)//run the example in testRun from D to every other point
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("D"); //D can only reach E
		ArrayList<String> empty = new ArrayList<String>();
		ArrayList<String> pathDE = new ArrayList<String>();
		pathDE.add("D");
		pathDE.add("E");
		assertEquals(empty, digimon.getShortestPath("A"));
		assertEquals(empty, digimon.getShortestPath("B"));
		assertEquals(empty, digimon.getShortestPath("C"));
		assertEquals(pathDE, digimon.getShortestPath("E"));
	}
	
	@Test (timeout = 5000)//call getShortestPath to a node not in the graph
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		assertEquals(new ArrayList<String>(), digimon.getShortestPath("F"));
	}
	
	@Test (timeout = 5000)//checks that getShortestPath is relative to the most recent call of run
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("B");
		digimon.run("A");
		ArrayList<String> shortestAB = new ArrayList<String>();
		shortestAB.add("A");
		shortestAB.add("B");
		ArrayList<String> shortestAC = new ArrayList<String>();
		shortestAC.add("A");
		shortestAC.add("C");
		ArrayList<String> shortestAD = new ArrayList<String>();
		shortestAD.add("A");
		shortestAD.add("B");
		shortestAD.add("D");
		ArrayList<String> shortestAE = new ArrayList<String>();
		shortestAE.add("A");
		shortestAE.add("B");
		shortestAE.add("E");
		assertEquals(shortestAB, digimon.getShortestPath("B"));
		assertEquals(shortestAC, digimon.getShortestPath("C"));
		assertEquals(shortestAD, digimon.getShortestPath("D"));
		assertEquals(shortestAE, digimon.getShortestPath("E"));
	}
	
	@Test (expected = RuntimeException.class) //call getShortestPath without calling run
	public void testGetShortestPath7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.getShortestPath("A");
	}
	
	@Test (timeout = 5000) //find the shortest path to the starting point
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestPath8() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		ArrayList<String> pathAA = new ArrayList<String>();
		pathAA.add("A");
		assertEquals(pathAA, digimon.getShortestPath("A"));
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to getShortestPath (but after calling run)
	public void testGetShortestPathNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		digimon.getShortestPath(null);
	}
	
	@Test (expected = Exception.class) //null input to getShortestPath without calling run
	//this could be either a RuntimeException or an IllegalArgumentException, I don't think it matters which
	public void testGetShortestPathNull1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.getShortestPath(null);
	}

	@Test (timeout = 5000) //these are repeats of the getShortestPath tests only asking for the distance
						   //if you're passing one set you should be passing the other
	//run the example in testRun from A to B, where there is only 1 possible path and it is
	//the immediate edge from A
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		assertEquals(new Integer(1), digimon.getShortestDistance("B"));
	}

	@Test (timeout = 5000)//run the example in testRun from A to C, where there are 2 possibilities but the shortest is
	//the immediate edge from A to C
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		assertEquals(new Integer(2), digimon.getShortestDistance("C"));
	}

	@Test (timeout = 5000)//run the example in testRun from A to D, where there are 2 possibilities but the shortest is
	//not the immediate edge
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance2() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		assertEquals(new Integer(4), digimon.getShortestDistance("D")); //5 would be the direct route, but not the shortest
	}

	@Test (timeout = 5000)//run the example in testRun from A to E, where there are multiple paths
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance3() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A"); //A can reach every point on the graph and there is only 1 possible way to end up at itself
		assertEquals(new Integer(3), digimon.getShortestDistance("E"));
	}
	
	@Test (timeout = 5000)//run the example in testRun from D to every other point
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance4() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("D"); //D can only reach E
		assertEquals(new Integer(Integer.MAX_VALUE), digimon.getShortestDistance("A"));
		assertEquals(new Integer(Integer.MAX_VALUE), digimon.getShortestDistance("B"));
		assertEquals(new Integer(Integer.MAX_VALUE), digimon.getShortestDistance("C"));
		assertEquals(new Integer(1), digimon.getShortestDistance("E"));
	}
	
	@Test (timeout = 5000)//call getShortestDistance to a node not in the graph
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance5() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		assertEquals(new Integer(Integer.MAX_VALUE), digimon.getShortestDistance("F"));
	}
	
	@Test (timeout = 5000)//checks that getShortestDistance is relative to the most recent call of run
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance6() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("B");
		digimon.run("A");
		assertEquals(new Integer(1), digimon.getShortestDistance("B"));
		assertEquals(new Integer(2), digimon.getShortestDistance("C"));
		assertEquals(new Integer(4), digimon.getShortestDistance("D"));
		assertEquals(new Integer(3), digimon.getShortestDistance("E"));
	}
	
	@Test (expected = RuntimeException.class) //call getShortestDistance without calling run
	public void testGetShortestDistance7() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.getShortestDistance("A");
	}
	
	@Test (timeout = 5000) //find shortest distance to the starting point
	//if you want to step into the test you'll need to comment out the timeout
	public void testGetShortestDistance8() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		assertEquals(new Integer(0), digimon.getShortestDistance("A"));
	}
	
	@Test (expected = IllegalArgumentException.class) //null input to getShortestDistance (but after calling run)
	public void testGetShortestDistanceNull() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.run("A");
		digimon.getShortestDistance(null);
	}
	
	@Test (expected = Exception.class) //null input to getShortestDistance without calling run
	//this could be either a RuntimeException or an IllegalArgumentException, I don't think it matters which
	public void testGetShortestDistanceNull1() 
	{
		CS228DirectedGraph<String> graph = new CS228DirectedGraph<String>();
		graph.addEdge("A", "B", 1); //         C              v means going down, ^ means going up
		graph.addEdge("A", "C", 2); //        |    \2^        > means going right, < means left
		graph.addEdge("A", "D", 5); //      2^|     A
		graph.addEdge("B", "A", 2); //        | 1v/2^ \5v
		graph.addEdge("B", "C", 2); //        B  -->   D
		graph.addEdge("B", "D", 3); //       2v\  3  /1v
		graph.addEdge("B", "E", 2); //          \   /  
		graph.addEdge("D", "E", 1); //            E
		CS228Dijkstra<String> digimon = new CS228Dijkstra<String>(graph);
		digimon.getShortestDistance(null);
	}

}
