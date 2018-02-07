package jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ellen on 2018/2/1.
 * ����һ������ͻ������ڵĴ�С�����ҳ����л�������������ֵ��
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
        //���洰�����ֵ�Ķ���
        Deque<Integer> queue = new LinkedList<>();
        //����δ����
        for (int i=0; i<size; i++) {
            //���������Ӧ��ֵ���ڵ���֮ǰ�洢��������Ӧ��ֵ����ɾ��֮ǰ�洢������ֵ
            while (!queue.isEmpty() && data[i]>=data[queue.getLast()]) {
                queue.removeLast();
            }
            //�������ֵ��Ӧ������
            queue.add(i);
        }
        //��������
        for (int i=size; i<data.length; i++) {
            //�����һ�����ڶ�Ӧ������ֵ
            result.add(queue.getFirst());
            //���������Ӧ��ֵ���ڵ���֮ǰ�洢��������Ӧֵ����ɾ��֮ǰ�洢������ֵ
            while (!queue.isEmpty() && data[i]>=data[queue.getLast()]) {
                queue.removeLast();
            }
            //�ж϶����еĵ�һ������ֵ�Ƿ񻬳����ڣ�������ɾ��
            if (!queue.isEmpty() && queue.getFirst()<=(i-size)) {
                queue.removeFirst();
            }
            //��ӿ��ܵ����ֵ��Ӧ������
            queue.add(i);
        }
        //������һ�����ڵ����ֵ
        result.add(data[queue.getFirst()]);
        return result;
    }
}
