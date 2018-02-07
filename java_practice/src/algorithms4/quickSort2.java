package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * ��������
 * һ�˿��������㷨��
 * 1.������������i=0, j=n-1;
 * 2.�Ե�һ��Ԫ��Ϊ��׼ key=nums[0];
 * 3.��j��ʼ��ǰ���������ɺ�ʼ��ǰ����(j--)���ҵ���һ��С��key��ֵA[j]����A[j]��A[i]������
 * 4.��i��ʼ�������������ǰ��ʼ�������(i++)���ҵ���һ������key��A[i]����A[i]��A[j]������
 * 5.ֱ��key��ߵĶ�������key��key�ұߵĶ���С��key����i==jʱ��ֹѭ��
 * ʱ�临�Ӷȣ�nlogn-n^2 �ռ临�Ӷȣ�lgn-n���ݹ�ջռ�ÿռ䣩
 * �ȶ��ԣ���
 */
public class quickSort2 {
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(100000);
        System.out.println(length);
        int[] nums = new int[length];
        for (int i=0; i<length; i++) {
            nums[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(nums));
        long startTime = System.currentTimeMillis();
        quick(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }

    public static void quick(int[] nums) {
        quick(nums, 0, nums.length-1);
    }
    public static void quick(int[] nums, int start, int end) {
        int i=start, j=end;
        int key = nums[start];
        while (i<j) {
            //j--ֱ��nums[j]С��keyΪֹ
            while (i<j && nums[j]>=key)
                j--;
            if (i<j) {
                nums[i] = nums[j];
                i++;
            }
            //i++ֱ��nums[i]����keyΪֹ
            while (i<j && nums[i]<=key)
                i++;
            if (i<j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        if (i>start) quick(nums, start, i-1);
        if (j<end) quick(nums, j+1, end);
    }

    /*public static void quick(int[] nums, int start, int end) {
        int i=start, j=end;
        int partition = nums[start];
        while (i<j ){
            while (i<j && partition<=nums[j]) j--;
            if (i<j) {
                int temp;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }

            while (i<j && partition>=nums[i]) i++;
            if (i<j) {
                int temp;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        if (i>start) quick(nums,start,i-1);
        if (j<end) quick(nums,j+1,end);
    }*/


}
