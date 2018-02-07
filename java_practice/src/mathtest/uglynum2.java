package mathtest;

/**
 * Created by ye on 2017/3/8.
 */
public class uglynum2 {
    public static void main(String[] args) {
        System.out.print(nthUglyNumber(7));
    }

    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int i2=0,i3=0,i5=0;
        ugly[0]=1;
        for (int i=1; i<n; i++) {
            int min = Math.min(Math.min(2*ugly[i2],3*ugly[i3]),5*ugly[i5]);
            ugly[i] = min;
            if (min == 2*ugly[i2] )
                i2++;
            if (min == 3*ugly[i3] )
                i3++;
            if (min == 5*ugly[i5] )
                i5++;
        }
        return ugly[n-1];
    }
}
