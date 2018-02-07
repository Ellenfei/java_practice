package jianzhi;

/**
 * Created by Ellen on 2018/1/7.
 */
public class NumberOf132 {
    public static void main(String[] args) {
        System.out.print(numberOf1Between1AndN(14));
    }
    public static int numberOf1Between1AndN(int n) {
        if(n<=0) {
            return 0;
        }
        int count = 0;
        int m = 1;
//        for ()
        while (m<=n) {
            int a = n/m;
            int b = n%m;
            if (a%10==1) {
                count += (a/10)*m+(b+1);
            } else {
                count += ((a+8)/10)*m;
            }
            m *= 10;
        }
        return count;
    }
}
