package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/12.
 * ϣ�����򣺽����鰴��һ��������������в�������ֱ������Ϊ1
 * ʱ�临�Ӷȣ�NlogN ; �ռ临�Ӷȣ�1
 * �ȶ��ԣ���
 */
public class shellSort {
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(10000);
        System.out.println(length);
        int[] nums = new int[length];
        for (int i=0; i<length; i++) {
            nums[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(nums));
        long startTime = System.currentTimeMillis();
        sort(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");

    }

    public static void sort(int[] nums) {
        int gap = 1;
        while (gap<nums.length/3) gap = gap*3+1;
        while (gap>=1) {
            for (int i=gap; i<nums.length; i++)
                for (int j=i; j>=gap && nums[j]<nums[j-gap]; j-=gap) {
                    int temp = nums[j];
                    nums[j] = nums[j-gap];
                    nums[j-gap] = temp;
                }
            gap /= 3;
        }
    }
}
