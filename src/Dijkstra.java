import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

	
    static class Temp{
        int vertex;
        int distance; // current distance of source to vertex
        public Temp(int vertex, int distance){
            this.vertex = vertex;
            this.distance =  distance;
        }
    }

    public void dijkstra(SymbolGraph<Integer> NewGraph, int source) {
        
        int count = NewGraph.getNumberOfVerticies();
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        
        // creating priority object to store nodes with their distance from source
        PriorityQueue<Temp> objectQ = new PriorityQueue<>((Comparator.comparingInt(o -> o.distance)));
    
        // Distance of self loop is zero
        distance[source] = 0;
        
        //now adding source node to priority objectQ
        objectQ.add(new Temp(source, distance[source]));

        while (objectQ.size()>0){

            Temp NewNode = objectQ.poll(); // to get out the minimum distance node from priority objectQ

            if(visitedVertex[NewNode.vertex]) continue; // if NewNode is visited, do not add it or skip it

            visitedVertex[NewNode.vertex] = true; // if not visited mark as visited 
        
            // creating new map that take edges from current nodes

            Map<Integer, Integer> adjacentEdges = NewGraph.getAdjacent(NewNode.vertex); 
    
            // now loop through the adjacent nodes 
            for(int adjacentNode : adjacentEdges.keySet()){// adjacent nodes

                if(visitedVertex[adjacentNode])continue; // if adjacent node visited, do not add or skip it
            
                // if new distance of adjacent new node is less than already noted distance than change id and add to objectQ
                if(NewNode.distance + adjacentEdges.get(adjacentNode) < distance[adjacentNode]){ 
                    // updat distance                                                                    
                    distance[adjacentNode] = NewNode.distance + adjacentEdges.get(adjacentNode);
            
                    //  finally add the shortest distance to objectQ
                    objectQ.add(new Temp(adjacentNode,distance[adjacentNode])); 
                }
            }
        }
            System.out.println(Arrays.toString(distance));
    // a helpful website we used to create the dijkstra method https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
    }
 public static void main(String[] args) {
     
        SymbolGraph<Integer> draw = new SymbolGraph<>();

        int NewGraph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },{ 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 } };
                
        // use loop to add vertex to graph class
	 
        for (int i=0;i < NewGraph.length;i++) draw.addVertex(i);
        
        // use loop to add edges to edges class
	 
        for (int i=0; i< NewGraph.length;i++){
            for(int j = 0;j < NewGraph.length;j++){
                if(NewGraph[i][j]!=0){
			
                    draw.addEdge(i,j,NewGraph[i][j]);
                }
            }
        }
        Dijkstra D= new Dijkstra();

        D.dijkstra(draw, 0); //print short distance of all other nodes from node 0

        
    }
}
