package jianzhi;

import java.util.Queue;

/**
 * Created by Ellen on 2018/1/16.
 * ��������ʵ��ջ
 */
public class Queue_Array {
    public static final int CAPACITY = 1000; // �����Ĭ������

    protected int capacity; // �����ʵ������
    protected Object[] Q; // ��������

    protected  int f = 0; //����Ԫ�ص�λ��
    protected int r = 0; // ��βԪ�ص�λ��

    //���췽��
    public Queue_Array() {
        this(CAPACITY);
    }
    //����ָ��������������
    public Queue_Array(int capacity) {
        this.capacity = capacity;
        Q = new Object[capacity];
    }
    //��ѯ��ǰ���еĹ�ģ
    public int getSize() {
        return (capacity-f+r)%capacity;
    }
    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return f==r;
    }
    //���
    public void enqueue(Object obj) throws Exception {
        if (getSize()==capacity-1)
            throw new Exception("queue overflow");
        Q[r] = obj;
        r = (r+1) % capacity;
    }
    //����
    public Object dequeue() throws Exception{
        if (isEmpty()) {
            throw new Exception("queue is empty!");
        }
        Object elem = Q[f];
        Q[f] = null;
        f = (f+1)%capacity;
        return elem;
    }
    //ȡ��Ԫ��
    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty!");
        }
        return Q[f];
    }
}
//˫������

//����˫������ʵ�ֶ���
class Queue_LinkedList {

}
