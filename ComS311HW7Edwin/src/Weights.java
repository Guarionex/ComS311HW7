
public class Weights implements Weighing<Edge> {
	double weight;
	
	public Weights()
	{
		weight = 0;
	}
	
	@Override
	public double weight(Edge edge) {
		
		weight = edge.getWeight();
		
		return weight;
	}

}
