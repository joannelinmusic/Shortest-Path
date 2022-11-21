import java.util.Scanner;
import java.util.Arrays;


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
        System.out.println("Hi " + userName + ", Let's create a graph!");

        //Direct user to create a graph
        userDraw = new SymbolGraph<>();

        addHelper();
    }



    private static void addHelper(){
        //add first vertex
        System.out.println("Add your first vertex: \n Type 'Vertex: your vertex name'");
        String input = scan.nextLine();
        

        while (!input.toLowerCase().contains("done")){
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
            //add more vertex and edge
            if (userDraw.getNumberOfVerticies()>=2){
                System.out.println("Add your next vertex: (See format below) \n Adding a Vertex: 'Vertex: your vertex name' \n Adding an edge: (all seperated by space) 'Edge: Vertex_1 Vertex_2 Weight(integer)' \n If you're done: Type 'done' ");
            } else {
                System.out.println("Add your next vertex: \n Type 'Vertex: your vertex name' ");
            }
            
            input = scan.nextLine();
        }


        

        //scan.nextLine();
        
    }
}
