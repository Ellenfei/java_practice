package mathtest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Created by ye on 2017/3/13.
 */
public class heaters {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        System.out.print(findRadius(houses,heaters));
    }
    public static int findRadius(int[] houses, int[] heaters) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters,house);
            if (index < 0) {
                index = -(index+1);
            }
            int distL = index-1>=0 ? house-heaters[index-1] : Integer.MAX_VALUE;
            int distR = index<heaters.length ? heaters[index]-house : Integer.MAX_VALUE;
            res = Math.max(res,Math.min(distL,distR));
        }
        return res;
    }
}
