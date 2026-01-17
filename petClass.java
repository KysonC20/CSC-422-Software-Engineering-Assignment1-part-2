import java.util.Scanner;
import java.util.ArrayList;

public class petClass {
    private String name;
    private String type;
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<petClass> petArray = new ArrayList<>();

    public petClass(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {return name;}
    public String getType() {return type;}

    @Override
    public String toString() {
        return "Pet(name: " + name + ", Type: " + type + ")";
    }

    public static void addPet(){
        System.out.println("Enter the Pets name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the pets type, Ex.dog or cat: ");
        String type = scanner.nextLine();

        petClass PetClass = new petClass(name, type);
        petArray.add(PetClass);

        System.out.println("Pet was added: " + PetClass);
    }

    public static void displayPet(){
        if (petArray.isEmpty()) {
            System.out.println("No pets currently in array");
        }
        System.out.println("\nList of pets:");
        for (int i = 0; i <petArray.size(); i++) {
            System.out.println(i + 1 + ": " + petArray.get(i));
        }
    }

    public static void SearchPet() {
        if (petClass.petArray.isEmpty()) {
            System.out.println("No pet to search for :(");
        }

        else {
            System.out.println("Enter pet name to search: ");
            String searchName = scanner.nextLine().toLowerCase();

            System.out.println("\n=== Search Results ===");
            boolean found = false;
            for (int i = 0; i < petArray.size(); i++) {
                String petName = petArray.get(i).getName().toLowerCase();

                if (petName.contains(searchName)) {
                    System.out.println((i + 1) + ": " + petArray.get(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No pet found with the name: " +searchName);
            }
        }
    }

    
}
