package jianzhi;

/**
 * Created by Ellen on 2017/12/17.
 * 1  的个数
 */
public class NumberOfOne10 {
    public static void main(String[] args) {
        System.out.print(numberOfOne(0B10111));
    }
    public static int numberOfOne(int num) {
        int count = 0;
        while (num!=0) {
            //1 的个数 n&(n-1)
            num = num & (num-1);
            count++;
        }
        return count;
    }
}
