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
	boolean isCycle = false;
	
	public CoffeeSolution()
	{
		path = new ArrayList<Integer>();
		vertexState = new HashMap<Integer, State>();
	}

	@Override
	public List<Integer> sortVertices(Graph<V, E> graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> shortestPath(Graph<V, E> graph,
			List<Integer> locations, Weighing<E> weigh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<List<Integer>> generateValidSortS(Graph<V, E> graph) {
		Collection<List<Integer>> paths = new HashSet<List<Integer>>();
		return paths;
	}
	
	private void initStates(Graph<V,E> graph)
	{
		for(Integer v: graph.getVertices())
		{
			vertexState.put(v, State.UNDISCOVERED);
		}
	}
	
	private void depthFirstSearch(Graph<V, E> graph, int vertex)
	{
		vertexState.put(vertex, State.DISCOVERED);
		for(int e: graph.getEdges())
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
		path.add(vertex);
	}
	
	

}
