import java.io.IOException;
import java.util.List;


public class AmesCoffeeGrapher {

	
	
	public static void main(String[] args)
	{
		GraphGen cartographer = new GraphGen("AmesData.txt");
		Graph<Vertex, Edge> ames = null;
		Graph<Vertex, Edge> locations = null;
		CoffeeSolver<Vertex, Edge> coffeeSolver = new CoffeeSolution<Vertex, Edge>();
		
		try {
			ames = cartographer.makeGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Vertex count is "+ames.getVertices().size());
//		System.out.println("Edge count is "+ames.getEdges().size());
		
		locations = cartographer.makeLocationGraph();
		
//		Part 1: Generate a sorting of the ingredients that satisfies the constraints
//		above. Note that you expect Jim to have this problem again, therefore
//		your algorithm must work for an arbitrary dependency graph of
//		arbitrary size.
		List<Integer> topo = coffeeSolver.sortVertices(locations);
		System.out.println("Sorting of the ingredients that statisfies the constraint:");
		//System.out.println(topo);
		System.out.println(ingredientToString(topo));
		
//		Part 2: Given an ordering of ingredients, find the shortest path to collect all
//		the ingredients and get back to Jim. Once again you expect for Jim
//		to have this problem in the future and it should work for an arbitrary
//		ordering of n ingredients.


		
	}
	
	private static String ingredientToString(List<Integer> order)
	{
		String sortOrder = "";
		
		for(Integer v: order)
		{
			switch(v)
			{
			case 0:
				sortOrder +="You -> ";
				break;
			case 1:
				sortOrder += "Ingredient A -> ";
				break;
			case 2:
				sortOrder += "Ingredient B -> ";
				break;
			case 3:
				sortOrder += "Ingredient C -> ";
				break;
			case 4:
				sortOrder += "Ingredient D -> ";
				break;
			case 5:
				sortOrder += "Ingredient E -> ";
				break;
			case 6:
				sortOrder += "Ingredient F -> ";
				break;
			case 7:
				sortOrder += "Ingredient G";
				break;
			}
		}
		
		return sortOrder;
	}
	
	
}
