import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra {

	

    public Map<String, Integer> dijkstra(SymbolGraph<String> NewGraph, String source) {
        
        HashSet<String> visitedSet =  new HashSet<>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        // creating priority object to store nodes with their distance from source
        PriorityQueue<String> objectQ = new PriorityQueue<>((o1,o2)->distance.getOrDefault(o1,Integer.MAX_VALUE)-distance.getOrDefault(o2,Integer.MAX_VALUE));
    
        // Distance of self loop is zero
        distance.put(source,0);
        
        //now adding source node to priority objectQ
        objectQ.add(source);

        while (!objectQ.isEmpty()){

            String NewNode = objectQ.poll(); // to get out the minimum distance node from priority objectQ

            if(visitedSet.contains(NewNode)) continue; // if NewNode is visited, do not add it or skip it

            visitedSet.add(NewNode);// if not visited mark as visited 
        
            // creating new map that take edges from current nodes

            Map<String, Integer> adjacentEdges = NewGraph.getAdjacent(NewNode); 
    
            // now loop through the adjacent nodes 
            for(String adjacentNode : adjacentEdges.keySet()){// adjacent nodes

                if(visitedSet.contains(adjacentNode)) continue; // if adjacent node visited, do not add or skip it
                // if new distance of adjacent new node is less than already noted distance than change id and add to objectQ
                if(distance.get(NewNode) + adjacentEdges.get(adjacentNode) < distance.getOrDefault(adjacentNode, Integer.MAX_VALUE)){ 
                    
                    // updat distance                                                                    
                    distance.put(adjacentNode, distance.get(NewNode) + adjacentEdges.getOrDefault(adjacentNode, Integer.MAX_VALUE));
            
                    //  finally add the shortest distance to objectQ
                    objectQ.add(NewNode); 
                }
            }
        }
        // System.out.println(Arrays.toString(distance));
        return distance;
    // a helpful website we used to create the dijkstra method https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
    }
 public static void main(String[] args) {
     
        SymbolGraph<String> draw = new SymbolGraph<>();

        draw.addVertex("A");
        draw.addVertex("B");
        draw.addVertex("C");
        draw.addEdge("A","C",2);
        draw.addEdge("A","B",2);
        draw.addEdge("B","C",1);

        Dijkstra D= new Dijkstra();

        Map<String, Integer> distance = D.dijkstra(draw, "C"); //print short distance of all other nodes from node 0

        for (Map.Entry<String, Integer>  entry: distance.entrySet()) {
            System.out.println("The shortest distance to "+entry.getKey()+" is " + entry.getValue());
        }

        
    }
}
