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
		Vertex v5 = new Vertex(5,42.030437,-93.627378);
		Vertex v6 = new Vertex(6,42.03189,-93.627581);
		Vertex v7 = new Vertex(7,42.028463,-93.626962);
		Vertex v8 = new Vertex(8,42.031021,-93.671147);
		Vertex v9 = new Vertex(9,42.03097,-93.671247);
		Vertex v10 = new Vertex(10,42.031074,-93.671485);
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
		//Edge e10 = new Edge(10, v, v5, 4.283);
		//Edge e11 = new Edge(11, v, v6, 4.332);
		//Edge e12 = new Edge(12, v, v7, 4.236);
		//Edge e13 = new Edge(13, v, v8, 1.740);
		//Edge e14 = new Edge(14, v, v9, 1.733);
		//Edge e15 = new Edge(15, v, v10, 1.740);
		Edge e16 = new Edge(16, v1, v5, 4.394);
		Edge e17 = new Edge(17, v1, v6, 4.455);
		Edge e18 = new Edge(18, v1, v7, 4.331);
		Edge e19 = new Edge(19, v1, v8, 2.066);
		Edge e20 = new Edge(20, v1, v9, 2.059);
		//Edge e21 = new Edge(21, v1, v10, 2.068);
		Edge e22 = new Edge(22, v2, v5, 4.325);
		Edge e23 = new Edge(23, v2, v6, 4.383);
		Edge e24 = new Edge(24, v2, v7, 4.267);
		Edge e25 = new Edge(25, v2, v8, 1.958);
		Edge e26 = new Edge(26, v2, v9, 1.951);
		//Edge e27 = new Edge(27, v2, v10, 1.960);
		Edge e28 = new Edge(28, v3, v5, 4.282);
		Edge e29 = new Edge(29, v3, v6, 4.334);
		Edge e30 = new Edge(30, v3, v7, 4.230);
		Edge e31 = new Edge(31, v3, v8, 1.820);
		Edge e32 = new Edge(32, v3, v9, 1.813);
		//Edge e33 = new Edge(33, v3, v10, 1.822);
		Edge e34 = new Edge(34, v4, v5, 4.382);
		Edge e35 = new Edge(35, v4, v6, 4.442);
		Edge e36 = new Edge(36, v4, v7, 4.320);
		Edge e37 = new Edge(37, v4, v8, 2.049);
		Edge e38 = new Edge(38, v4, v9, 2.042);
		//Edge e39 = new Edge(39, v4, v10, 2.050);
		Edge e40 = new Edge(40, v5, v6, 0.1624);
		Edge e41 = new Edge(41, v5, v7, 0.2222);
		Edge e42 = new Edge(42, v5, v8, 3.616);
		Edge e43 = new Edge(43, v5, v9, 3.624);
		//Edge e44 = new Edge(44, v5, v10, 3.644 );
		Edge e45 = new Edge(45, v6, v7, 0.3845);
		Edge e46 = new Edge(46, v6, v8, 3.600);
		Edge e47 = new Edge(47, v6, v9, 3.608);
		//Edge e48 = new Edge(48, v6, v10, 3.627);
		Edge e49 = new Edge(49, v7, v8, 3.661);
		Edge e50 = new Edge(50, v7, v9, 3.668);
		//Edge e51 = new Edge(51, v7, v10, 3.689);
		Edge e52 = new Edge(52, v8, v9, 0.01002);
		//Edge e53 = new Edge(53, v8, v10, 0.02853);
		Edge e54 = new Edge(54, v9, v10, 0.02281);
		gEdge.addVertex(v);
		gEdge.addVertex(v1);
		gEdge.addVertex(v2);
		gEdge.addVertex(v3);
		gEdge.addVertex(v4);
		gEdge.addVertex(v5);
		gEdge.addVertex(v6);
		gEdge.addVertex(v7);
		gEdge.addVertex(v8);
		gEdge.addVertex(v9);
		gEdge.addVertex(v10);
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
		//gEdge.addEdge(0, 5, e10);
		//gEdge.addEdge(0, 6, e11);
		//gEdge.addEdge(0, 7, e12);
		//gEdge.addEdge(0, 8, e13);
		//gEdge.addEdge(0, 9, e14);
		//gEdge.addEdge(0, 10, e15);
		gEdge.addEdge(1, 5, e16);
		gEdge.addEdge(1, 6, e17);
		gEdge.addEdge(1, 7, e18);
		gEdge.addEdge(1, 8, e19);
		gEdge.addEdge(1, 9, e20);
		//gEdge.addEdge(1, 10, e21);
		gEdge.addEdge(2, 5, e22);
		gEdge.addEdge(2, 6, e23);
		gEdge.addEdge(2, 7, e24);
		gEdge.addEdge(2, 8, e25);
		gEdge.addEdge(2, 9, e26);
		//gEdge.addEdge(2, 10, e27);
		gEdge.addEdge(3, 5, e28);
		gEdge.addEdge(3, 6, e29);
		gEdge.addEdge(3, 7, e30);
		gEdge.addEdge(3, 8, e31);
		gEdge.addEdge(3, 9, e32);
		//gEdge.addEdge(3, 10, e33);
		gEdge.addEdge(4, 5, e34);
		gEdge.addEdge(4, 6, e35);
		gEdge.addEdge(4, 7, e36);
		gEdge.addEdge(4, 8, e37);
		gEdge.addEdge(4, 9, e38);
		//gEdge.addEdge(4, 10, e39);
		gEdge.addEdge(5, 6, e40);
		gEdge.addEdge(5, 7, e41);
		gEdge.addEdge(5, 8, e42);
		gEdge.addEdge(5, 9, e43);
		//gEdge.addEdge(5, 10, e44);
		gEdge.addEdge(6, 7, e45);
		gEdge.addEdge(6, 8, e46);
		gEdge.addEdge(6, 9, e47);
		//gEdge.addEdge(6, 10, e48);
		gEdge.addEdge(7, 8, e49);
		gEdge.addEdge(7, 9, e50);
		//gEdge.addEdge(7, 10, e51);
		gEdge.addEdge(8, 9, e52);
		//gEdge.addEdge(8, 10, e53);
		gEdge.addEdge(9, 10, e54);
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
