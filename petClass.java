import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;

public class petClass {
    private final String name;
    private final int age;
    static Scanner scanner = new Scanner(System.in);
    private static final ArrayList<petClass> petArray = new ArrayList<>();
    private static final int maxNameLength = 10;
    private static final int maxAge = 20;
    private static final int minAge = 0;
    private static final Integer noValue = null;


    public petClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}
    public int getAge() {return age;}

    @Override
    public String toString() {
        return "Pet(name: " + name + ", Age: " + age + ")";
    }

    public static void readPetsFromFile(String fileName) throws IOException {
        File file =  new File(fileName);
        if(!file.exists()) {
            System.out.println("No files found: \n(" + fileName + ") Starting an empty pet list");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 2) continue;

                String petName = parts[0];
                try {
                    int petAge = Integer.parseInt(parts[1]);
                    new petClass(petName, petAge);
                } catch (NumberFormatException e) {
                    System.out.println("Error has occurred: " + e);
                }
            }
        }
    }

    public static void savePetsToFile(String fileName) throws IOException {
        try (PrintWriter write = new PrintWriter(new FileWriter(fileName))) {
            for( petClass pet: petArray) {
            write.println(pet.getName() + " " + pet.getAge());
            }
        }
    }


    public static void addPet(){
        if (petArray.size() > 4){
            System.out.println("Maximum capacity reached, limit of 5 pets");
        }else {
            System.out.println("Enter the Pets name: ");
            String name = scanner.nextLine().toLowerCase();
            if (name.isEmpty() || name.length() > 10 || name.matches("^\\d+$")) {
                System.out.println("Invalid input length, Please try again");
                System.out.println("Enter the Pets name: ");
                name = scanner.nextLine().toLowerCase();
            }

            System.out.println("Enter the pets age: ");
            int age = scanner.nextInt();

            if (age < minAge || age > maxAge || noValue == null ||noValue != age) {
                System.out.println("Invalid input, Please try again");
                System.out.println("Enter the pets age: ");
                age = scanner.nextInt();
            }

            petClass PetClass = new petClass(name, age);
            petArray.add(PetClass);

            System.out.println("Pet was added: " + PetClass);
        }
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
                int newPetAge = scanner.nextInt();
                if (newPetAge < minAge || newPetAge > maxNameLength || newPetAge == noValue) {
                    System.out.println("Invalid input length, Please try again");
                    System.out.print("Enter the new pets age: ");
                    newPetAge = scanner.nextInt();
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

