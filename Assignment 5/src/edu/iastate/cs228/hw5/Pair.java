package edu.iastate.cs228.hw5;

/**
 * Pair class which holds the vertex of a graph and it's respective cost
 * the pair class is also comparable
 * @author Edwin O. Martinez
 *
 * @param <E>
 * Generic Vertex
 * @param <F>
 * Generic cost which is comparable
 */
public class Pair<E, F extends Comparable<? super F>> implements Comparable<Pair<E, F>>{
	/**
	 * Generic vertex variable
	 */
	public E vertex;
	/**
	 * generic cost variable which is comparable
	 */
	public F cost;
	/**
	 * constructor for the pair class which takes in a vertex and a cost, if either is null an exception is
	 * thrown
	 * @param nVertex
	 * input vertex
	 * @param nCost
	 * input cost
	 */
	public Pair(E nVertex, F nCost){
		if(nVertex == null || nCost == null){
			throw new NullPointerException();
		}
		vertex = nVertex;
		cost = nCost;
	}
	/**
	 * Returns the vertex of this pair
	 * @return
	 * the vertex
	 */
	public E getVertex(){
		return vertex;
	}
	/**
	 * Returns the cost of the vertex of this pair
	 * @return
	 * the cost of the vertex
	 */
	public F getCost(){
		return cost;
	}
	/**
	 * definition of compareTo for the Pair class, which compares only the cost between two pairs
	 * @return
	 * -1 if this is less than toCompare
	 * 0 if this is equals to toCompare
	 * 1 if this is greater than toCompare
	 */
	public int compareTo(Pair<E, F> toCompare){
		return getCost().compareTo(toCompare.getCost());
	}
	/**
	 * Gives the hashCode for the vertex
	 * @return
	 * the hashCode for the vertex in the pair
	 */
	public int hashCode(){
		return vertex.hashCode();
	}
	/**
	 * Checks if the vertex in two pairs are the same
	 * @return
	 * true if both vertex are the same, even when both are null
	 * false otherwise or if the obj is not an instance of Pair
	 */
	public boolean equals(Object obj){
		if((obj instanceof Pair) == false){
			return false;
		}
		if(vertex == null && ((Pair<?, ?>) obj).vertex == null){
			return true;
		}
		if(vertex == null){
			return false;
		}
		return vertex.equals(((Pair<?, ?>) obj).vertex);
	}

}
