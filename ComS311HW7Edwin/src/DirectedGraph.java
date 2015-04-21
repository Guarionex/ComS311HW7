import java.util.HashMap;
import java.util.Set;


public class DirectedGraph<V, E> implements Graph<V, E> {
	
	private int numVertices = 0;
	private int numEdges = 0;
	
	private HashMap<Integer, GraphVertex> vertices = new HashMap<Integer, GraphVertex>();
	private HashMap<Integer, GraphEdge> edges = new HashMap<Integer, GraphEdge>();
	
	class GraphEdge
	{
		private E edgeAttr;
		private int sourceID;
		private int targetID;
		private int ID;
		
		public GraphEdge(E edgeAttr, int sourceID, int targetID, int ID)
		{
			this.edgeAttr = edgeAttr;
			this.sourceID = sourceID;
			this.targetID = targetID;
			this.ID = ID;
		}
		
		public E getEdgeAttribute()
		{
			return edgeAttr;
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
		private HashMap<Integer, GraphEdge> vertexEdges = new HashMap<Integer, GraphEdge>();
		
		public GraphVertex(V vertexData, int ID)
		{
			this.vertexData = vertexData;
			this.ID = ID;
		}
		
		public V getVertexData()
		{
			return vertexData;
		}
		
		public void addEdge(GraphEdge edge)
		{
			vertexEdges.put(edge.hashCode(), edge);
		}
		
		public Set<Integer> getEdges()
		{
			return vertexEdges.keySet();
		}
		
		@Override
		public int hashCode()
		{
			return ID;
		}
		
	}

	@Override
	public int addVertex(V v) {
		GraphVertex newVertex = new GraphVertex(v, numVertices);
		vertices.put(newVertex.hashCode(), newVertex);
		numVertices++;
		return newVertex.hashCode();
	}

	@Override
	public int addEdge(int srcID, int targetID, E attr) throws IllegalArgumentException {
		if(srcID > 0 || targetID > 0) throw new IllegalArgumentException();
		GraphEdge newEdge = new GraphEdge(attr, srcID, targetID, numEdges);
		GraphVertex sourceVertex = vertices.get(srcID);
		sourceVertex.addEdge(newEdge);
		edges.put(newEdge.hashCode(), newEdge);
		numEdges++;
		return newEdge.hashCode();
	}

	@Override
	public Set<Integer> getVertices() {
		return vertices.keySet();
	}

	@Override
	public Set<Integer> getEdges() {
		return edges.keySet();
	}

	@Override
	public E getAttribute(int id) throws IllegalArgumentException {
		if(id > numEdges) throw new IllegalArgumentException();
		return edges.get(id).getEdgeAttribute();
	}

	@Override
	public V getData(int id) throws IllegalArgumentException {
		if(id > numVertices) throw new IllegalArgumentException();
		return vertices.get(id).getVertexData();
	}

	@Override
	public int getSource(int id) throws IllegalArgumentException {
		if(id > numEdges) throw new IllegalArgumentException();
		return edges.get(id).getSourceID();
	}

	@Override
	public int getTarget(int id) throws IllegalArgumentException {
		if(id > numEdges) throw new IllegalArgumentException();
		return edges.get(id).getTargetID();
	}

	@Override
	public Set<Integer> getEdgesOf(int id) throws IllegalArgumentException {
		return vertices.get(id).getEdges();
	}

}
