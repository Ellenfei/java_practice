package jianzhi;

/**
 * Created by Ellen on 2018/1/16.
 * ��������ʵ��ջ
 */
//�쳣�ඨ��----��ջ
class ExceptionStackEmpty extends RuntimeException {
    public ExceptionStackEmpty(String err) {
        super(err);
    }
}
//ջ��ʱ���Ԫ��
class ExceptionStackFull extends RuntimeException {
    public ExceptionStackFull(String err) {
        super(err);
    }
}
//ջ�ӿ�
interface Stack {
    int getSize(); //����ջ��Ԫ����Ŀ
    boolean isEmpty(); //�ж��Ƿ�Ϊ��
    Object top() throws ExceptionStackEmpty; //ȡջ��Ԫ��
    void push(Object ele) throws ExceptionStackFull; //��ջ
    Object pop() throws ExceptionStackEmpty; //��ջ
}
// ������������ʵ��Stack�ӿ�
class Stack_Array implements Stack {
    public static final int CAPACITY = 1024; //�����Ĭ������
    protected int capacity; //�����ʵ������
    protected Object[] s; //��������
    protected int top = -1; //ջ��Ԫ�ص�λ��
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
