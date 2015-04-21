package edu.iastate.cs228.hw5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Paul Hovey
 *
 */
public class CS228DijkstraTest {
	
	@Test (timeout = 5000)
	public void getShortestDistance0() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		G.addEdge("one", "two", 3);
		assertTrue(G.hasEdge("one", "two"));
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		D.run("one");
		assertEquals(new Integer(3), D.getShortestDistance("two"));
	}
	
	@Test (timeout = 5000)
	public void getShortestDistance1() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		G.addEdge("one", "two", 3);
		assertTrue(G.hasEdge("one", "two"));
		G.addEdge("three", "four", 2);
		assertTrue(G.hasEdge("three", "four"));
		G.addEdge("one", "three", 1);
		assertTrue(G.hasEdge("one", "three"));
		G.addEdge("three", "two", 1);
		assertTrue(G.hasEdge("three", "two"));
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		D.run("one");
		assertEquals(new Integer(2), D.getShortestDistance("two")); // "one" --> "three" --> "two"
		assertEquals(new Integer(3), D.getShortestDistance("four")); // "one" --> "three" --> "four"
		assertEquals(new Integer(Integer.MAX_VALUE), D.getShortestDistance("five")); // doesn't exist
		assertEquals(new Integer(0), D.getShortestDistance("one"));
	}
	
	@Test (timeout = 5000)
	public void getShortestDistance2() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		G.addEdge("one", "two", 2);
		G.addEdge("two", "three", 3);
		G.addEdge("one", "three", 3);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		D.run("one");
		assertEquals(new Integer(3), D.getShortestDistance("three"));
		assertEquals(new Integer(2), D.getShortestDistance("two"));
		assertEquals(new Integer(0), D.getShortestDistance("one"));
		
		D.run("two");
		assertEquals(new Integer(3), D.getShortestDistance("three"));
		assertEquals(new Integer(Integer.MAX_VALUE), D.getShortestDistance("one"));
		assertEquals(new Integer(0), D.getShortestDistance("two"));
		
		D.run("three");
		assertEquals(new Integer(0), D.getShortestDistance("three"));
		assertEquals(new Integer(Integer.MAX_VALUE), D.getShortestDistance("one"));
		
		G.addEdge("three", "four", 4);
		assertTrue(G.hasEdge("three", "four"));
		D = new CS228Dijkstra<String>(G);
		D.run("one");
		assertEquals(new Integer(0), D.getShortestDistance("one"));
		assertEquals(new Integer(2), D.getShortestDistance("two"));
		assertEquals(new Integer(3), D.getShortestDistance("three"));
		assertEquals(new Integer(7), D.getShortestDistance("four"));
	}
	
	@Test (timeout = 5000)
	public void getShortestPath0() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		String one = "one";
		String two = "two";
		String three = "three";
		String four = "four";
		String five = "five";
		
		G.addEdge("one", "two", 4);
		G.addEdge("two", "three", 3);
		G.addEdge("three", "four", 2);
		G.addEdge("four", "five", 1);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		List<String> compList = new ArrayList<String>();
		compList.add(one); // inclusive
		compList.add(two);
		compList.add(three);
		compList.add(four);
		compList.add(five); // inclusive
		
		D.run(one);
		assertEquals(compList, D.getShortestPath(five));
	}
	
	@Test (timeout = 5000)
	public void getShortestPath1() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		String one = "one";
		String two = "two";
		String three = "three";
		String four = "four";
		String five = "five";
		
		G.addEdge(one, two, 4);
		G.addEdge(two, three, 3);
		G.addEdge(three, four, 2);
		G.addEdge(four, five, 1);
		G.addEdge(one, three, 2);
		G.addEdge(one, four, 4);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		List<String> compList = new ArrayList<String>();
		
		D.run(one);
		compList.add(one); // inclusive
		compList.add(three);
		assertEquals(compList, D.getShortestPath(three));
		
		compList.clear();
		compList.add(one);
		compList.add(four);
		assertEquals(compList, D.getShortestPath(four));
		
		compList.add(five);
		assertEquals(compList, D.getShortestPath(five));
	}
	
	@Test (timeout = 5000)
	public void getShortestPathTo2() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		String one = "one";
		String two = "two";
		String three = "three";
		String four = "four";
		String five = "five";
		
		G.addEdge(one, two, 5);
		G.addEdge(five, four, 2);
		G.addEdge(four, three, 2);
		G.addEdge(three, two, 2);
		G.addEdge(one, three, 9);
		G.addEdge(one, five, 2);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		List<String> compList = new ArrayList<String>();
		
		D.run(one);
		compList.add(one);
		compList.add(two);
		assertEquals(compList, D.getShortestPath(two));
		
		compList.clear();
		compList.add(one);
		compList.add(five);
		compList.add(four);
		assertEquals(compList, D.getShortestPath(four));
		
		compList.add(three);
		assertEquals(compList, D.getShortestPath(three));
	}
	
	@Test (timeout = 5000)
	public void getShortestPathTo3() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		String one = "one";
		String two = "two";
		String three = "three";
		G.addEdge(one, two, 2);
		G.addVertex(three);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		List<String> compList = new ArrayList<String>();
		
		D.run(one);
		compList.clear();
		assertEquals(compList, D.getShortestPath(three));
	}
	
	@Test (timeout = 5000)
	public void getShortestPathTo4() {
		CS228DirectedGraph<String> G = new CS228DirectedGraph<String>();
		String one = "one";
		String two = "two";
		String three = "three";
		String four = "four";
		G.addEdge(one, two, 2);
		G.addEdge(three, four, 3);
		
		CS228Dijkstra<String> D = new CS228Dijkstra<String>(G);
		List<String> compList = new ArrayList<String>();
		
		D.run(one);
		compList.clear();
		assertEquals(compList, D.getShortestPath(four));
	}

}
