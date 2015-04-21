
public class Weights<E> implements Weighing<E> {

	@Override
	public double weight(E edge) {
		double weight = 0;
		if(edge.getClass().equals(Edge.class))
		{
			weight = ((Edge) edge).getWeight();
		}
		return weight;
	}

}
