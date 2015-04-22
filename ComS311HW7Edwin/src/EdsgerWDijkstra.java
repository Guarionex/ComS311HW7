import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class EdsgerWDijkstra<V, E> implements Dijkstra<V, E> {

	private Graph<V, E> graph = null;
	private int startVertex = -1;
	private Weighing<E> weighing = null;
	private HashMap<Integer, Double> distance;
	private HashMap<Integer, Integer> predecessor;
	private HashSet<Integer> vertexSet;
	
	public EdsgerWDijkstra()
	{
		distance = new HashMap<Integer, Double>();
		predecessor = new HashMap<Integer, Integer>();
		vertexSet = new HashSet<Integer>();
	}
	
	@Override
	public void setGraph(Graph<V, E> graph) {
		this.graph = graph;
	}

	@Override
	public void setStart(int startId) throws IllegalArgumentException, IllegalStateException {
		if(graph == null) throw new IllegalStateException();
		if(!graph.getVertices().contains(startId)) throw new IllegalArgumentException();
		else startVertex = startId;

	}

	@Override
	public void setWeighing(Weighing<E> weighing) {
		this.weighing = weighing;
		
	}

	@Override
	public void computeShortestPath() throws IllegalStateException {
		if(graph == null || startVertex == -1 || weighing == null) throw new IllegalStateException();
		
		distance = new HashMap<Integer, Double>();
		predecessor = new HashMap<Integer, Integer>();
		vertexSet = new HashSet<Integer>();
		
		for(Integer v : graph.getVertices())
		{
			distance.put(v, Double.POSITIVE_INFINITY);
			predecessor.put(v,  null);
		}
		
	}

	@Override
	public List<Integer> getPath(int endId) throws IllegalArgumentException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCost(int endId) throws IllegalArgumentException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

}
