package practice;

/**
 * Created by ye on 2016/10/15.
 */


class root{
    {
        System.out.println("root����ͨ��ʼ�������...");
    }
    static {
        System.out.println("root�ľ�̬��ʼ�������");
    }
    public root(){
        System.out.println("root���޲ι�������ʼ�������");
    }
}

class Mid extends root{
    {
        System.out.println("mid����ͨ��ʼ�������");
    }
    static {
        System.out.println("mid�ľ�̬��ʼ�������");
    }
    public Mid(){
        {
            System.out.println("mid���޲ι�������ʼ�������");
        }
    }
    public Mid(String msg){
        this();
        System.out.println("mid�Ĵ��ι�������ʼ�������,����ֵ��"+msg);
    }
}

class Leaf extends Mid{
    static {
        System.out.println("Leaf�ľ�̬��ʼ�������");
    }
    {
        System.out.println("Leaf����ͨ��ʼ�������");
    }
    public Leaf(){
        super("���java����");
        System.out.println("ִ����Leaf�Ĺ�����");
    }
}

public class Test {
    public static void main(String args[]){
        new Leaf();
       // new Leaf();
    }
}
