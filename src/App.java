import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scan.next();
        // System.out.println("Age: ");
        // int age = scan.nextInt();
        System.out.println("Name:" + " " + name);
        // scan.close();
    }
}
