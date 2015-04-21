package edu.iastate.cs228.hw5;

import java.util.HashMap;
import java.util.HashSet;
/**
 * CS228DirectedGraph creates the graph with the desired vertex and edges stating from which vertex to another
 * to go
 * @author Edwin O. Martinez
 *
 * @param <V>
 * Generic Vertex
 */
public class CS228DirectedGraph<V> {
	/**
	 * HashMap called map which holds the vertex, and it's appropriate HashSet which contains a pair
	 */
	private HashMap<V, HashSet<Pair<V, Integer>>> map;
	/**
	 * number of edges
	 */
	private int edges;
	/**
	 * default constructor that initialize the variables
	 */
	public CS228DirectedGraph(){
		edges = 0;
		map = new HashMap<V, HashSet<Pair<V, Integer>>>();
	}
	/**
	 * Returns the number of vertices
	 * @return
	 * the total number of vertices 
	 */
	public int numV(){
		return map.keySet().size();
	}
	/**
	 * Gives you the number of edges
	 * @return
	 * the total number of edges
	 */
	public int numE(){
		return edges;
	}
	/**
	 * Gives the degrees of the vertex
	 * @param f
	 * vertex of which the degrees you want 
	 * @return
	 * the degrees of vertex f
	 */
	public int degree(V f){
		if(f == null){
			throw new IllegalArgumentException();
		}
      if(!map.containsKey(f)){
    	  return 0;
      }
      else return map.get(f).size();
    }
	/**
	 * Adds an edge from vertex f to vertex t with cost c
	 * @param f
	 * vertex from which to connect the edge
	 * @param t
	 * vertex from which edge goes to
	 * @param c
	 * cost of the edge
	 */
	public void addEdge(V f, V t, Integer c){
		 if(f == null || t == null || c == null || f.equals(t) || c < 0){
			 throw new IllegalArgumentException();
		 }
		 if(!hasEdge(f, t)){
			 edges++;
		 }
		 else{
			 return;
		 }
		 if(!hasVertex(f) || !hasVertex(t)){
			 addVertex(f);
			 addVertex(t);
		 }
		 map.get(f).add(new Pair<V, Integer>(t, c));
	}
	/**
	 * Adds a new vertex to the graph
	 * @param f
	 * vertex to be added
	 */
	public void addVertex(V f){
		if(f == null){
			throw new IllegalArgumentException();
		}
		if (!hasVertex(f)){
			map.put(f, new HashSet<Pair<V, Integer>>());
		}
		return;
    }
	/**
	 * returns an iterator of all vertices in the graph
	 * @return
	 * iterator of the graph
	 */
	public Iterable<V> vertices(){
		return map.keySet();
	}
	/**
	 * returns an iterator of all pairs adjacent to vertix f
	 * @param f
	 * Vertex from which to get an iterator
	 * @return
	 * iterator of all vertices adjacent to vertex f
	 */
	public Iterable<Pair<V, Integer>> adjacentTo(V f){
		if(f == null){
			throw new IllegalArgumentException();
		}
		if(!hasVertex(f)){
			return new HashSet<Pair<V, Integer>>();
		}
		return map.get(f);
	}
	/**
	 * Checks if the graph has the vertex f
	 * @param f
	 * vertex to check if it's in the graph
	 * @return
	 * true if the vertex is found
	 * false otherwise
	 */
	 public boolean hasVertex(V f){
		 if(f == null){
			 throw new IllegalArgumentException();
		 }
	      return map.containsKey(f);
	   }
	 /**
	  * Check whether their is an edge between vertex f to t
	  * @param f
	  * vertex to check if the edge starts
	  * @param t
	  * vertex to check if the edge goes to
	  * @return
	  * true if the edge is found from vertex f to t
	  * false otherwise
	  */
	 public boolean hasEdge(V f, V t) {
		 if(f == null || t == null){
			 throw new IllegalArgumentException();
		 }
	      if(!hasVertex(f) || f.equals(t)){
	    	  return false;
	      }
	      return map.get(f).contains(new Pair<V, Integer>(t, 0));
	 }
	 /**
	  * Makes a string of the graph indicating all the vertices and their adjacent vertices
	  */
	 public String toString(){
		 String r = "";
		 for(V f: vertices()){
			 r += f.toString() + ": ";
			 for(Pair<V, Integer> t: adjacentTo(f)){
				 r += "("+ t.getVertex().toString() +", "+ t.getCost().toString() +"), ";
			 }
			 if(r.endsWith(", ")){
				 r = r.substring(0, r.lastIndexOf(","));
			 }
			 r += "\n";
		 }
		 return r;
	 }
	 
}
