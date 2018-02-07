package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * �������򣺽�Ԫ�ط�Ϊ��������������֣�ÿ�δ�����ǽ��������е�
 * ��һ��Ԫ�����������е�Ԫ�شӺ���ǰ������бȽϣ��ҳ�����λ�ã�
 * ����Ԫ�ز��뵽�������еĺ���λ���С���Ҫ�ƶ�Ԫ��
 * nums[0]      nums[1] nums[2] ..... nums[n-1]
 * ...........
 * ʱ�临�Ӷȣ�����n-n^2 ���ռ临�Ӷȣ�1
 * �ȶ��ԣ���
 */
public class insertSort {
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
        insert(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }
    public static void insert(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            int temp = nums[i];
            for (int j=i-1; j>=0; j--) {
                if (temp<nums[j]) {
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
