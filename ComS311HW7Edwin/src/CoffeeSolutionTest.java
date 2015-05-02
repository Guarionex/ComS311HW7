import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CoffeeSolutionTest {
	
	Graph<Vertex, Edge> graph;
	Graph<Vertex, Edge> graph2;
	Graph<Vertex, Edge> graph3;
	Graph<Vertex, Edge> coffeeGraph;
	Dijkstra<Vertex, Edge> digimon;
	Weighing<Edge> weight;
	CoffeeSolver<Vertex, Edge> coffee;
	Graph<Vertex, Edge> ames;
	GraphGen cartographer;
	
	
	@Before
	public void setup()
	{
		graph = new DirectedGraph<Vertex, Edge>();
		graph2 = new DirectedGraph<Vertex, Edge>();
		graph3 = new DirectedGraph<Vertex, Edge>();
		coffeeGraph = new DirectedGraph<Vertex, Edge>();
		digimon = new EdsgerWDijkstra<Vertex, Edge>();
		weight = new Weights();
		coffee = new CoffeeSolution<Vertex, Edge>();
		ames = new DirectedGraph<Vertex, Edge>();
		cartographer = new GraphGen("AmesData.txt");
		
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
		
		Vertex vA = new Vertex(0, 1, 1);
		Vertex vB = new Vertex(1, 1, 1);
		Vertex vC = new Vertex(2, 1, 1);
		Vertex vD = new Vertex(3, 1, 1);
		Edge eA1 = new Edge(0, vA, vB, 1);
		Edge eA2 = new Edge(1, vA, vD, 1);
		Edge eB = new Edge(2, vB, vD, 1);
		Edge eC = new Edge(3, vC, vD, 1);
		graph2.addVertex(vA);
		graph2.addVertex(vB);
		graph2.addVertex(vC);
		graph2.addVertex(vD);
		graph2.addEdge(0, 1, eA1);
		graph2.addEdge(0, 3, eA2);
		graph2.addEdge(1, 3, eB);
		graph2.addEdge(2, 3, eC);
		
		Vertex vA2 = new Vertex(0, 1, 1);
		Vertex vB2 = new Vertex(1, 1, 1);
		Vertex vC2 = new Vertex(2, 1, 1);
		Vertex vD2 = new Vertex(3, 1, 1);
		Edge eA12 = new Edge(0, vA2, vB2, 1);
		Edge eA22 = new Edge(1, vA2, vD2, 1);
		Edge eA32 = new Edge(2, vA2, vC2, 1);
		Edge eB2 = new Edge(3, vB2, vD2, 1);
		graph3.addVertex(vA);//0
		graph3.addVertex(vB);//1
		graph3.addVertex(vC);//2
		graph3.addVertex(vD);//3
		graph3.addEdge(0, 1, eA12);
		graph3.addEdge(0, 2, eA32);
		graph3.addEdge(0, 3, eA22);
		graph3.addEdge(1, 3, eB2);
		
		
		Vertex A = new Vertex(1055, 42.059112, -93.632995);
		Vertex B = new Vertex(371, 42.019621, -93.651759);
		Vertex C = new Vertex(2874, 42.012025, -93.671429);
		Vertex D = new Vertex(2351, 42.012053, -93.6489);
		Vertex E = new Vertex(2956, 42.009345, -93.67229);
		Vertex F = new Vertex(1171, 42.053516, -93.649586);
		Vertex G = new Vertex(1208, 42.031262, -93.620315);
		Vertex you = new Vertex(2893, 42.011189, -93.682421);
		Edge Ab = new Edge(0, A, B, 1);
		Edge Ae = new Edge(1, A, E, 1);
		Edge Ag = new Edge(2, A, G, 1);
		Edge Bc = new Edge(3, B, C, 1);
		Edge Bd = new Edge(4, B, D, 1);
		Edge Bg = new Edge(5, B, G, 1);
		Edge Cg = new Edge(6, C, G, 1);
		Edge De = new Edge(7, D, E, 1);
		Edge Df = new Edge(8, D, F, 1);
		Edge Dg = new Edge(9, D, G, 1);
		Edge Eg = new Edge(10, E, G, 1);
		Edge Fg = new Edge(11, F, G, 1);
		Edge youA = new Edge(12, you, A, 1);
		coffeeGraph.addVertex(you);//0
		coffeeGraph.addVertex(A);//1
		coffeeGraph.addVertex(B);//2
		coffeeGraph.addVertex(C);//3
		coffeeGraph.addVertex(D);//4
		coffeeGraph.addVertex(E);//5
		coffeeGraph.addVertex(F);//6
		coffeeGraph.addVertex(G);//7
		//coffeeGraph.addVertex(you);//7
		coffeeGraph.addEdge(1, 2, Ab);
		coffeeGraph.addEdge(1, 5, Ae);
		coffeeGraph.addEdge(1, 7, Ag);
		coffeeGraph.addEdge(2, 3, Bc);
		coffeeGraph.addEdge(2, 4, Bd);
		coffeeGraph.addEdge(2, 7, Bg);
		coffeeGraph.addEdge(3, 7, Cg);
		coffeeGraph.addEdge(4, 5, De);
		coffeeGraph.addEdge(4, 6, Df);
		coffeeGraph.addEdge(4, 7, Dg);
		coffeeGraph.addEdge(5, 7, Eg);
		coffeeGraph.addEdge(6, 7, Fg);
		coffeeGraph.addEdge(0, 1, youA);
		
		try {
			ames = cartographer.makeGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Test
	public void testSortVertices() {
		System.out.println("A topo:");
//		coffee = new CoffeeSolution<Vertex, Edge>();
//		List<Integer> topoPath = coffee.sortVertices(graph);
//		System.out.println(topoPath);
//		List<Integer> topoPath2 = coffee.sortVertices(graph2);
//		System.out.println(topoPath2);
		List<Integer> coffeeTopo = coffee.sortVertices(coffeeGraph);
		System.out.println(coffeeTopo);
	}

	@Test
	public void testShortestPath() {
		List<Integer> vertices = coffee.sortVertices(coffeeGraph);
		List<Integer> IDs = new ArrayList<Integer>();
		for(Integer v: vertices)
		{
			IDs.add(coffeeGraph.getData(v).getID());
		}
		List<Integer> shortestPath = coffee.shortestPath(ames,IDs, weight);
		System.out.println("");
		System.out.println("Shortest Path:");
		System.out.println(shortestPath);
	}

	@Test
	public void testGenerateValidSortS() {
		System.out.println("All topo:");
//		//coffee = new CoffeeSolution<Vertex, Edge>();
//		//Collection<List<Integer>> allTopo = coffee.generateValidSortS(graph);		
//		//System.out.println(allTopo);
//		System.out.println("");
		Collection<List<Integer>> allTopo2 = coffee.generateValidSortS(graph2);
		System.out.println(allTopo2);
		Collection<List<Integer>> allTopo3 = coffee.generateValidSortS(graph3);
		System.out.println(allTopo3);
//		Collection<List<Integer>> allCoffeeTopo = coffee.generateValidSortS(coffeeGraph);
//		System.out.println(allCoffeeTopo);
	}

}
