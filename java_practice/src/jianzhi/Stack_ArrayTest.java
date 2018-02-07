package jianzhi;

/**
 * Created by Ellen on 2018/1/16.
 * 利用数组实现栈
 */
//异常类定义----空栈
class ExceptionStackEmpty extends RuntimeException {
    public ExceptionStackEmpty(String err) {
        super(err);
    }
}
//栈满时添加元素
class ExceptionStackFull extends RuntimeException {
    public ExceptionStackFull(String err) {
        super(err);
    }
}
//栈接口
interface Stack {
    int getSize(); //返回栈中元素数目
    boolean isEmpty(); //判断是否为空
    Object top() throws ExceptionStackEmpty; //取栈顶元素
    void push(Object ele) throws ExceptionStackFull; //入栈
    Object pop() throws ExceptionStackEmpty; //出栈
}
// 借助定长数组实现Stack接口
class Stack_Array implements Stack {
    public static final int CAPACITY = 1024; //数组的默认容量
    protected int capacity; //数组的实际容量
    protected Object[] s; //对象数组
    protected int top = -1; //栈顶元素的位置
    public Stack_Array() {
        this(CAPACITY);
    }
    public Stack_Array(int capacity) {
        this.capacity = capacity;
        s = new Object[capacity];
    }
    @Override
    public int getSize() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top<0;
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty())
            throw new ExceptionStackEmpty("stack is empty!");
        return s[top];
    }

    @Override
    public void push(Object ele) throws ExceptionStackFull{
        if (getSize()==capacity-1) {
            throw new ExceptionStackFull("stack is full!!");
        }
        s[++top] = ele;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        if (isEmpty())
            throw new ExceptionStackEmpty("stack is empty!");
        Object elem = s[top];
        s[top] = null;
        top--;
        return elem;
    }
}
public class Stack_ArrayTest {

}
