package jianzhi;

/**
 * Created by Ellen on 2018/1/11.
 */
public class GetNumberOfK38 {
    public static void main(String[] args) {
        int[] data = {2,2,2,2,3,4,6};
        System.out.println(getNumberOfK(data, 5));
        // 查找的数字出现在数组的中间
//        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data1, 3)); // 4
//
//        // 查找的数组出现在数组的开头
//        int[] data2 = {3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data2, 3)); // 4
//
//        // 查找的数组出现在数组的结尾
//        int[] data3 = {1, 2, 3, 3, 3, 3};
//        System.out.println(getNumberOfK(data3, 3)); // 4
//
//        // 查找的数字不存在
//        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data4, 2)); // 0
//
//        // 查找的数字比第一个数字还小，不存在
//        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data5, 0)); // 0
//
//        // 查找的数字比最后一个数字还大，不存在
//        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data6, 0)); // 0
//
//        // 数组中的数字从头到尾都是查找的数字
//        int[] data7 = {3, 3, 3, 3};
//        System.out.println(getNumberOfK(data7, 3)); // 4
//
//        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
//        int[] data8 = {3, 3, 3, 3};
//        System.out.println(getNumberOfK(data8, 4)); // 0
//
//        // 数组中只有一个数字，是查找的数字
//        int[] data9 = {3};
//        System.out.println(getNumberOfK(data9, 3)); // 1

        // 数组中只有一个数字，不是查找的数字
//        int[] data10 = {3};
//        System.out.println(getNumberOfK(data10, 4)); // 0
    }
    public static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data!=null && data.length>0) {
            int first = getFirstK(data, k, 0, data.length-1);
            int last = getLastK(data, k, 0, data.length-1);
            if (first>-1 && last>-1) {
                number = last-first+1;
            }
        }
        return number;
    }
    //得到第一个k的位置(二分查找)
    public static int getFirstK(int[] data, int k, int start, int end) {
        if (start>end) {
            return -1;
        }

        while (start<=end) {
            int mid = (start+end)/2;
            if ((mid>0 && data[mid]==k && data[mid-1]!=k) || (mid==0 && data[mid]==k)) {
//                System.out.println(mid);
                return mid;
            }  else if (data[mid]<k) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    //得到最后一个k的位置
    public static int getLastK(int[] data, int k, int start, int end) {
        if (start>end) {
            return -1;
        }

        while (start<=end) {
            int mid = (start+end)/2;
            if ((mid<data.length-1 && data[mid]==k && data[mid+1]!=k) || (mid==data.length-1 && data[mid]==k)) {
//                System.out.println(mid);
                return mid;
            } else if (data[mid]>k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
