package systemtest;

import java.util.Date;

/**
 * Created by ye on 2016/11/25.
 */
public class DateTest {
    public static void main (String[] args) {
        Date date = new Date();
        Date date1 = new Date(System.currentTimeMillis() +1000);
        System.out.println(date1);
        System.out.println(date);
        System.out.println(date.compareTo(date1));
        System.out.println(date1.before(date));
    }
}
