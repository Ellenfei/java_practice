package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * ѡ������������nums[0]-nums[n-1]ѡ����С��Ԫ�أ���nums[0]������Ȼ����nums[1]-nums[n-1]ѡ����С��Ԫ�أ���nums[1]����
 * .....�������ƣ����յõ��������е�����
 * ʱ�临�Ӷȣ�n^2���ռ临�Ӷȣ�1
 * �ȶ��ԣ���
 */
public class selectSort {
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(1000);
        System.out.println(length);
        int[] nums = new int[length];
        for (int i=0; i<length; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(nums));
        long startTime = System.currentTimeMillis();
        select(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }

    public static void select(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int min = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (min > nums[j]) {
                    nums[i] = nums[j];
                    nums[j] = min;
                    min = nums[i];
                }
            }
        }
    }
}
