import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter number of rows:");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = "";
        
        System.out.println("First triangle:");
        System.out.println("---------------");
        
        for(int i=1; i <= n; i++){
            line += "*";
            System.out.println(line);
        }
        
        System.out.println("Second triangle:");
        System.out.println("---------------");
        
        String dots = "*";
        for(int i=1; i <= n; i++){
            int numBlanks = n-i;
            
            String blanks = "";
            while(numBlanks > 0) {
                blanks += " ";
                numBlanks--;
            }
            
            if(i>1) {
                dots += "**";
            }
            line = blanks + dots;
            System.out.println(line);
        }
        
        System.out.println("Third triangle:");
        System.out.println("---------------");
        
        for(int i=n; i > 0; i--){
            dots = "";
            int numBlanks = n-i;
            int numDots = (i*2)-1;
            String blanks = "";
            while(numBlanks > 0) {
                blanks += " ";
                numBlanks--;
            }
            
            while(numDots > 0){
                dots += "*";
                numDots--;
            }
            line = blanks + dots;
            System.out.println(line);
        }
        
        System.out.println("Fourth triangle:");
        System.out.println("---------------");
        
        for(int i=n; i > 0; i--){
            dots = "";
            int numDots = i;
            int numBlanks = ((n*2)-1)-i;
            String blanks = "";
            while(numBlanks > 0) {
                blanks += " ";
                numBlanks--;
            }
            
            while(numDots > 0){
                dots += "*";
                numDots--;
            }
            line = blanks + dots;
            System.out.println(line);
        }
    }
}
