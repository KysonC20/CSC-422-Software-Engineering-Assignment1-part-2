import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<petClass> petArray = new ArrayList<>();
        Scanner Scan = new Scanner(System.in);
        boolean running = true;


        while(running) {
            System.out.println("Please choose an option listed by number\n");
            System.out.println("==== Pet Manager ====");
            System.out.println("== 1. Add a pet ==");
            System.out.println("=2. display all pets=");
            System.out.println("== 3.Update a Pet ==");
            System.out.println("== 4.Remove a pet ==");
            System.out.println("= 5.Search for a pet =");
            System.out.println("= 6.Exit the program =");
            System.out.println("Your input here: ");

            switch (Scan.nextInt()) {
                case 1:
                    petClass.addPet();
                    break;
                case 2:
                    petClass.displayPet();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    petClass.SearchPet();
                    break;
                case 6:
                    System.out.println("Exiting the pet manager");
                    System.out.println("Thank you for using the program");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input, Please try again");

            }

        }

    }
}
