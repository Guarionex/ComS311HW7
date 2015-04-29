import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CoffeeSolutionTest {
	
	Graph<Vertex, Edge> graph;
	Dijkstra<Vertex, Edge> digimon;
	Weighing<Edge> weight;
	CoffeeSolver<Vertex, Edge> coffee;
	
	
	@Before
	public void setup()
	{
		graph = new DirectedGraph<Vertex, Edge>();
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		weight = new Weights();
		coffee = new CoffeeSolution<Vertex, Edge>();
		
		Vertex v0 = new Vertex(0, 1, 1);
		Vertex v1 = new Vertex(1, 1, 1);
		Vertex v2 = new Vertex(2, 1, 1);
		Vertex v3 = new Vertex(3, 1, 1);
		Vertex v4 = new Vertex(4, 1, 1);
		Vertex v5 = new Vertex(5, 1, 1);
		Vertex v6 = new Vertex(6, 1, 1);
		Vertex v7 = new Vertex(7, 1, 1);
		Edge e0 = new Edge(0, v0, v3, 1);
		Edge e1 = new Edge(1, v0, v4, 1);
		Edge e2 = new Edge(2, v1, v3, 1);
		Edge e3 = new Edge(3, v2, v4, 1);
		Edge e4 = new Edge(4, v2, v7, 1);
		Edge e5 = new Edge(5, v3, v5, 1);
		Edge e6 = new Edge(6, v3, v6, 1);
		Edge e7 = new Edge(7, v3, v7, 1);
		Edge e8 = new Edge(8, v4, v6, 1);
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addEdge(0, 3, e0);
		graph.addEdge(0, 4, e1);
		graph.addEdge(1, 3, e2);
		graph.addEdge(2, 4, e3);
		graph.addEdge(2, 7, e4);
		graph.addEdge(3, 5, e5);
		graph.addEdge(3, 6, e6);
		graph.addEdge(3, 7, e7);
		graph.addEdge(4, 6, e8);
	}


	@Test
	public void testSortVertices() {
		coffee = new CoffeeSolution<Vertex, Edge>();
		List<Integer> topoPath = coffee.sortVertices(graph);
		System.out.println(topoPath);
	}

	@Test
	public void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateValidSortS() {
		fail("Not yet implemented");
	}

}
