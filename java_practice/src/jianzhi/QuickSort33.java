package jianzhi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ellen on 2018/1/8.
 */
class MComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1==null || o2==null) {
            throw new IllegalArgumentException("arg should not be null");
        }
        String s1 = o1+o2;
        String s2 = o2+o1;
        return s1.compareTo(s2);
    }
}
public class QuickSort33 {
    public static void main(String[] args) {
        String[] array = {"3", "312", "32"};
        System.out.print(printMinNumber(array));
    }
    public static void quickSort(String[] array, int start, int end, Comparator<String> comparator) {
        if (start<end) {
            String privot = array[start];
            int left = start;
            int right = end;
            while (start<end) {
                while (start<end && comparator.compare(array[end], privot)>=0) {
                    end--;
                }
                array[start] = array[end];
                while (start<end && comparator.compare(array[start], privot)<=0) {
                    start++;
                }
                array[end] = array[start];
            }
            array[start] = privot;
            quickSort(array, left, start-1, comparator);
            quickSort(array, start+1, right, comparator);
        }

    }
    public static String printMinNumber(String[] array) {
        MComparator comparator = new MComparator();
        quickSort(array, 0, array.length-1, comparator);
        System.out.println(Arrays.toString(array));
        StringBuilder sb = new StringBuilder();
        for (String s: array) {
            sb.append(s);
        }
        return sb.toString();
    }
}
