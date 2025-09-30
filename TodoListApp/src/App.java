
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Item> itemsList = new ArrayList< Item>(){
            {
                add(new Item("Buy", "All groceries for the party"));
                add(new Item("Call wife", "Call to remind her to feed the cat"));
                add(new Item("Mechanic", "Take the car to the mechanic to get a checkup"));
                add(new Item("Emil Mike", "Send Mike an evite to the house BBQ"));
                add(new Item("Pickup mom", "Remember to pickup mom from the airpot"));
            }
        };
        for(int i=0; i<itemsList.size(); i++){
            System.out.println((i+1) + ". " + itemsList.get(i));
        }
    }
}
