import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class DateDemo {
    public static void main(String[] args) {
        ArrayList<LocalDate> datesList = new ArrayList<LocalDate>();

        LocalDate date1 = LocalDate.of(2025, 10, 3);
        LocalDate date2 = LocalDate.of(1992, 7, 21);
        LocalDate date3 = LocalDate.of(1999, 6, 14);
        LocalDate date4 = LocalDate.of(2019, 4, 18);
        LocalDate date5 = LocalDate.of(1987, 1, 16);

        datesList.add(LocalDate.now());
        datesList.add(date1);
        datesList.add(date2);
        datesList.add(date3);
        datesList.add(date4);
        datesList.add(date5);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("before sort:");
        for(LocalDate date : datesList){
            System.out.println(date.format(myFormat));
        }
        Collections.sort(datesList);
        System.out.println("after sort:");
        String today = LocalDate.now().format(myFormat);
        for(LocalDate date : datesList){
            String d = date.format(myFormat);
            if(d.equals(today)){
                System.out.println("TODAY: " + date.format(myFormat));
            } else {
                System.out.println(date.format(myFormat));
            }
        }
        System.out.println("Selected element [1]");
        System.out.println(datesList.get(1).format(myFormat));
        System.out.println("Time: ");
        LocalTime lt = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(lt);
        System.out.println(lt.format(timeFormat));

    }
}
