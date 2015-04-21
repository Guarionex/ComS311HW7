import java.util.HashMap;
import java.util.Set;


public class DirectedGraph<V, E> implements Graph<V, E> {
	
	private int numVertices = 0;
	private int numEdges = 0;
	
	private HashMap<Integer, GraphVertex> vertices = new HashMap<Integer, GraphVertex>();
	private HashMap<Integer, GraphEdge> edges = new HashMap<Integer, GraphEdge>();
	
	class GraphEdge
	{
		private E edgeData;
		private int sourceID;
		private int targetID;
		private int ID;
		
		public GraphEdge(E edgeData, int sourceID, int targetID, int ID)
		{
			this.edgeData = edgeData;
			this.sourceID = sourceID;
			this.targetID = targetID;
			this.ID = ID;
		}
		
		public E getEdge()
		{
			return edgeData;
		}
		
		public int getSourceID()
		{
			return sourceID;
		}
		
		public int getTargetID()
		{
			return targetID;
		}
		
		@Override
		public int hashCode()
		{
			return ID;
		}
	}
	
	class GraphVertex
	{
		private V vertexData;
		private int ID;
		private HashMap<Integer, GraphEdge> edges = new HashMap<Integer, GraphEdge>();
		
		public GraphVertex(V vertexData)
		{
			this.vertexData = vertexData;
		}
		
		public V getData()
		{
			return vertexData;
		}
		
		public void addEdge(GraphEdge edge)
		{
			edges.put(edge.hashCode(), edge);
		}
		
		@Override
		public int hashCode()
		{
			return ID;
		}
		
	}

	@Override
	public int addVertex(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addEdge(int srcID, int targetID, E attr)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Integer> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getAttribute(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getData(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSource(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTarget(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Integer> getEdgesOf(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
