package edu.iastate.cs228.hw5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Michael McInerney
 *
 */
public class HeapPairTest
{

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#Heap()}.
	 */
	@Test
	public void testHeap()
	{
		new Heap<Pair<String, Integer>>();
	}

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#size()}.
	 */
	@Test
	public void testSize()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		he.add(new Pair<String, Integer>("a", 5));
		he.add(new Pair<String, Integer>("b", 3));
		he.add(new Pair<String, Integer>("c", 10));
		assertEquals(3, he.size());
	}

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#isEmpty()}.
	 */
	@Test
	public void testIsEmptyY()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		assertEquals(true, he.isEmpty());
	}
	
	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#isEmpty()}.
	 */
	@Test
	public void testIsEmptyN()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		he.add(new Pair<String, Integer>("a", 5));
		he.add(new Pair<String, Integer>("b", 3));
		he.add(new Pair<String, Integer>("c", 10));
		assertEquals(false, he.isEmpty());
	}

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		he.add(new Pair<String, Integer>("a", 5));
		he.add(new Pair<String, Integer>("b", 3));
		he.add(new Pair<String, Integer>("c", 10));
	}

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#getMin()}.
	 */
	@Test
	public void testGetMin()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		he.add(new Pair<String, Integer>("a", 5));
		he.add(new Pair<String, Integer>("b", 3));
		he.add(new Pair<String, Integer>("c", 10));
		assertEquals( (Integer) 3, he.getMin().getCost());
	}

	/**
	 * Test method for {@link edu.iastate.cs228.hw5.Heap#removeMin()}.
	 */
	@Test
	public void testRemoveMin()
	{
		Heap<Pair<String, Integer>> he = new Heap<Pair<String, Integer>>();
		he.add(new Pair<String, Integer>("a", 5));
		he.add(new Pair<String, Integer>("b", 3));
		he.add(new Pair<String, Integer>("c", 10));
		he.removeMin();
		assertEquals( (Integer) 5, he.getMin().getCost());
	}
	
	@Test
	public void testPairHashCode()
	{
		Pair<String, Integer> pa = new Pair<String, Integer>("a", 1);
		pa.hashCode();
	}
	
	@Test
	public void testPairEqualsT()
	{
		Pair<String, Integer> pa = new Pair<String, Integer>("a", 1);
		assertEquals(true, pa.equals(pa));
	}
	
	@Test
	public void testPairEqualsF()
	{
		Pair<String, Integer> pa = new Pair<String, Integer>("a", 1);
		Pair<String, Integer> pb = new Pair<String, Integer>("b", 2);
		assertEquals(false, pa.equals(pb));
	}
	
	@Test
	public void testPairEqualsNullF()
	{
		Pair<String, Integer> pa = new Pair<String, Integer>("a", 1);
		assertEquals(false, pa.equals(null));
	}
	
	@Test(expected = NullPointerException.class)
	public void testPairCompareToNull()
	{
		Pair<String, Integer> pa = new Pair<String, Integer>("a", 1);
		assertEquals(0, pa.compareTo(null));
	}
}
