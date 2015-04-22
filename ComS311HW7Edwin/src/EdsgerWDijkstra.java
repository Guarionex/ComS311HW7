import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


public class EdsgerWDijkstra<V, E> implements Dijkstra<V, E> {

	private Graph<V, E> graph = null;
	private int startVertex = -1;
	private Weighing<E> weighing = null;
	private HashMap<Integer, Double> distance;
	private HashMap<Integer, Integer> predecessor;
	private HashSet<Integer> vertexSet;
	private PriorityQueue<Integer> vertexQueue;
	private boolean pathComputed = false;
	
	public EdsgerWDijkstra()
	{
		distance = new HashMap<Integer, Double>();
		predecessor = new HashMap<Integer, Integer>();
		vertexSet = new HashSet<Integer>();
		vertexQueue = new PriorityQueue<Integer>();
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
		vertexQueue = new PriorityQueue<Integer>();
		
		for(Integer v : graph.getVertices())
		{
			distance.put(v, Double.POSITIVE_INFINITY);
			predecessor.put(v,  null);
		}
		distance.put(startVertex, (double) 0);
		predecessor.put(startVertex, startVertex);
		vertexQueue.add(startVertex);
		
		while(!vertexQueue.isEmpty())
		{
			Integer u = vertexQueue.poll();
			
			if(!vertexSet.contains(u))
			{
				vertexSet.add(u);
				
				for(Integer e: graph.getEdgesOf(u))
				{
					Integer v = graph.getTarget(e);
					double weight = weighing.weight(graph.getAttribute(e));
					if(distance.get(v) > distance.get(u) + weight)
					{
						distance.put(v,  distance.get(u) + weight);
						predecessor.put(v, u);
						vertexQueue.add(v);
					}
				}
			}
			
		}
		pathComputed = true;
	}

	@Override
	public List<Integer> getPath(int endId) throws IllegalArgumentException, IllegalStateException {
		if(!pathComputed) throw new IllegalStateException();
		if(!graph.getVertices().contains(endId)) throw new IllegalArgumentException();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		Integer previous = predecessor.get(endId);
		
		path.add(0, endId);
		while(previous != null && previous != null)
		{
			path.add(0, previous);
			previous = predecessor.get(previous);
		}
		
		return null;
	}

	@Override
	public double getCost(int endId) throws IllegalArgumentException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

}
