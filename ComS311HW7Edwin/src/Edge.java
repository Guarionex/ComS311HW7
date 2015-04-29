
public class Edge {
	
	private int ID;
	private Vertex previous;
	private Vertex next;
	private double weight;
	private String name;
	
	public Edge(int ID, Vertex previous, Vertex next, double weight)
	{
		this.ID = ID;
		this.previous = previous;
		this.next = next;
		this.weight = weight;
		this.name = "";
	}
	
	public Edge(int ID, Vertex previous, Vertex next, double weight, String name)
	{
		this.ID = ID;
		this.previous = previous;
		this.next = next;
		this.weight = weight;
		this.name = name;
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
	
	public String getName()
	{
		return name;
	}
}
