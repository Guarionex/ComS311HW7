import static org.junit.Assert.*;

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
		weight = new Weights<Edge>();
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
		fail("Not yet implemented");
	}

	@Test
	public void testSetStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWeighing() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputeShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCost() {
		fail("Not yet implemented");
	}

}
