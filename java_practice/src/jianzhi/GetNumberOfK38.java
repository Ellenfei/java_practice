package jianzhi;

/**
 * Created by Ellen on 2018/1/11.
 */
public class GetNumberOfK38 {
    public static void main(String[] args) {
        int[] data = {2,2,2,2,3,4,6};
        System.out.println(getNumberOfK(data, 5));
        // ���ҵ����ֳ�����������м�
//        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data1, 3)); // 4
//
//        // ���ҵ��������������Ŀ�ͷ
//        int[] data2 = {3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data2, 3)); // 4
//
//        // ���ҵ��������������Ľ�β
//        int[] data3 = {1, 2, 3, 3, 3, 3};
//        System.out.println(getNumberOfK(data3, 3)); // 4
//
//        // ���ҵ����ֲ�����
//        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data4, 2)); // 0
//
//        // ���ҵ����ֱȵ�һ�����ֻ�С��������
//        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data5, 0)); // 0
//
//        // ���ҵ����ֱ����һ�����ֻ��󣬲�����
//        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
//        System.out.println(getNumberOfK(data6, 0)); // 0
//
//        // �����е����ִ�ͷ��β���ǲ��ҵ�����
//        int[] data7 = {3, 3, 3, 3};
//        System.out.println(getNumberOfK(data7, 3)); // 4
//
//        // �����е����ִ�ͷ��βֻ��һ���ظ������֣����ǲ��ҵ�����
//        int[] data8 = {3, 3, 3, 3};
//        System.out.println(getNumberOfK(data8, 4)); // 0
//
//        // ������ֻ��һ�����֣��ǲ��ҵ�����
//        int[] data9 = {3};
//        System.out.println(getNumberOfK(data9, 3)); // 1

        // ������ֻ��һ�����֣����ǲ��ҵ�����
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
    //�õ���һ��k��λ��(���ֲ���)
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

    //�õ����һ��k��λ��
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
