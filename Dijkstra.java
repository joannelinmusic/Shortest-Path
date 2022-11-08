package graphs;
public class Dijkstra {

  public static void dijkstra(int[][] graph, int source) {
    int count = graph.length;
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
}
