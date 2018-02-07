package jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2018/1/16.
 * ���ö���ʵ�֡�����ɽ����Ϸ
 */
public class Josephus {
    public static void main(String[] args) {
        String[] s = {"Alice", "Bob", "Cindy", "Doug", "Ed",
                "Fred", "Gene", "Hope", "Irene", "Jack",
                "Kim", "Lance", "Mike", "Nancy", "Ollie"};
//        System.out.println(buildQueue(s));
        System.out.println(Jose(buildQueue(s), 5));
    }
    //���ö���ģ��Josephus��
    public static Object Jose(Queue queue, int k) {
        if (queue.isEmpty()) {
            return null;
        }
        while (queue.size()>1) {
            traversal(queue);
            for (int i=0; i<k; i++) {
                queue.offer(queue.poll());
            }
            Object o = queue.poll();
            System.out.println(o+"�˳���");
        }
        //���ʣ�µĺ���
        return queue.poll();
    }
    //��һ�������֯Ϊһ������
    public static Queue buildQueue(Object[] arr) {
        Queue<Object> queue = new LinkedList<>();
        for (Object o : arr) {
            queue.add(o);
        }
        return queue;
    }
    //��������
    public static void traversal(Queue queue) {
       System.out.println(queue);
    }
}
