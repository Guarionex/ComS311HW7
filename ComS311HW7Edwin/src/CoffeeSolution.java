import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CoffeeSolution<V, E> implements CoffeeSolver<V, E> {

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
	
	private void depthFirstSearch(Graph<V, E> graph, int vertex)
	{
		
	}
	
	private class DFSVertex
	{
		private V vertex;
		private int state;
		private final int UNDISCOVERED = 0;
		private final int DISCOVERED = 1;
		private final int PROCESSED = 2;
		
		public DFSVertex(V vertex)
		{
			this.vertex = vertex;
			state = -1;
		}
		
		
		
	}

}
