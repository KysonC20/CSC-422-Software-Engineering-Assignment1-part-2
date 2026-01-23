import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<petClass> petArray = new ArrayList<>();
        Scanner Scan = new Scanner(System.in);
        boolean running = true;

        System.out.println("Do you have an existing file (y/n): ");
        String haveFile = Scan.nextLine().trim().toLowerCase();
        if(haveFile.equals("y")) {
            System.out.println("Please type in the exact file name: ");
            String inputFile = Scan.nextLine();
            petClass.readPetsFromFile(inputFile);
        }else{
            System.out.println("No File inputed");
        }

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
                    petClass.updatePet();
                    break;
                case 4:
                    petClass.deletePet();
                    break;
                case 5:
                    petClass.SearchPet();
                    break;
                case 6:
                    System.out.println("Exiting the pet manager");
                    Scan.nextLine();
                    System.out.println("Would you like to save your file? (y/n): ");
                    String saveFile = Scan.nextLine().trim().toLowerCase();

                    if ( saveFile.equals("y")) {
                        try {
                            petClass.savePetsToFile("pets0File.txt");
                            System.out.println("Saved file: " + petArray);
                        } catch (IOException e) {
                            System.out.println("Save file Failed: " + e);
                        }
                    }

                    System.out.println("Thank you for using the program");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input, Please try again");

            }

        }

    }
}
