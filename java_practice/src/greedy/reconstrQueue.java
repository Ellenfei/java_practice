package greedy;

import java.util.*;

/**
 * Created by Ellen on 2017/3/30.
 */
public class reconstrQueue {
    public static void main(String[] args) {
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
    public static int[][] reconstructQueue(int[][] people) {
       // PriorityQueue<int[]> pq = new PriorityQueue<>();
        List<int[]> res = new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /*if (o1[1]==o2[1])
                    return o2[0]-o1[0];
                else
                    return o1[1]-o2[1];*/
                return o1[0]!=o2[0] ? -o1[0]+o2[0] : o1[1]-o2[1];
            }
        });
        System.out.println(Arrays.deepToString(people));
        for (int[] p : people) {
            res.add(p[1],p);
        }
        return res.toArray(new int[people.length][]);

    }
}
