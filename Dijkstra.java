package graphs;

public class Dijkstra {

  public static void dijkstra(SymbolGraph<Integer> graph, int source) {
	  
    int count = graph.getNumberOfVerticies();
    boolean[] visitedVertex = new boolean[count];
    int[] distance = new int[count];
	  
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distance[i] = Integer.MAX_VALUE;
    }

    // Distance of self loop is zero
    distance[source] = 0;
    for (int i = 0; i < count; i++) {

      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distance, visitedVertex);
      visitedVertex[u] = true;
}
  }

private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
	
	int ShortestDistance = Integer.MAX_VALUE;
        int ShortestDistanceVertex = -1;
	
        for (int i =0; i < distance.length; i++){
            //if vertex is not visited and the distance is the minimum.
            if(!visitedVertex[i] && distance[i] < ShortestDistance){
		//then find the min element of an array
                ShortestDistance = distance[i];
                ShortestDistanceVertex = i;
            }
        }
	
        return ShortestDistanceVertex;
}
 public static void main(String[] args) {
     
        SymbolGraph<Integer> draw = new SymbolGraph<>();

        int NewGraph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },{ 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 } };
                
        // use loop to add vertex to graph class
	 
        for (int i=0;i<NewGraph.length;i++)draw.addVertex(i);
        
        // use loop to add edges to edges class
	 
        for (int i=0;i<NewGraph.length;i++){
            for(int j = 0;j<NewGraph.length;j++){
                if(NewGraph[i][j]!=0){
			
                    draw.addEdge(i,j,NewGraph[i][j]);
                }
            }
        }
        Dijkstra D= new Dijkstra();

        D.dijkstra(NewGraph, 0); //Find and print min distance of all other nodes from node 0
    }
}
