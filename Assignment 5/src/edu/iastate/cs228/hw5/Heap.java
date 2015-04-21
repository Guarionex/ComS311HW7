package edu.iastate.cs228.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Heap class is a form of a binary tree that helps us in the Dijkstra algorithm.
 * This class is taken mostly from the lecture notes
 * @author Edwin O. Martinez
 *
 * @param <E>
 * Generic E which is comparable
 */
public class Heap<E extends Comparable<? super E>>{
	/**
	 * initial size for the array list
	 */
	private static final int INIT_CAP = 10;
	/**
	 * a list which contains the elements
	 */
	private ArrayList<E> list;
	/**
	 * The default constructor for heap
	 */
	public Heap(){
		list = new ArrayList<E>(INIT_CAP);
	}
	/**
	 * Constructor that takes in a specific size
	 * @param aSize
	 */
	public Heap(int aSize){
		if ( aSize < 1 )
			throw new IllegalStateException();
		list = new ArrayList<E>(aSize);
	}
	/**
	 * returns the size of the list
	 * @return
	 * size of list
	 */
	public int size(){
		return list.size();
	}
	/**
	 * Returns whether it's empty or not
	 * @return
	 * true if the heap is empty
	 * false otherwise
	 */
	public boolean isEmpty(){
		return list.isEmpty();
	}
	/**
	 * Adds a new element to the heap
	 * @param element
	 * element to be added
	 */
	public void add(E element){
		if ( element == null )
			throw new NullPointerException("add");
		list.add(element); // append it to the end of the list
		percolateUp(); // move it up to the proper place
	}

	
	/**
	 * move the last element up to the proper place.
	 */
	private void percolateUp(){
		int child = list.size() - 1; // last element in the list
		int parent;
		while ( child > 0 )
		{
			parent = (child - 1) / 2; // use the (j-1)/2 formula
			if ( list.get(child).compareTo(list.get(parent)) >= 0 )
				break;
			swap(parent, child);
			child = parent;
		}
	}
	/**
	 * swaps the parent and child
	 * @param parent
	 * parent to be swap
	 * @param child
	 * child to be swap
	 */
	private void swap(int parent, int child){
		E tmp = list.get(parent);
		list.set( parent, list.get(child) );
		list.set(child, tmp);
	}
	/**
	 * Gets the first element of the heap which is also the minimum one
	 * @return
	 * minimum element
	 */
	public E getMin(){
		if ( list.isEmpty() )
			throw new NoSuchElementException();
		return list.get(0);
	}
	/**
	 * sorts the heap
	 * @param <E>
	 * Generic list
	 * @param aList
	 * Generic list of heap
	 */
	public static <E extends Comparable<? super E>> void heapSort(List<E> aList){
	  if ( aList.isEmpty() ) return;
	  Heap<E> aHeap = new Heap<E>(aList.size());
	  for ( E element : aList )
	    aHeap.add(element);
	  aList.clear();
	  while ( ! aHeap.isEmpty() )
	    aList.add( aHeap.removeMin() );
	}
	/**
	 * Removes the minimum element
	 * @return
	 * returns the minimum element which was removed
	 */
	public E removeMin(){
		if ( list.isEmpty() )
			throw new NoSuchElementException();
		E minElem = list.get(0); // get the min element at the root
		list.set(0, list.get(list.size() - 1) ); // copy the last element to the root
		list.remove( list.size() - 1 ); // remove the last element from the list
		if ( ! list.isEmpty() )
			percolateDown(0); // move the element at the root down to the proper place
		return minElem;
	}

	
	/**
	 * Move the element at index start down to the proper place.
	 * @param start
	 * index to take the element to move it
	 */
	private void percolateDown(int start){
		if ( start < 0 || start >= list.size() )
			throw new RuntimeException("start < 0 or >= n");
		int parent = start;
		int child = 2 * parent + 1; // use the 2*i+1 formula
		while ( child < list.size() )
		{
			if ( child + 1 < list.size() &&
					list.get(child).compareTo(list.get(child + 1)) > 0 )
				child++; // select the smaller child
			if ( list.get(child).compareTo(list.get(parent)) >= 0 )
				break; // reach the proper place
			swap(parent, child);
			parent = child;
			child = 2 * parent + 1;
		}
	}

}