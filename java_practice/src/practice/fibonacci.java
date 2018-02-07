package practice;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/20.
 */
public class fibonacci {
    public static int k=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        System.out.println(fibonacci(a));
        System.out.println("共递归调用"+k+"次");
    }
    public static long fibonacci(long num) {
        if (num==0 || num==1) {
            k++;
            return num;
        }
        return fibonacci(num-2)+fibonacci(num-1);
    }
}
