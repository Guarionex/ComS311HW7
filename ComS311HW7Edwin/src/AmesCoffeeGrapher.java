import java.io.IOException;


public class AmesCoffeeGrapher {

	
	
	public static void main(String[] args)
	{
		GraphGen cartographer = new GraphGen("AmesData.txt");
		Graph<Vertex, Edge> ames = null;
		try {
			ames = cartographer.makeGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Vertex count is "+ames.getVertices().size());
		System.out.println("Edge count is "+ames.getEdges().size());
	}
	
	
	
}
