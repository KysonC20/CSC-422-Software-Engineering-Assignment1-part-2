import java.util.Scanner;
import java.util.ArrayList;

public class petClass {
    private String name;
    private String type;
    Scanner Scanner = new Scanner(System.in);
    ArrayList<petClass> petArray = new ArrayList<>();

    public petClass(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Pet(name: " + name + ", Type: " + type + ")";
    }

    private void addPet(String input){
        System.out.println("Enter the Pets name: ");
        input = Scanner.nextLine();
        System.out.println("Pet was added: " + input);
    }

    private void displayPet(){
        if (petArray.isEmpty()) {
            System.out.println("No pets currently in array");
        }
    }
}
