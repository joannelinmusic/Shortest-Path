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
        SymbolGraph<Integer> userDraw = new SymbolGraph<>();
        System.out.println("Your currently have " + userDraw.getNumberOfVerticies() + "vertices");



        
    }
}
