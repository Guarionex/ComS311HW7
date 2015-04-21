
public class Edge {
	
	private int ID;
	private Vertex previous;
	private Vertex next;
	private double weight;
	
	public Edge(int ID, Vertex previous, Vertex next, double weight)
	{
		this.ID = ID;
		this.previous = previous;
		this.next = next;
		this.weight = weight;
	}

	public int getID()
	{
		return ID;
	}
	
	public Vertex getPrevious()
	{
		return previous;
	}
	
	public Vertex getNext()
	{
		return next;
	}
	
	public double getWeight()
	{
		return weight;
	}
}
