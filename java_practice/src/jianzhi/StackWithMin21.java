package jianzhi;

import java.util.Stack;

/**
 * Created by Ellen on 2017/12/27.
 */

class MinStack<T extends Comparable<T>> {
    private Stack<T> dataStack;
    private Stack<T> minStack;
    public MinStack() {
        this.dataStack = new Stack();
        this.minStack = new Stack();
    }
    public void push(T t) {
        dataStack.push(t);
        if (minStack.isEmpty()) {
           // dataStack.push(t);
            minStack.push(t);
        } else {
            if (minStack.peek().compareTo(t)>0) {
                minStack.push(t);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    public T pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("empty");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public T minT() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return minStack.peek();
    }
}

public class StackWithMin21 {
    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack();
        stack.push(3);
        stack.push(4);
        System.out.println(stack.minT());
        stack.push(2);
        stack.push(1);
        System.out.println(stack.minT());
        stack.pop();
        System.out.println(stack.minT());
    }
}
