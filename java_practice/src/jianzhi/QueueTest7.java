package jianzhi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ellen on 2017/12/14.
 * 用两个栈实现一个队列
 */
class MyQueue<T> {
    private Stack<T> stack1 = new Stack<>(); //存放加入新的元素
    private Stack<T> stack2 = new Stack<>(); //辅助删除
    public MyQueue () {

    }
    //添加
    public void appendTail(T t) {
        stack1.add(t);
    }
    //删除
    public T deleteHead () {
        if (stack2.isEmpty()) {
             while (!stack1.isEmpty()) {
                 stack2.add(stack1.pop());
             }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("no element");
        }
        return stack2.pop();
    }

}

class MyStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();
    public MyStack () {}
    //添加
    public void myPush(T t) {
//        if (queue2.isEmpty() && !queue1.isEmpty()) {
//            queue2.add(t);
//        }
        queue1.add(t);
    }
    //删除
    public T myPop () {
        if (queue1.size()>1) {
            while(queue1.size()>1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("no element");
        } else if (queue1.isEmpty() && !queue2.isEmpty()) {
            while(queue2.size()>1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        return queue1.poll();
    }
}

public class QueueTest7 {
    public static void main(String[] args) {
//        MyQueue<Integer> q = new MyQueue<>();
//        q.appendTail(1);
//        q.appendTail(2);
//        System.out.print(q.deleteHead());

        MyStack<Integer> s = new MyStack<>();
        s.myPush(2);
        s.myPush(3);
        System.out.println(s.myPop());
        System.out.println(s.myPop());
        s.myPush(4);
        s.myPush(5);
        s.myPush(6);
        System.out.println(s.myPop());
        System.out.println(s.myPop());
        System.out.println(s.myPop());
        s.myPush(7);
        System.out.println(s.myPop());
    }
}
