import java.util.Scanner;
import java.util.ArrayList;

public class petClass {
    private String name;
    private String age;
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<petClass> petArray = new ArrayList<>();
    private static final int maxNameLength = 10;
    private static final int maxAgeLength = 4;

    public petClass(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}
    public String getAge() {return age;}

    @Override
    public String toString() {
        return "Pet(name: " + name + ", Age: " + age + ")";
    }

    public static void addPet(){
        System.out.println("Enter the Pets name: ");
        String name = scanner.nextLine().toLowerCase();
        if (name.isEmpty() || name.length() > maxNameLength) {
            System.out.println("Invalid input length, Please try again");
            System.out.println("Enter the Pets name: ");
            name = scanner.nextLine().toLowerCase();
        }

        System.out.println("Enter the pets age: ");
        String age = scanner.nextLine();
        if (age.isEmpty() || age.length() > maxNameLength) {
            System.out.println("Invalid input length, Please try again");
            System.out.println("Enter the pets age: ");
            age = scanner.nextLine();
        }

        petClass PetClass = new petClass(name, age);
        petArray.add(PetClass);

        System.out.println("Pet was added: " + PetClass);
    }

    public static void displayPet(){
        if (petArray.isEmpty()) {
            System.out.println("No pets currently in array");
        }
        System.out.printf("++-------------------++%n");
        System.out.printf("| %-2s | %-10s | %-4s |%n", "ID", "NAME", "Age");  // Header row
        System.out.printf("++-------------------++%n");
        for (int i = 0; i <petArray.size(); i++) {
            petClass pet = petArray.get(i);
            System.out.printf("| %-2d | %-10s | %-4s |%n", i, pet.getName(), pet.getAge());
        }
        System.out.printf("++-------------------++%n");
    }

    public static void SearchPet() {
        if (petClass.petArray.isEmpty()) {
            System.out.println("No pet to search for :(");
        } else {
            System.out.println("Enter pet name to search: ");
            String searchName = scanner.nextLine().toLowerCase();

            System.out.println("\n=== Search Results ===");
            boolean found = false;
            for (int i = 0; i < petArray.size(); i++) {
                String petName = petArray.get(i).getName().toLowerCase();

                if (petName.contains(searchName)) {
                    System.out.println((i) + ": " + petArray.get(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No pet found with the name: " + searchName);
            }
        }
    }
    public static void updatePet() {
        if(petArray.isEmpty()) {
            System.out.println("no pets to be updated");
        }
        else{
            displayPet();
            System.out.println("Enter the number of the pet to update");
            int input = scanner.nextInt();
            scanner.nextLine();

            int index = 0;
            try {
                index = input;
            }
            catch (Exception e) {
                System.out.println("Invalid entry: " + e);
            }

            if (index < 0 || index >= petArray.size()) {
                System.out.println("Index out of range");
            }
            else {
                petClass oldPet = petArray.get(index);
                System.out.println("Updating selected pet: " + oldPet);

                System.out.print("Enter the new pets name: ");
                String newPetName = scanner.nextLine().toLowerCase();
                if (newPetName.isEmpty() || newPetName.length() > maxNameLength) {
                    System.out.println("Invalid input length, Please try again");
                    System.out.print("Enter the new pets name: ");
                    newPetName = scanner.nextLine().toLowerCase();
                }

                System.out.print("Enter the new pets age: ");
                String newPetAge = scanner.nextLine();
                if (newPetAge.isEmpty() || newPetAge.length() > maxNameLength) {
                    System.out.println("Invalid input length, Please try again");
                    System.out.print("Enter the new pets age: ");
                    newPetAge = scanner.nextLine();
                }

                petClass updatedPet = new petClass(newPetName, newPetAge);
                petArray.set(index, updatedPet);

                System.out.println("Pet was updated: " + updatedPet);
            }
        }
    }

    public static void deletePet() {
        if(petArray.isEmpty()) {
            System.out.println("No pets to be deleted");
        }

        displayPet();
        System.out.println("Enter the number of the pet you want deleted: ");
        int input = scanner.nextInt();

        int index = 0;
        try {
            index = input;
        }
        catch (Exception e) {
            System.out.println("Invalid entry: " + e);
        }

        if (index < 0 || index >= petArray.size()) {
            System.out.println("Index out of range");
        }
        else {
            petClass removePet = petArray.remove(index);
            System.out.println("The pet was removed: " + removePet);
        }
    }
}
