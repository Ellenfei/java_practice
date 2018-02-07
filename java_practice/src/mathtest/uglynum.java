package mathtest;

/**
 * Created by ye on 2017/3/7.
 */
public class uglynum {
    public static void main(String[] args) {
        System.out.print(isUgly(14));
    }

    public static boolean isUgly(int num) {
        for (int i=2; i<6 && num>0; i++){
            while (num % i == 0) {
                num = num/i;
            }
        }
        return num==1;
    }
}
