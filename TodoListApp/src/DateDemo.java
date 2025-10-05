import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println(date);
        //System.out.println(cal);
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
    }
}
