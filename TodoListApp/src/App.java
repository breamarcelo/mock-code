
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Item> itemsList = new ArrayList<Item>();
    public static void main(String[] args) throws Exception {
        int option = -1;
        while (option != 5) {
            itemsList = read();
            System.out.println("__________________________" + "\n" +
                               "       TodoList App       " + "\n" +
                               "__________________________" + "\n");
            System.out.println("Select option:");
            System.out.println("1. Display list");
            System.out.println("2. Add item");
            System.out.println("3. Update item");
            System.out.println("4. Delete item");
            System.out.println("5. Close");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    display(itemsList);
                    break;
                case 2:
                    write(itemsList);
                    break;
                case 4:
                    delete(itemsList);
                    break;
            }
        }
      sc.close();  
    }
    
    public static void write(ArrayList<Item> items){
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter description: ");
        String description = sc.nextLine();
    
        Item myItem = new Item(title, description);
        items.add(myItem);
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.dat"))) {
            for(Item item : items) {
                oos.writeObject((Item) item);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<Item> read(){
        ArrayList<Item> items = new ArrayList<Item>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.dat"))) {
            try {
                while (true) { 
                    items.add((Item) ois.readObject());
                }
            } catch (Exception e) {
            }
            ois.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return items;
    }

    public static void display(ArrayList<Item> items){
        int counter = 1;
        for(Item item : items) {
            System.out.println(counter + ") " + item);
            counter++;
        }
    }

    public static void delete(ArrayList<Item> items){
        System.out.println("Write item index (1-" + items.size() + "):");
        int index = sc.nextInt();
        sc.nextLine();
        items.remove(index - 1);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.dat"))) {
            for(Item item : items) {
                oos.writeObject((Item) item);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void update(ArrayList<Item> items) {
        
    }
}
