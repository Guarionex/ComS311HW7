import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class DijkstraTest {

	Graph<Vertex, Edge> gEdge;
	Dijkstra<Vertex, Edge> digimon;
	Weighing<Edge> weight;
	
	@Before
	public void setup() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		weight = new Weights();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		Edge e4 = new Edge(4, v, v2, 0.2381);
		Edge e5 = new Edge(5, v, v3, 0.09703);
		Edge e6 = new Edge(6, v, v4, 0.3220);
		Edge e7 = new Edge(7, v1, v3, 0.2475);
		Edge e8 = new Edge(8, v1, v4, 0.01739);
		Edge e9 = new Edge(9, v2, v4, 0.09063);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		gEdge.addEdge(0, 2, e4);
		gEdge.addEdge(0, 3, e5);
		gEdge.addEdge(0, 4, e6);
		gEdge.addEdge(1, 3, e7);
		gEdge.addEdge(1, 4, e8);
		gEdge.addEdge(2, 4, e9);
	}
	
	@Test
	public void testSetGraph() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
	}

	@Test(expected = IllegalStateException.class)
	public void testSetStartException1() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setStart(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetStartException2() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(100);
	}
	
	@Test
	public void testSetStart() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
	}

	@Test
	public void testSetWeighing() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
		digimon.setWeighing(weight);
	}

	@Test(expected = IllegalStateException.class)
	public void testComputeShortestPathException1() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		//digimon.setGraph(gEdge);
		digimon.setStart(0);
		digimon.setWeighing(weight);
		digimon.computeShortestPath();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testComputeShortestPathException2() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		//digimon.setStart(0);
		digimon.setWeighing(weight);
		digimon.computeShortestPath();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testComputeShortestPathException3() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
		//digimon.setWeighing(weight);
		digimon.computeShortestPath();
	}
	
	@Test
	public void testComputeShortestPath() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
		digimon.setWeighing(weight);
		digimon.computeShortestPath();
	}

	@Test
	public void testGetPath() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
		digimon.setWeighing(weight);
		digimon.computeShortestPath();
		List<Integer> path1 = digimon.getPath(1);
		List<Integer> path2 = digimon.getPath(2);
		List<Integer> path3 = digimon.getPath(3);
		List<Integer> path4 = digimon.getPath(4);
		List<Integer> correctPath1 = new ArrayList<Integer>();
		correctPath1.add(0, 1);
		correctPath1.add(0, 0);
		assertEquals(correctPath1, path1);
		List<Integer> correctPath2 = new ArrayList<Integer>();
		correctPath2.add(0, 2);
		correctPath2.add(0, 0);
		assertEquals(correctPath2, path2);
		List<Integer> correctPath3 = new ArrayList<Integer>();
		correctPath3.add(0, 3);
		correctPath3.add(0, 0);
		assertEquals(correctPath3, path3);
		List<Integer> correctPath4 = new ArrayList<Integer>();
		correctPath4.add(0, 4);
		correctPath4.add(0, 0);
		assertEquals(correctPath4, path4);
	}

	@Test
	public void testGetCost() {
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		digimon.setGraph(gEdge);
		digimon.setStart(0);
		digimon.setWeighing(weight);
		digimon.computeShortestPath();
		double cost1 = digimon.getCost(1);
		double cost2 = digimon.getCost(2);
		double cost3 = digimon.getCost(3);
		double cost4 = digimon.getCost(4);
		assertEquals(0.3377, cost1, 0.0000);
		assertEquals(0.2381, cost2, 0.0000);
		assertEquals(0.09703, cost3, 0.0000);
		assertEquals(0.3220, cost4, 0.0000);
	}

}
