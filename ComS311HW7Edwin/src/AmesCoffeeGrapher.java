import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AmesCoffeeGrapher {

	
	
	public static void main(String[] args)
	{
		GraphGen cartographer = new GraphGen("AmesData.txt");
		Graph<Vertex, Edge> ames = null;
		Graph<Vertex, Edge> locations = null;
		CoffeeSolver<Vertex, Edge> coffeeSolver = new CoffeeSolution<Vertex, Edge>();
		Weighing<Edge> weight = new Weights();
		//Dijkstra<Vertex, Edge> digimon = new EdsgerWDijkstra<Vertex, Edge>();
		
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
		System.out.println("Part 1:");
		System.out.println("Sorting of the ingredients that statisfies the constraint:");
		//System.out.println(topo);
		System.out.println(ingredientToString(topo));
		
//		Part 2: Given an ordering of ingredients, find the shortest path to collect all
//		the ingredients and get back to Jim. Once again you expect for Jim
//		to have this problem in the future and it should work for an arbitrary
//		ordering of n ingredients.
		List<Integer> IDs = getVertexDataID(locations, topo);
		List<Integer> shortestPath = coffeeSolver.shortestPath(ames,IDs, weight);
		System.out.println("");
		System.out.println("Part 2:");
		System.out.println("Shortest Path:");
		System.out.println(shortestPath);
		
//		Bonus: Jim is worried about how long it will take and demands you find the
//		shortest possible path over all valid orderings of the ingredients and
//		return them to him.
		Collection<List<Integer>> validPaths = new HashSet<List<Integer>>();
		validPaths = coffeeSolver.generateValidSortS(locations);
		List<Integer> theShortestPath = new ArrayList<Integer>();
		double shortestPathCost = Double.POSITIVE_INFINITY;
		for(List<Integer> path: validPaths)
		{
			List<Integer> Ids = getVertexDataID(locations, path);
			List<Integer> aPath = coffeeSolver.shortestPath(ames, Ids, weight);
			double costOfAPath = 0.0;
			for(int i = 0; i < aPath.size() - 1; i++)
			{
				Set<Integer> edges = ames.getEdgesOf(aPath.get(i));
				for(Integer e: edges)
				{
					if(ames.getTarget(e) == aPath.get(i + 1))
					{
						costOfAPath += ames.getAttribute(e).getWeight();
					}
				}
			}
			if(shortestPathCost > costOfAPath)
			{
				shortestPathCost = costOfAPath;
				theShortestPath = aPath;
			}
		}
		System.out.println("");
		System.out.println("Bonus:");
		System.out.println("THE shortest path is:");
		System.out.println(theShortestPath);
		System.out.println("Cost: "+shortestPathCost);


		
	}
	
	
	
	private static List<Integer> getVertexDataID(Graph<Vertex, Edge> graph, List<Integer> graphVertexID)
	{
		List<Integer> IDs = new ArrayList<Integer>();
		for(Integer v: graphVertexID)
		{
			IDs.add(graph.getData(v).getID());
		}
		return IDs;
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
