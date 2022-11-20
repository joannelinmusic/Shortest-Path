import java.util.ArrayList;
import java.util.Collection;

public class SymbolGraphTest {
	@Test
	 public void testInit()
	    {
	    	SymbolGraph<String> uut = new SymbolGraph<String>();
	    	setupGraph(uut);
	    	assertEquals("The size of the created Graph does not match", 26,  uut.getNumberOfVerticies());
	    	assertEquals("The new Graph has edges before adding", 0,  uut.getNumberOfEdges());
	    }
	    @Test		
	    public void testAdd()
	    {
	    	testInit();
	    	SymbolGraph<String> uut = new SymbolGraph<String>();
	    	setupGraph(uut);
	    	Collection<String> expected = new ArrayList<String>();
	    	assertArrayEquals("Your graph reported edges at vertex A before any were added", expected.toArray(), uut.getAdjacent("A").toArray());
	    	for (char c = 'Z'; c > 'J'; c--)
	    	{
	    		expected.add("" + c);
	    		assertTrue("Your graph did not add the expected value " + c, uut.addEdge("A", "" + c));
	    		assertTrue("Your graph did not add the expected value " + c, uut.addEdge("G", "" + c));
	    	}
	    	assertArrayEquals("Your graph did not save the expected edges to vertex A", expected.toArray(), uut.getAdjacent("A").toArray());
	    	assertArrayEquals("Your graph did not save the expected edges to vertex G", expected.toArray(), uut.getAdjacent("G").toArray());
	    	assertEquals("The Graph reported the wrong size", expected.size() * 2,  uut.getNumberOfEdges());
	    }
	    @Test		
	    public void testRemove()
	    {
	    	testAdd();
	    	SymbolGraph<String> uut = new SymbolGraph<String>();
	    	setupGraph(uut);
	    	Collection<String> expected = new ArrayList<String>();
	    	for (char c = 'Z'; c > 'J'; c--)
	    	{
	        	expected.add("" + c);
	    		uut.addEdge("A", "" + c);
	    	}
	    	for (char c = 'Z'; c > 'J'; c--)
	    	{
	    		expected.remove("" + c);
	    		uut.removeEdge("A", "" + c);
	        	assertEquals("The number of edges in the graph did not match the expected", expected.size(), uut.getNumberOfEdges());
	        	assertArrayEquals("The vertex A did not match expected while removing", expected.toArray(), uut.getAdjacent("A").toArray());
	    	}
	    }
	    @Test		
	    public void testExceptions()
	    {
	    	testRemove();
	    	SymbolGraph<String> uut = new SymbolGraph<String>();
	    	assertFalse("Your code added an edge to an empty graph", uut.addEdge("A", "B"));
	    	assertFalse("Your code reported it removed an edge from an empty graph", uut.removeEdge("A", "B"));
	    	uut.addVertex("A");
	    	assertFalse("Your code added an edge when only one of the vertices was present", uut.addEdge("A", "B"));
	    	uut.addVertex("B");    	
	    	uut.addEdge("A", "B");
	    	assertFalse("Your code reported it removed an edge that was not present", uut.removeEdge("A", "C"));
	    }
	    private void setupGraph(SymbolGraph<String> uut)
	    {
	    	for(char c = 'A'; c <= 'Z'; c++)
	    	{
	    		uut.addVertex("" + c);
	    	}
	    }
	    private static final String CODE_FILE= "src/graphs/SymbolGraph";
}
