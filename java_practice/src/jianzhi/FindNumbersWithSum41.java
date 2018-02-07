package jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2018/1/13.
 */
public class FindNumbersWithSum41 {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        System.out.print(findNumbersWithSum(data, 5));
        System.out.print(findContinuousSequence(6));
    }
    public static List<Integer> findNumbersWithSum(int[] data, int sum) {
        List<Integer> res = new ArrayList<>();
        if (data==null || data.length<2) {
            return res;
        }
        int ahead = 0;
        int behind = data.length-1;
        int curSum = 0;
        while (ahead<behind) {
            curSum = data[ahead]+data[behind];
            if (curSum==sum) {
                res.add(data[ahead]);
                res.add(data[behind]);
                break;
            } else if (curSum<sum) {
                ahead++;
            } else {
                behind--;
            }
        }
        return res;
    }
    // 题目二：输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum<3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = sum/2;
        int curSum = small+big;
        while (small<=middle) {
            if (curSum==sum) {
                List<Integer> list = new ArrayList<>();
                for (int i=small; i<=big; i++) {
                    list.add(i);
                }
                result.add(list);
            }
            while (small<=middle && curSum>sum) {
                curSum -= small;
                small++;
                if (curSum==sum) {
                    List<Integer> list = new ArrayList<>();
                    for (int i=small; i<=big; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }

            }
            big++;
            curSum += big;
        }
        return result;
    }
}
