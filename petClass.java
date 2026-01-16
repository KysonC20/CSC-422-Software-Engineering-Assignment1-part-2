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
}
