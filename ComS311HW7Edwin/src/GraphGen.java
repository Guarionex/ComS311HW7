import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class GraphGen {
	
	File file;
	String fileName = "";
	//BufferedReader buffer;
	int numVertices;
	int numEdges;
	Graph<Vertex, Edge> graph;
	
	public GraphGen(String fileName)
	{
		this.fileName = fileName;
		//file = new File(fileName);
		//buffer = new BufferedReader(file);
		numVertices = 0;
		numEdges = 0;
		graph = new DirectedGraph<Vertex, Edge>();
		
	}
	
	public Graph<Vertex, Edge> makeGraph() throws IOException
	{
		//Graph<Vertex, Edge> graph = new DirectedGraph<Vertex, Edge>();
		//String line = "";
		List<String> allLines = Files.readAllLines(Paths.get(fileName));
		
		numVertices = Integer.parseInt(allLines.get(0).substring(allLines.get(0).indexOf(":") + 2));
		for(int i = 1; i < numVertices + 1; i++)
		{
			String[] rawVertex = allLines.get(i).split("[,]");
			graph.addVertex(new Vertex(Integer.parseInt(rawVertex[0]), Double.parseDouble(rawVertex[1]), Double.parseDouble(rawVertex[2])));
		}
			
		numEdges = Integer.parseInt(allLines.get(numVertices + 1).substring(allLines.get(numVertices + 1).indexOf(":") + 2));
		for(int i = numVertices + 2; i < numVertices + 2 + numEdges; i++)
		{
			Edge edge = null;
			//Edge reverseEdge = null;
			String[] rawEdge = allLines.get(i).split("[,]");
			if(rawEdge.length == 3)
			{
				edge = new Edge(i - numVertices - 2, graph.getData(Integer.parseInt(rawEdge[0])), graph.getData(Integer.parseInt(rawEdge[1])), Double.parseDouble(rawEdge[2]));
				//reverseEdge = new Edge(-(i - numVertices - 2), edge.getNext(), edge.getPrevious(), edge.getWeight());
			}
			else if(rawEdge.length == 4)
			{
				edge = new Edge(i - numVertices - 2, graph.getData(Integer.parseInt(rawEdge[0])), graph.getData(Integer.parseInt(rawEdge[1])), Double.parseDouble(rawEdge[2]), rawEdge[3]);
				//reverseEdge = new Edge(-(i - numVertices - 2), edge.getNext(), edge.getPrevious(), edge.getWeight(), rawEdge[3]);
			}
			if(edge != null /*&& reverseEdge != null*/)
			{
				graph.addEdge(edge.getPrevious().getID(), edge.getNext().getID(), edge);
				//graph.addEdge(reverseEdge.getPrevious().getID(), reverseEdge.getNext().getID(), reverseEdge);
			}
		}
		
		return graph;
	}
	
	public Graph<Vertex, Edge> makeLocationGraph()
	{
		Graph<Vertex, Edge> locations = new DirectedGraph<Vertex, Edge>();
		Vertex A = new Vertex(1055, 42.059112, -93.632995);
		Vertex B = new Vertex(371, 42.019621, -93.651759);
		Vertex C = new Vertex(2874, 42.012025, -93.671429);
		Vertex D = new Vertex(2351, 42.012053, -93.6489);
		Vertex E = new Vertex(2956, 42.009345, -93.67229);
		Vertex F = new Vertex(1171, 42.053516, -93.649586);
		Vertex G = new Vertex(1208, 42.031262, -93.620315);
		Vertex you = new Vertex(2893, 42.011189, -93.682421);
		Edge Ab = new Edge(0, A, B, 1);
		Edge Ae = new Edge(1, A, E, 1);
		Edge Ag = new Edge(2, A, G, 1);
		Edge Bc = new Edge(3, B, C, 1);
		Edge Bd = new Edge(4, B, D, 1);
		Edge Bg = new Edge(5, B, G, 1);
		Edge Cg = new Edge(6, C, G, 1);
		Edge De = new Edge(7, D, E, 1);
		Edge Df = new Edge(8, D, F, 1);
		Edge Dg = new Edge(9, D, G, 1);
		Edge Eg = new Edge(10, E, G, 1);
		Edge Fg = new Edge(11, F, G, 1);
		Edge youA = new Edge(12, you, A, 1);
		locations.addVertex(you);//0
		locations.addVertex(A);//1
		locations.addVertex(B);//2
		locations.addVertex(C);//3
		locations.addVertex(D);//4
		locations.addVertex(E);//5
		locations.addVertex(F);//6
		locations.addVertex(G);//7
		//locations.addVertex(you);//7
		locations.addEdge(1, 2, Ab);
		locations.addEdge(1, 5, Ae);
		locations.addEdge(1, 7, Ag);
		locations.addEdge(2, 3, Bc);
		locations.addEdge(2, 4, Bd);
		locations.addEdge(2, 7, Bg);
		locations.addEdge(3, 7, Cg);
		locations.addEdge(4, 5, De);
		locations.addEdge(4, 6, Df);
		locations.addEdge(4, 7, Dg);
		locations.addEdge(5, 7, Eg);
		locations.addEdge(6, 7, Fg);
		locations.addEdge(0, 1, youA);
		
		return locations;
	}

}
