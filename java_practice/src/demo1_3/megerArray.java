package demo1_3;

/**
 * Created by ye on 2017/1/18.
 */
public class megerArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2,4};
        int[] nums2 = {3,4};
        merge(nums1,3,nums2,2);
        System.out.print(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //if (m<1 || n<1) return;
        int k=m+n-1, i=m-1, j=n-1;
        while (i>-1 && j>-1) {
            nums1[k--] = nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j>-1) nums1[k--] = nums2[j--];
        /*while(k>-1) {
            if (i<0 || j>-1 && nums1[i]<nums2[j]) nums1[k--] = nums2[j--];
            else nums1[k--] = nums1[i--];
        }*/
    }
}
