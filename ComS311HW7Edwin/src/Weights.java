
public class Weights implements Weighing<Edge> {
	double weight;
	
	public Weights()
	{
		weight = 0;
	}
	
	@Override
	public double weight(Edge edge) {
		if(edge.getClass().equals(Edge.class))
		{
			weight = ((Edge) edge).getWeight();
		}
		return weight;
	}

}
