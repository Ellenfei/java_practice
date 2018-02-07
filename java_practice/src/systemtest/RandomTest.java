package systemtest;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ye on 2016/11/24.
 */
public class RandomTest {
    public static void main (String [] args) {
        Random rd = new Random();
        System.out.println(rd.nextBoolean());
        byte[] bf = new byte[16];
        rd.nextBytes(bf);
        System.out.println(Arrays.toString(bf));
        System.out.println(rd.nextDouble());
        System.out.println(rd.nextFloat());
    }
}
