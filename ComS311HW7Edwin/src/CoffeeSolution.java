import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Implementation of CoffeeSolver
 * @author Edwin O. Martinez Velazquez
 *
 * @param <V> Vertex
 * @param <E> Edge
 */
public class CoffeeSolution<V, E> implements CoffeeSolver<V, E> {
	/**
	 * State enumeration for Depth First Search Vertices
	 * @author Edwin O. Martinez Velazquez
	 *
	 */
	public enum State 
	{
		DISCOVERED, UNDISCOVERED, PROCESSED
	}
	List<Integer> path;
	HashMap<Integer, State> vertexState;
	boolean isCycle;
	
	/**
	 * Constructor that initializes member variables
	 */
	public CoffeeSolution()
	{
		path = new ArrayList<Integer>();
		vertexState = new HashMap<Integer, State>();
		isCycle = false;
	}

	@Override
	public List<Integer> sortVertices(Graph<V, E> graph) {
		return this.topologicalSort(graph, 0); //Returns a topological sort from the first vertex in the graph
	}

	@Override
	public List<Integer> shortestPath(Graph<V, E> graph, List<Integer> locations, Weighing<E> weigh) {
		//Variables
		List<Integer> completePath = new ArrayList<Integer>();
		Dijkstra<V, E> digimon = new EdsgerWDijkstra<V, E>();
		digimon.setGraph(graph);
		digimon.setWeighing(weigh);
		
		//completePath.add(locations.get(0));
		for(int i = 0; i < locations.size() - 1; i++) //loop through all vertices in the list
		{
			digimon.setStart(locations.get(i)); //Finds shortest path between each vertex
			digimon.computeShortestPath();
			//System.out.println(digimon.getPath(locations.get(i + 1)));
			completePath.addAll(digimon.getPath(locations.get(i + 1)));
			completePath.remove(locations.get(i+1));
		}
		completePath.add(locations.get(locations.size() - 1));
		return completePath;
	}

	@Override
	public Collection<List<Integer>> generateValidSortS(Graph<V, E> graph) {
		Collection<List<Integer>> paths = new HashSet<List<Integer>>();
		//List<Integer> validPath = new ArrayList<Integer>();
		//int dummyID = this.addDummy(graph, true);
		//Do tolpological sort starting at each vertex to get all valid ordering
		for(Integer v: graph.getVertices())
		{
			List<Integer> validPath = this.topologicalSort(graph, v);
			if(validPath == null) return new HashSet<List<Integer>>();
			else paths.add(validPath);
		}
		//Special case for graphs that have more than 1 entry point or exit point
		List<Integer> entries = this.checkMultiPoint(graph, true);
		List<Integer> exits = this.checkMultiPoint(graph, false);
		Iterator<List<Integer>> iter = paths.iterator();
		Collection<List<Integer>> temp = new HashSet<List<Integer>>();
		while(iter.hasNext())
		{
			List<Integer> next = iter.next();
			for(int i = next.size() - 1; i >0 ; i--)
			{
				if(entries.contains(next.get(i)))
				{
					List<Integer> tempPath = new ArrayList<Integer>(next);
					tempPath.set(i - 1, tempPath.set(i, tempPath.get(i - 1)));
					temp.add(tempPath);
				}
			}
			for(int j = 0; j < next.size() - 2; j++)
			{
				if(exits.contains(next.get(j)))
				{
					List<Integer> tempPath = new ArrayList<Integer>(next);
					tempPath.set(j + 1, tempPath.set(j, tempPath.get(j + 1)));
					temp.add(tempPath);
				}
			}
		}
		paths.addAll(temp);
		
		return paths;
	}
	/**
	 * Does topological sort by doing depth first search, then finds vertices not connected
	 * to the starting vertex and does DFS on those
	 * @param graph
	 * @param vertex
	 * @return Topologically sorted vertices
	 */
	private List<Integer> topologicalSort(Graph<V, E> graph, int vertex)
	{

		
		this.initStates(graph);
		this.depthFirstSearch(graph, vertex);
		
		for(int v: vertexState.keySet())
		{
			if(vertexState.get(v) == State.UNDISCOVERED)
			{
				this.depthFirstSearch(graph, v);
			}
		}
		if(isCycle) return null;
		return path;
		
		
	}
	/**
	 * Sets up state of each vertex
	 * @param graph
	 */
	private void initStates(Graph<V,E> graph)
	{
		path = new ArrayList<Integer>();
		isCycle = false;
		for(Integer v: graph.getVertices())
		{
			vertexState.put(v, State.UNDISCOVERED);
		}
	}
	/**
	 * Depth First Search algorithm
	 * @param graph
	 * @param vertex
	 */
	private void depthFirstSearch(Graph<V, E> graph, int vertex)
	{
		vertexState.put(vertex, State.DISCOVERED);
		for(int e: graph.getEdgesOf(vertex))
		{
			State targetState = this.processEdge(graph, e);
			if(targetState == State.DISCOVERED)
			{
				isCycle = true;
			}
			else if(targetState == State.UNDISCOVERED)
			{
				this.depthFirstSearch(graph, graph.getTarget(e));
			}
		}
		this.processVertexLate(vertex);
		vertexState.put(vertex, State.PROCESSED);
		
	}
	/**
	 * Process edge for topological sort
	 * @param graph
	 * @param e
	 * @return
	 */
	private State processEdge(Graph<V, E> graph, int e)
	{
		return vertexState.get(graph.getTarget(e));
	}
	/**
	 * Process a vertex late, also part of topological sort algorithm 
	 * @param vertex
	 */
	private void processVertexLate(int vertex)
	{
		path.add(0, vertex);
	}
	/**
	 * Checks if the graph has more than 1 entry and exit point
	 * @param graph
	 * @param entry true for entry, false for exit point
	 * @return
	 */
	private List<Integer> checkMultiPoint(Graph<V, E> graph, boolean entry)
	{
		Set<Integer> vertices = graph.getVertices();
		Set<Integer> edges = graph.getEdges();
		HashMap<Integer, Boolean> targetVertices = new HashMap<Integer, Boolean>();
		List<Integer> entryPoints = new ArrayList<Integer>();
		
		for(Integer v: vertices)
		{
			targetVertices.put(v, false);
		}
		for(Integer e: edges)
		{
			if(entry) targetVertices.put(graph.getTarget(e), true);
			else if(!entry) targetVertices.put(graph.getSource(e), true);
		}
		for(Integer v: targetVertices.keySet())
		{
			if(!targetVertices.get(v))
			{
				entryPoints.add(v);
			}
		}
		return entryPoints;
	}
	
//	private int addDummy(Graph<V, E> graph, boolean point)
//	{
//		int dummyID = -1;
//		if(true)
//		{
//			
//			
//			List<Integer> entryPoints = this.checkMultiPoint(graph, true);
//			V dummyVertex = null;
//			E dummyEdge = null;
//			if(entryPoints.size() > 1)
//			{
//				
//				dummyID = graph.addVertex(dummyVertex);
//				for(Integer v: entryPoints)
//				{
//					graph.addEdge(dummyID, v, dummyEdge);
//				}
//				this.initStates(graph);
//				this.depthFirstSearch(graph, dummyID);
//			}
//		}
//		return dummyID;
//	}
//	
	

}
