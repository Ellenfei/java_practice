package jianzhi;

/**
 * Created by Ellen on 2017/12/16.
 */
public class Fibonacci9 {
    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
    }

    public static long fibonacci(int n) {
        if (n<=0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        long fibOne = 1; //n-1
        long fibTwo = 0; //n-2
        long finN = 1;  //n
        while (n>1){
            finN = fibOne+fibTwo;
            fibTwo = fibOne;
            fibOne = finN;
            n--;
        }
        return finN;
    }
}
