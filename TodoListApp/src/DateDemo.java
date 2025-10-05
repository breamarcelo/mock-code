import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println(date);
        //System.out.println(cal);
        LocalDate ld = LocalDate.of(2025, 10, 3);
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Before formatting:");
        System.out.println(ld);
        System.out.println("After formatting:");
        System.out.println(ld.format(myFormat));
    }
}
