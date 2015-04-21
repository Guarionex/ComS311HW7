package edu.iastate.cs228.hw5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Case for CS228Dijkstra
 * 
 * @author Mike Patrick
 *
 */
public class DijkstraTest {
	
	CS228DirectedGraph<String> grap2;
	CS228DirectedGraph<String> grap;
	CS228Dijkstra<String> d;
	CS228Dijkstra<String> d2;

	@Before
	public void setUp() {
		
		grap = new CS228DirectedGraph<String>();
		grap2 = new CS228DirectedGraph<String>();
		
		grap.addEdge("A", "B", 2);
		grap.addEdge("A", "F", 3);
		grap.addEdge("E", "A", 7);
		grap.addEdge("F", "E", 1);
		grap.addEdge("C", "B", 1);
		grap.addEdge("C", "D", 5);
		grap.addEdge("C", "H", 3);
		grap.addEdge("D", "H", 7);
		grap.addEdge("B", "F", 6);
		grap.addEdge("G", "A", 5);
		grap.addEdge("B", "G", 1);
		grap.addEdge("F", "C", 2);
		grap.addEdge("D", "I", 3);
		grap.addEdge("D", "J", 8);
		grap.addEdge("G", "F", 2);
		grap.addEdge("G", "H", 5);
		grap.addEdge("G", "K", 4);
		grap.addEdge("H", "I", 1);
		grap.addEdge("J", "I", 2);
		grap.addEdge("E", "K", 4);
		grap.addEdge("F", "K", 8);
		grap.addEdge("K", "L", 3);
		grap.addEdge("G", "L", 2);
		grap.addEdge("L", "H", 6);
		grap.addEdge("H", "M", 3);
		grap.addEdge("I", "L", 1);
		grap.addEdge("I", "M", 1);
		grap.addEdge("J", "M", 2);
		grap.addEdge("E", "N", 1);
		grap.addEdge("P", "E", 4);
		grap.addEdge("P", "F", 3);
		grap.addEdge("K", "P", 6);
		grap.addEdge("N", "G", 7);
		grap.addEdge("Q", "K", 6);
		grap.addEdge("P", "Q", 4);
		grap.addEdge("K", "N", 2);
		grap.addEdge("M", "L", 3);
		grap.addEdge("L", "N", 2);
		grap.addEdge("P", "N", 3);
		grap.addEdge("N", "M", 4);
		grap.addEdge("L", "O", 1);
		grap.addEdge("N", "O", 7);
		grap.addEdge("M", "O", 1);
		grap.addEdge("O", "K", 4);
		grap.addEdge("N", "V", 3);
		grap.addEdge("T", "N", 9);
		grap.addEdge("N", "Q", 5);
		grap.addEdge("N", "R", 5);
		grap.addEdge("O", "R", 1);
		grap.addEdge("O", "S", 6);
		grap.addEdge("T", "O", 2);
		grap.addEdge("M", "T", 5);
		grap.addEdge("R", "Q", 8);
		grap.addEdge("M", "U", 4);
		grap.addEdge("M", "X", 9);
		grap.addEdge("M", "Y", 1);
		grap.addEdge("J", "Y", 4);
		grap.addEdge("Y", "U", 3);
		grap.addEdge("U", "J", 3);
		grap.addEdge("T", "W", 5);
		grap.addEdge("S", "T", 1);
		grap.addEdge("S", "M", 3);
		grap.addEdge("T", "U", 3);
		grap.addEdge("U", "S", 8);
		grap.addEdge("V", "U", 6);
		grap.addEdge("S", "W", 1);
		grap.addEdge("V", "S", 2);
		grap.addEdge("Q", "V", 2);
		grap.addEdge("S", "R", 7);
		grap.addEdge("R", "V", 5);
		grap.addEdge("W", "U", 2);
		grap.addEdge("U", "X", 6);
		grap.addEdge("X", "W", 2);
		grap.addEdge("Y", "X", 3);
		grap.addEdge("X", "Z", 5);
		grap.addEdge("W", "Z", 3);
		grap.addEdge("Z", "V", 8);
		grap.addEdge("J", "T", 2);
		grap.addEdge("J", "U", 1);
		grap.addEdge("J", "X", 4);
		grap.addEdge("Q", "T", 7);
		grap.addEdge("G", "C", 3);
		grap.addEdge("Q", "S", 6);
		grap.addEdge("Z", "Y", 8);
		grap.addEdge("A", "a", 2);
		
		grap2.addEdge("A", "F", 3);
		grap2.addEdge("B", "E", 2);
		grap2.addEdge("E", "B", 5);
		grap2.addEdge("E", "I", 1);
		grap2.addEdge("I", "E", 3);
		grap2.addEdge("B", "J", 8);
		grap2.addEdge("F", "C", 7);
		grap2.addEdge("C", "H", 2);
		grap2.addEdge("G", "D", 6);
		grap2.addEdge("D", "H", 1);
		grap2.addEdge("C", "D", 2);
		grap2.addEdge("J", "N", 10);
		grap2.addEdge("N", "L", 4);
		grap2.addEdge("L", "J", 6);
		grap2.addEdge("N", "M", 3);
		grap2.addEdge("K", "M", 1);
		
		d = new CS228Dijkstra<String>(grap);
		d2 = new CS228Dijkstra<String>(grap2);
	}

	@Test
	//successive calls to run() change the source vertex
	public void runTest0() {
		
		d.run("A");
		assertEquals(2, d.getShortestDistance("B"));
		assertEquals(0, d.getShortestDistance("A"));
		d.run("B");
		assertEquals(0, d.getShortestDistance("B"));
		d.run("C");
		assertEquals(1, d.getShortestDistance("B"));
		assertEquals(0, d.getShortestDistance("C"));
	}

	@Test(expected = IllegalArgumentException.class)
	//If supplied vertex is not in the graph throw IllegalArgumentException
	public void runTest1() {
		d.run("b");
	}

	@Test(expected = IllegalArgumentException.class)
	//If the supplied vertex is null throw IllegalArgumentException
	public void runTest2(){
		d.run(null);
	}
	@Test
	//Test distances from A
	public void getShortestDistanceTest0() {
		
		d.run("A");
		assertEquals(7, d.getShortestDistance("K"));
		assertEquals(5, d.getShortestDistance("C"));
		assertEquals(2, d.getShortestDistance("B"));
		assertEquals(10, d.getShortestDistance("S"));
		assertEquals(13, d.getShortestDistance("P"));
		assertEquals(16, d.getShortestDistance("J"));
		
		d2.run("A");
		assertEquals(12, d2.getShortestDistance("H"));
		assertEquals(12, d2.getShortestDistance("D"));
	}

	@Test
	//Test distances from W
	public void getShortestDistanceTest1(){
		d.run("W");
		assertEquals(2, d.getShortestDistance("U"));
		assertEquals(3, d.getShortestDistance("Z"));
		assertEquals(5, d.getShortestDistance("J"));
		assertEquals(7, d.getShortestDistance("M"));
		assertEquals(10, d.getShortestDistance("S"));
	}
	@Test
	// Return Integer.MAX_VALUE if there is no edge connecting the vertices or
	// if the supplied vertex is not in the graph
	public void getShortestDistanceTest2() {
		d.run("a");
		d2.run("B");
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("A"));
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("X"));
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("B"));
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("Q"));
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("Quack"));
		
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("A"));
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("H"));
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("K"));
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("Moo"));
		d2.run("D");
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("R"));
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("C"));
		assertEquals(Integer.MAX_VALUE, d2.getShortestDistance("Q"));
		d.run("W");
		assertEquals(Integer.MAX_VALUE, d.getShortestDistance("Woof"));
		assertEquals(8, d.getShortestDistance("Y"));
	}
	@Test(expected=RuntimeException.class)
	//If no call to run has been made throw RuntimeException
	public void getShortestDistanceTest3(){
		d.getShortestDistance("H");
	}
	@Test
	//Test Paths with source A
	public void getShortestPathTest0() {
	
		List<String> A_to_J_list = new ArrayList<String>();
		A_to_J_list.add("A");
		A_to_J_list.add("F");
		A_to_J_list.add("E");
		A_to_J_list.add("N");
		A_to_J_list.add("M");
		A_to_J_list.add("U");
		A_to_J_list.add("J");

		List<String> A_to_S_list = new ArrayList<String>();
		A_to_S_list.add("A");
		A_to_S_list.add("F");
		A_to_S_list.add("E");
		A_to_S_list.add("N");
		A_to_S_list.add("V");
		A_to_S_list.add("S");

		List<String> A_to_P_list = new ArrayList<String>();
		A_to_P_list.add("A");
		A_to_P_list.add("B");
		A_to_P_list.add("G");
		A_to_P_list.add("K");
		A_to_P_list.add("P");

		d.run("A");
		assertEquals(A_to_J_list, d.getShortestPath("J"));
		assertEquals(A_to_S_list, d.getShortestPath("S"));
		assertEquals(A_to_P_list, d.getShortestPath("P"));
		

	}
	@Test
	//Test Paths with source W
	public void getShortestPathTest1(){
		List<String> W_to_Y_list = new ArrayList<String>();
		W_to_Y_list.add("W");
		W_to_Y_list.add("U");
		W_to_Y_list.add("J");
		W_to_Y_list.add("M");
		W_to_Y_list.add("Y");
		
		List<String> W_to_A_list = new ArrayList<String>();
		W_to_A_list.add("W");
		W_to_A_list.add("U");
		W_to_A_list.add("J");
		W_to_A_list.add("I");
		W_to_A_list.add("L");
		W_to_A_list.add("N");
		W_to_A_list.add("G");
		W_to_A_list.add("A");
		d.run("W");
		assertEquals(W_to_Y_list, d.getShortestPath("Y"));
		assertEquals(W_to_A_list, d.getShortestPath("A"));
		
	}

	@Test(expected = RuntimeException.class)
	// Throw exception if getShortestPath is called with no prior call to run()
	public void getShortestPathTest2() {
		d.getShortestPath("X");
	}

	@Test
	//If there is no path return an empty list
	public void getShortestPathTest3() {
		List<String> emptyList = new ArrayList<String>();
		d.run("a");
		d2.run("A");
		assertEquals(emptyList, d.getShortestPath("Z"));
		assertEquals(emptyList, d.getShortestPath("A"));
		assertEquals(emptyList, d2.getShortestPath("K"));
		assertEquals(emptyList, d2.getShortestPath("L"));
		assertEquals(emptyList, d2.getShortestPath("N"));
		assertEquals(emptyList, d2.getShortestPath("E"));
		assertEquals(emptyList, d2.getShortestPath("M"));
		
		d2.run("G");
		assertEquals(emptyList, d2.getShortestPath("A"));
		assertEquals(emptyList, d2.getShortestPath("K"));
		d2.run("J");
		assertEquals(emptyList, d2.getShortestPath("B"));
		assertEquals(emptyList, d2.getShortestPath("I"));

	}
	@Test
	//If the supplied vertex does not exist return an empty list
	public void getShortestPathTest4(){
		List<String> emptyList = new ArrayList<String>();
		d.run("D");
		assertEquals(emptyList, d.getShortestPath("z"));
	}
	@Test
	//If the supplied vertex is the source, return a list containing only the source
	public void getShortestPathTest5(){
		List<String> sourceOnlyList = new ArrayList<String>();
		sourceOnlyList.add("L");
		d.run("L");
		assertEquals(sourceOnlyList, d.getShortestPath("L"));
		d.run("R");
		sourceOnlyList.clear();
		sourceOnlyList.add("R");
		assertEquals(sourceOnlyList, d.getShortestPath("R"));
		d.run("a");
		sourceOnlyList.clear();
		sourceOnlyList.add("a");
		assertEquals(sourceOnlyList, d.getShortestPath("a"));
		
	}
}
