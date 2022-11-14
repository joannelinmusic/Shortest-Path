import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author <Joanne Lin>
 */
public class SymbolGraph<E> 
{
	private Map<E, Map<E, Integer>> edges;
	private int numberOfEdges;
	
	
	public SymbolGraph()
	{
		edges = new TreeMap<E, Map<E, Integer>>();
	}

	
	public int getNumberOfVerticies()
	{
		return edges.size();
	}

	
	public int getNumberOfEdges()
	{
		return numberOfEdges;
	}

	public boolean addVertex(E value)
	{
		if (edges.containsKey(value)) {
			return false;
		}
		
		edges.put(value, new TreeMap<E, Integer>());
		return true;
	}
	
	public boolean addEdge(E from, E to, int weight)
	{
		if (edges.containsKey(from) && edges.containsKey(to)) {
			if (edges.get(from).containsKey(to)) {
				System.out.println("The edge between "+ from +" and "+to+" already existed.");
				return false;
			} 
			edges.get(from).put(to, weight);
			edges.get(to).put(from, weight);
			
			numberOfEdges++;
			return true;
		}
		
		if (!edges.containsKey(from)) {
			System.out.println("There is no vertex"+from);
		}
		if (!edges.containsKey(to)) {
			System.out.println("There is no vertex "+to);
		}
		return false;
		
		
	}

	public Set<E> getAdjacent(E to)
	{
		if (edges.get(to)==null || dges.get(to).isEmpty()) {return null;}
		return edges.get(to).keySet();
	}

	public boolean removeEdge(E from, E to)
	{
		if (edges.get(from)==null) {return false;}
		if (!edges.get(from).containsKey(to)) {return false;}
		numberOfEdges--;
		
		edges.get(from).remove(key);
		edges.get(to).remove(from);
		return true;
	}	
}