package jianzhi;

import java.util.Arrays;

/**
 * Created by Ellen on 2018/1/17.
 * 判断5张牌是不是顺子
 */
public class IsContinuous44 {
    public static void main(String[] args) {
        int[] numbers = {0,1,6,3,0};
        System.out.println(isContinuous(numbers));
    }
    public static boolean isContinuous(int[] numbers) {
        if (numbers==null || numbers.length!=5) {
            return false;
        }
        int numberOfZero = 0;
        int numberOfGap = 0;
        Arrays.sort(numbers);
        for (int i=0; i<numbers.length && numbers[i]==0; i++) {
            numberOfZero++;
        }
        int small = numberOfZero;
        int big = small+1;
        while (big<numbers.length) {
            if (numbers[big]==numbers[small]) {
                return false;
            }
            numberOfGap += (numbers[big]-numbers[small]-1);
            small = big;
            big++;
        }
        return numberOfGap<=numberOfZero;
    }
}
