package jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ellen on 2018/2/1.
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 */
public class MaxWindows64 {
    public static void main(String[] args) {
        int[] data = {2,3,4,2,6,2,5,1};
        System.out.print(maxInWindows(data, 3));
    }
    public static List<Integer> maxInWindows(int[] data, int size) {
        List<Integer> result = new LinkedList<>();
        if (data==null || size<1 || data.length<1 || size>data.length) {
            return result;
        }
        //保存窗口最大值的队列
        Deque<Integer> queue = new LinkedList<>();
        //窗口未填满
        for (int i=0; i<size; i++) {
            //如果索引对应的值大于等于之前存储的索引对应的值，则删除之前存储的索引值
            while (!queue.isEmpty() && data[i]>=data[queue.getLast()]) {
                queue.removeLast();
            }
            //保存最大值对应的索引
            queue.add(i);
        }
        //窗口填满
        for (int i=size; i<data.length; i++) {
            //保存第一个窗口对应的索引值
            result.add(queue.getFirst());
            //如果索引对应的值大于等于之前存储的索引对应值，则删除之前存储的索引值
            while (!queue.isEmpty() && data[i]>=data[queue.getLast()]) {
                queue.removeLast();
            }
            //判断队列中的第一个索引值是否滑出窗口，滑出则删除
            if (!queue.isEmpty() && queue.getFirst()<=(i-size)) {
                queue.removeFirst();
            }
            //添加可能的最大值对应的索引
            queue.add(i);
        }
        //添加最后一个窗口的最大值
        result.add(data[queue.getFirst()]);
        return result;
    }
}
