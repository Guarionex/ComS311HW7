
public class Edge {
	
	int ID;
	Vertex previous;
	Vertex next;
	
	Edge(int ID, Vertex previous, Vertex next)
	{
		this.ID = ID;
		this.previous = previous;
		this.next = next;
	}

}
