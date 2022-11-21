import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        //create scanner class
        Scanner scan = new Scanner(System.in);
        String userName;
        System.out.println("Enter Name: ");
        userName = scan.nextLine();   
        
        System.out.println("Hi " + userName + ", Let's create a graph!");

        //Direct user to create a graph
        SymbolGraph<String> userDraw = new SymbolGraph<>();
        System.out.println("Add your first vertex: ");
        String vertex = scan.nextLine();
        userDraw.addVertex(vertex);

        System.out.println("Would you like to add more vertex? (Enter only true or false)");
        Boolean addBoolean = scan.nextBoolean();

        while (addBoolean){
            scan.nextLine();
            System.out.println("Add your next vertex: ");
            vertex = scan.nextLine();
            userDraw.addVertex(vertex);
            System.out.println("Would you like to add more vertex? (Enter only true or false)");
            addBoolean = scan.nextBoolean();
        }

        System.out.println("Your currently have " + userDraw.getNumberOfVerticies() + " vertices");



        
    }
}
