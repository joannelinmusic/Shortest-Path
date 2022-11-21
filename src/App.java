import java.util.Scanner;
import java.util.Map;


public class App {
    static Scanner scan;
    static String userName;
    static SymbolGraph<String> userDraw;
    static String input;
    public static void main(String[] args) throws Exception {

        //create scanner class
        scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        userName = scan.nextLine();   
        System.out.println("Hi " + userName + ", Let's create an graph!");

        //Direct user to create a graph
        userDraw = new SymbolGraph<>();

        addHelper();

        System.out.println("Now let's find the distances of vertex. Which vertex would you like to set as the source vertex?");
        input = scan.nextLine();

        Dijkstra d = new Dijkstra();
        Map<String, Integer> distance = d.dijkstra(userDraw, input);
        for (Map.Entry<String, Integer>  entry: distance.entrySet()) {
            System.out.println("The shortest distance to "+entry.getKey()+" is " + entry.getValue());
        }

    }

    private static void addHelper(){
        //add first vertex
        System.out.println("You will need at least two vertex and one edge to continue. All vertex must be an integer.");
        System.out.println("Add your first vertex: \n      Example: 'Vertex: A'");
        String input = scan.nextLine();
        
        //add more vertex and edge
        while (!input.toLowerCase().contains("done")){

            //user input will contain either vertex or edge to determine what to add
            if (input.contains("Vertex")){
                String[] vertexSplit = input.split(" ");
                userDraw.addVertex(vertexSplit[1]);
            } else if (input.contains("Edge")){
                String[] edgeSplit = input.split(" ");
                userDraw.addEdge(edgeSplit[1], edgeSplit[2] , Integer.parseInt(edgeSplit[3]));
            } else {
                System.out.println("Your input format is incorrect.");
            }
            
            System.out.println("You currently have " + userDraw.getNumberOfVerticies() + " vertices and " + userDraw.getNumberOfEdges() + " edges.");
            
            if (userDraw.getNumberOfVerticies()>=2){
                
                System.out.println("Add your next vertex: (See format below) \n Adding a Vertex: 'Vertex: your vertex name' \n      Example: 'Vertex: A' \n Adding an edge: Type 'Edge: your VertexOneName your VertexTwoName Weight(any integer) '\n       Example: 'Edge: A B 2' \n If you're done: Type 'done' ");
            } else {
                System.out.println("Add your next vertex: \n      Example: 'Vertex: A'");
            }
            
            input = scan.nextLine();
        }
        
    }
}
