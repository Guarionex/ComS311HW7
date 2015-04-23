
public class Weights<E> implements Weighing<E> {
	double weight;
	
	public Weights()
	{
		weight = 0;
	}
	
	@Override
	public double weight(E edge) {
		if(edge.getClass().equals(Edge.class))
		{
			weight = ((Edge) edge).getWeight();
		}
		return weight;
	}

}
