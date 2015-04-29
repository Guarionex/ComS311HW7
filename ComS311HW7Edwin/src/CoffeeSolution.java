import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class CoffeeSolution<V, E> implements CoffeeSolver<V, E> {
	
	public enum State 
	{
		DISCOVERED, UNDISCOVERED, PROCESSED
	}
	List<Integer> path;
	HashMap<Integer, State> vertexState;
	boolean isCycle;
	
	public CoffeeSolution()
	{
		path = new ArrayList<Integer>();
		vertexState = new HashMap<Integer, State>();
		isCycle = false;
	}

	@Override
	public List<Integer> sortVertices(Graph<V, E> graph) {
		return this.topologicalSort(graph, 0);
	}

	@Override
	public List<Integer> shortestPath(Graph<V, E> graph, List<Integer> locations, Weighing<E> weigh) {
		List<Integer> completePath = new ArrayList<Integer>();
		Dijkstra<V, E> digimon = new EdsgerWDijkstra<V, E>();
		digimon.setGraph(graph);
		digimon.setWeighing(weigh);
		
		completePath.add(locations.get(0));
		for(int i = 0; i < locations.size() - 1; i++)
		{
			digimon.setStart(locations.get(i));
			digimon.computeShortestPath();
			completePath.addAll(digimon.getPath(locations.get(i + 1)));
		}
		
		return completePath;
	}

	@Override
	public Collection<List<Integer>> generateValidSortS(Graph<V, E> graph) {
		Collection<List<Integer>> paths = new HashSet<List<Integer>>();
		//List<Integer> validPath = new ArrayList<Integer>();
		for(Integer v: graph.getVertices())
		{
			List<Integer> validPath = this.topologicalSort(graph, v);
			if(validPath == null) return new HashSet<List<Integer>>();
			else paths.add(validPath);
		}
		
		return paths;
	}
	
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
	
	private void initStates(Graph<V,E> graph)
	{
		path = new ArrayList<Integer>();
		isCycle = false;
		for(Integer v: graph.getVertices())
		{
			vertexState.put(v, State.UNDISCOVERED);
		}
	}
	
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
	
	private State processEdge(Graph<V, E> graph, int e)
	{
		return vertexState.get(graph.getTarget(e));
	}
	
	private void processVertexLate(int vertex)
	{
		path.add(0, vertex);
	}
	
	

}
