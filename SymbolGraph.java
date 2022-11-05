package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <Your Name Here>
 */
public class SymbolGraph<E> implements Graph<E>
{
	private Map<E, List<E>> edges;
	private int numberOfEdges;
	
	public SymbolGraph()
	{
		edges = new TreeMap<E, List<E>>();
	}

	@Override
	public int getNumberOfVerticies()
	{
		return edges.size();
	}

	@Override
	public int getNumberOfEdges()
	{
		return numberOfEdges;
	}

	public boolean addVertex(E value)
	{
		if (edges.containsKey(value)) {
			return false;
		}
		
		edges.put(value, new ArrayList<>());
		return true;
	}
	
	@Override
	public boolean addEdge(E from, E to)
	{
		if (edges.get(from)!=null && edges.get(to)!=null) {
			if (edges.get(from).contains(to)) {
				System.out.println("what the");
				return false;
			}
			edges.get(from).add(to);
			edges.get(to).add(from);
			
			numberOfEdges++;
			
			System.out.println("fuck");
			System.out.println("number of edges after add"+getNumberOfEdges());
			return true;
		}
		
		
		return false;
		
		
	}

	@Override
	public Collection<E> getAdjacent(E to)
	{
		if (edges.get(to)==null) {return null;}
		return edges.get(to);
	}

	@Override
	public boolean removeEdge(E from, E to)
	{
		if (edges.get(from)==null) {return false;}
		if (!edges.get(from).contains(to)) {return false;}
		numberOfEdges--;
		
		edges.get(from).remove(to);
		edges.get(to).remove(from);
		return true;
	}	
}