package greedy;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ellen on 2017/3/28.
 */
public class minArrow {
    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,2},
                {3,8}
        };
        //Arrays.sort(points);
        System.out.print(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length==0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(points));
        int minArrows=1;
        int end = points[0][1];
        for (int i=1; i<points.length; i++) {
            int[] point = points[i];
            if (point[0]<=end) {
                end = Math.min(end,point[1]);
            } else {
                minArrows++;
                end = point[1];
            }
        }
        return minArrows;
    }
}
