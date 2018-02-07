package mathtest;

/**
 * Created by ye on 2017/3/9.
 */
public class superuglynum {
    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        System.out.print(nthSuperUglyNumber(12,primes));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        int[] uglyNum = new int[n];
        int[] index = new int[length];
        uglyNum[0] = 1;
        for (int i=1; i<n; i++) {
            uglyNum[i] = Integer.MAX_VALUE;
            for (int j=0; j<length; j++) {
                uglyNum[i] = Math.min(uglyNum[i],primes[j]*uglyNum[index[j]]);
            }
            for (int j=0; j<length; j++) {
                if (primes[j]*uglyNum[index[j]]==uglyNum[i]) {
                    index[j]++;
                }
            }
        }
        return uglyNum[n-1];
    }
}
