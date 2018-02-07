package jianzhi;

import java.util.Arrays;

/**
 * Created by Ellen on 2018/1/24.
 */
public class Multiply52 {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        System.out.println(Arrays.toString(muliply(data)));
    }
    public static double[] muliply(int[] data) {
        if (data==null || data.length<2) {
            return null;
        }
        double[] result = new double[data.length];
        result[0] = 1;
        //result[i]表示data[0]*data[1]*...*data[i-1]
        for (int i=1; i<data.length; i++) {
            result[i] = result[i-1]*data[i-1];
        }
        double temp = 1;
        //i=n-1时，result[n-1]结果已经计算出来了
        for (int i=data.length-2; i>=0; i--) {
            temp *= data[i+1];
            result[i] *= temp;
        }
        return result;
    }
}
