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
			Edge reverseEdge = null;
			String[] rawEdge = allLines.get(i).split("[,]");
			if(rawEdge.length == 3)
			{
				edge = new Edge(i - numVertices - 2, graph.getData(Integer.parseInt(rawEdge[0])), graph.getData(Integer.parseInt(rawEdge[1])), Double.parseDouble(rawEdge[2]));
				reverseEdge = new Edge(-(i - numVertices - 2), edge.getNext(), edge.getPrevious(), edge.getWeight());
			}
			else if(rawEdge.length == 4)
			{
				edge = new Edge(i - numVertices - 2, graph.getData(Integer.parseInt(rawEdge[0])), graph.getData(Integer.parseInt(rawEdge[1])), Double.parseDouble(rawEdge[2]), rawEdge[3]);
				reverseEdge = new Edge(-(i - numVertices - 2), edge.getNext(), edge.getPrevious(), edge.getWeight(), rawEdge[3]);
			}
			if(edge != null && reverseEdge != null)
			{
				graph.addEdge(edge.getPrevious().getID(), edge.getNext().getID(), edge);
				graph.addEdge(reverseEdge.getPrevious().getID(), reverseEdge.getNext().getID(), reverseEdge);
			}
		}
		
		return graph;
	}

}
