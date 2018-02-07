package jianzhi;

import java.util.Arrays;

/**
 * Created by Ellen on 2018/1/12.
 */
public class FindNumbersAppearanceOnce40 {
    public static void main(String[] args) {
        int[] data = {1,3,2,2};
        System.out.print(Arrays.toString(findNumbersAppearanceOnce(data)));
    }
    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] res = new int[2];
        if (data==null || data.length<2) {
            return res;
        }
        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }
        int index = findFirstBit1(xor);
        for (int num : data) {
            if (isBit1(num, index)) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
    public static int findFirstBit1(int xor) {
        int index = 0;
        while ((xor & 1)==0 && index<32) {
            xor >>= 1;
            index++;
        }
        return index;
    }
    public static boolean isBit1(int num, int index) {
        num >>= index;
        return (num & 1)==1;
    }
}
