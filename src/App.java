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
        String input = scan.nextLine();
        userDraw.addVertex(input);

        System.out.println("Would you like to add more vertex? (Enter only true or false)");
        Boolean addBoolean = scan.nextBoolean();

        while (addBoolean){
            scan.nextLine();
            System.out.println("Add your next vertex: ");
            input = scan.nextLine();
            userDraw.addVertex(input);
            System.out.println("Would you like to add more vertex? (Enter only true or false)");
            addBoolean = scan.nextBoolean();
        }

        System.out.println("Your currently have " + userDraw.getNumberOfVerticies() + " vertices");

        scan.nextLine();
        System.out.println("Are you finished adding vertex and edge? ");
        addBoolean = scan.nextBoolean();
        if (addBoolean){
            if (userDraw.getNumberOfEdges()<1 || userDraw.getNumberOfVerticies()<2){
                System.out.println("Are you finished adding vertex and edge? ");
            }
        }
        

        
    }
}
