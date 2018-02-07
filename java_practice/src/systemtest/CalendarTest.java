package systemtest;

import java.util.Calendar;

/**
 * Created by ye on 2016/11/25.
 */
public class CalendarTest {
    public static void main (String [] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));
        c.set(2002, 10, 21, 10, 30, 10);
        System.out.println(c.getTime());
        c.add(Calendar.YEAR, -2);
        System.out.println(c.getTime());
        c.set(Calendar.MONTH, 1);
        System.out.println(c.getTime());

    }
}
