package jianzhi;

import java.util.Queue;

/**
 * Created by Ellen on 2018/1/16.
 * 利用数组实现栈
 */
public class Queue_Array {
    public static final int CAPACITY = 1000; // 数组的默认容量

    protected int capacity; // 数组的实际容量
    protected Object[] Q; // 对象数组

    protected  int f = 0; //队首元素的位置
    protected int r = 0; // 队尾元素的位置

    //构造方法
    public Queue_Array() {
        this(CAPACITY);
    }
    //根据指定容量创建对象
    public Queue_Array(int capacity) {
        this.capacity = capacity;
        Q = new Object[capacity];
    }
    //查询当前队列的规模
    public int getSize() {
        return (capacity-f+r)%capacity;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return f==r;
    }
    //入队
    public void enqueue(Object obj) throws Exception {
        if (getSize()==capacity-1)
            throw new Exception("queue overflow");
        Q[r] = obj;
        r = (r+1) % capacity;
    }
    //出队
    public Object dequeue() throws Exception{
        if (isEmpty()) {
            throw new Exception("queue is empty!");
        }
        Object elem = Q[f];
        Q[f] = null;
        f = (f+1)%capacity;
        return elem;
    }
    //取出元素
    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty!");
        }
        return Q[f];
    }
}
//双向链表

//利用双向链表实现队列
class Queue_LinkedList {

}
