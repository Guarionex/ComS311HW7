import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class GraphTest {
	Graph<Vertex, Edge> g;
	Graph<Vertex, Edge> g1;
	Graph<Vertex, Edge> gEdge;
	
	
	@Before
	public void setup()
	{
		g = new DirectedGraph<Vertex, Edge>();
		g1 = new DirectedGraph<Vertex, Edge>();
		gEdge = new DirectedGraph<Vertex, Edge>();
	}
	
	@Test
	public void testAddVertex() {
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		assertEquals(0, g.addVertex(v));
		assertEquals(1, g.addVertex(v1));
		assertEquals(2, g.addVertex(v2));
		assertEquals(3, g.addVertex(v3));
		assertEquals(4, g.addVertex(v4));
	}

	@Test
	public void testAddEdge() {
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		assertEquals(0, gEdge.addEdge(0, 1, e));
		assertEquals(1, gEdge.addEdge(1, 2, e1));
		assertEquals(2, gEdge.addEdge(2, 3, e2));
		assertEquals(3, gEdge.addEdge(3, 4, e3));
		
		
	}

	@Test
	public void testGetVertices() {
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		g1.addVertex(v);
		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g1.addVertex(v4);
		//System.out.println(g1.getVertices().toString());
		assertTrue(g1.getVertices().contains(0));
		assertTrue(g1.getVertices().contains(1));
		assertTrue(g1.getVertices().contains(2));
		assertTrue(g1.getVertices().contains(3));
		assertTrue(g1.getVertices().contains(4));
	}

	@Test
	public void testGetEdges() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		//System.out.println(gEdge.getEdges().toString());
		assertTrue(gEdge.getEdges().contains(0));
		assertTrue(gEdge.getEdges().contains(1));
		assertTrue(gEdge.getEdges().contains(2));
		assertTrue(gEdge.getEdges().contains(3));
		
	}

	@Test
	public void testGetAttribute() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		assertEquals(e, gEdge.getAttribute(0));
		assertEquals(e1, gEdge.getAttribute(1));
		assertEquals(e2, gEdge.getAttribute(2));
		assertEquals(e3, gEdge.getAttribute(3));
	}

	@Test
	public void testGetData() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		assertEquals(v, gEdge.getData(0));
		assertEquals(v1, gEdge.getData(1));
		assertEquals(v2, gEdge.getData(2));
		assertEquals(v3, gEdge.getData(3));
		assertEquals(v4, gEdge.getData(4));
	}

	@Test
	public void testGetSource() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		assertEquals(0, gEdge.getSource(0));
		assertEquals(1, gEdge.getSource(1));
		assertEquals(2, gEdge.getSource(2));
		assertEquals(3, gEdge.getSource(3));
	}

	@Test
	public void testGetTarget() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		assertEquals(1, gEdge.getTarget(0));
		assertEquals(2, gEdge.getTarget(1));
		assertEquals(3, gEdge.getTarget(2));
		assertEquals(4, gEdge.getTarget(3));
	}

	@Test
	public void testGetEdgesOf() {
		gEdge = new DirectedGraph<Vertex, Edge>();
		Set<Integer> blankSet = new HashSet<Integer>();
		Vertex v = new Vertex(0,42.015676,-93.675264);
		Vertex v1 = new Vertex(1,42.012652,-93.674882);
		Vertex v2 = new Vertex(2,42.013596,-93.674578);
		Vertex v3 = new Vertex(3,42.014877,-93.674792);
		Vertex v4 = new Vertex(4,42.0128,-93.674814);
		Edge e = new Edge(0, v, v1, 0.3377);
		Edge e1 = new Edge(1, v1, v2, 0.1079);
		Edge e2 = new Edge(2, v2, v3, 0.1435);
		Edge e3 = new Edge(3, v3, v4, 0.2310);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addEdge(0, 1, e);
		gEdge.addEdge(1, 2, e1);
		gEdge.addEdge(2, 3, e2);
		gEdge.addEdge(3, 4, e3);
		assertTrue(gEdge.getEdgesOf(0).contains(0));
		assertTrue(gEdge.getEdgesOf(1).contains(1));
		assertTrue(gEdge.getEdgesOf(2).contains(2));
		assertTrue(gEdge.getEdgesOf(3).contains(3));
		assertEquals(blankSet, gEdge.getEdgesOf(4));
	}

}
