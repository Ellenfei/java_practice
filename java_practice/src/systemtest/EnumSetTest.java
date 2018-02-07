package systemtest;

import java.util.EnumSet;

/**
 * Created by ye on 2016/11/26.
 */

enum Season {
    SPRING,SUMMER,FALL,WINTER
}

public class EnumSetTest {
    public static void main (String[] args) {
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);
        EnumSet es2 = EnumSet.noneOf(Season.class);
        System.out.println(es2);
        es2.add(Season.FALL);
        es2.add(Season.SPRING);
        System.out.println(es2);

    }
}
