package edu.iastate.cs228.hw5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 * Dijkstra class that runs the Dijkstra algorithm to find the shortest distance in terms of cost and 
 * shortest path
 * @author Edwin O. Martinez
 *
 * @param <V>
 * Generic Vertex
 */
public class CS228Dijkstra<V> {
	/**
	 * Stores a CS228DirecredGraph into variable graph for use through the whole class
	 */
	public CS228DirectedGraph<V> graph;
	/**
	 * stores the shortest distance to the source
	 */
	public HashMap<V, Integer> dist;
	/**
	 * stores the vertex that is right before the current vertex along the shortest path
	 */
	public HashMap<V, V> pred;
	/**
	 * used to keep pairs of vertices and their tentative distances
	 */
	public Heap<Pair<V, Integer>> priq;
	/**
	 * used to keep a set of vertices whose distances have been computed
	 */
	public HashSet<V> vset;
	/**
	 * boolean to keep track if the run method was called
	 */
	private boolean runCheck = false;
	/**
	 * Dijkstra constructor that takes in a graph and initializes the variables
	 * @param nGraph
	 * CS228DirectedGraph to take be analyzed
	 */
	public CS228Dijkstra(CS228DirectedGraph<V> nGraph){
		if(nGraph == null){
			throw new IllegalArgumentException();
		}
		graph = nGraph;
		dist = new HashMap<V, Integer>();
		pred = new HashMap<V, V>();
		priq = new Heap<Pair<V, Integer>>();
		vset = new HashSet<V>();
	}
	/**
	 * run method that takes in a vertex as a source and analyzes all vertices with respect to the source
	 * @param source
	 * source vertex
	 */
	public void run(V source){
		if (source == null || !graph.hasVertex(source)){
			throw new IllegalArgumentException();
		}
		//Resets whichever value dist, pred, priq, and vset had to be able to run again cleanly
		dist = new HashMap<V, Integer>();
		pred = new HashMap<V, V>();
		priq = new Heap<Pair<V, Integer>>();
		vset = new HashSet<V>();
		
		for (V w: graph.vertices()){
			dist.put(w, Integer.MAX_VALUE);
			pred.put(w, null);
		}
		
		dist.put(source, 0);
		pred.put(source, source);
		priq.add(new Pair<V, Integer>(source, 0));
		
		while (!priq.isEmpty()){
			Pair<V, Integer> pair = priq.removeMin();
			V u = pair.getVertex();
			if (!vset.contains(u)){
				vset.add(u);
				
				for (Pair<V, Integer> edge: graph.adjacentTo(u)){
					V v = edge.getVertex();
					Integer cost = edge.getCost();
					if (dist.get(v) > dist.get(u) + cost){
						dist.put(v, dist.get(u) + cost);
						pred.put(v, u);
						priq.add( new Pair<V, Integer>(v, dist.get(v) ) );
					}
				}
			}
		}
		runCheck = true;
	}
	/**
	 * Gives a list with all the vertices along the shortest path from the input vertex to the source
	 * @param vertex
	 * vertex to get shortest path to
	 * @return
	 * List containing vertices from the source vertex to the inputed vertex along the shortest path
	 */
	public List<V> getShortestPath(V vertex){
		if(vertex == null){
			throw new IllegalArgumentException();
		}
		if(!runCheck){
			throw new RuntimeException();
		}
		ArrayList<V> list = new ArrayList<V>();

		while(graph.hasVertex(vertex) && pred.get(vertex) != vertex && pred.get(vertex) != null){
			list.add(0, vertex);
			vertex = pred.get(vertex);
		}

		if(pred.get(vertex) != null && pred.get(vertex) == vertex){
			list.add(0, pred.get(vertex));
		}
		return list;
	}
	/**
	 * Gets the shortest distance in terms of cost from the inputed vertex to the source
	 * @param vertex
	 * vertex to find the shortest distance to the source
	 * @return
	 * Cost of the shortest distance from the vertex to the source
	 */
	public Integer getShortestDistance(V vertex){
		if(vertex == null){
			throw new IllegalArgumentException();
		}
		if(!runCheck){
			throw new RuntimeException();
		}
		if(!graph.hasVertex(vertex)){
			return Integer.MAX_VALUE;
		}
		return dist.get(vertex);
	}
	
}
