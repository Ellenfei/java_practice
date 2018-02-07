package mathtest;

import java.util.HashSet;

/**
 * Created by ye on 2017/3/7.
 */
public class happynum {
    public static void main(String[] args) {
        System.out.print(isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sqrsum,remain;
        while (set.add(n)) {
            sqrsum = 0;
            while (n > 0) {
                remain = n % 10;
                sqrsum += remain * remain;
                n /= 10;
            }
            if (sqrsum == 1)
                return true;
            else
                n = sqrsum;
        }
        return false;
    }
}
