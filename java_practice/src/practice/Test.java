package practice;

/**
 * Created by ye on 2016/10/15.
 */


class root{
    {
        System.out.println("root的普通初始化代码块...");
    }
    static {
        System.out.println("root的静态初始化代码块");
    }
    public root(){
        System.out.println("root的无参构造器初始化代码块");
    }
}

class Mid extends root{
    {
        System.out.println("mid的普通初始化代码块");
    }
    static {
        System.out.println("mid的静态初始化代码块");
    }
    public Mid(){
        {
            System.out.println("mid的无参构造器初始化代码块");
        }
    }
    public Mid(String msg){
        this();
        System.out.println("mid的带参构造器初始化代码块,参数值："+msg);
    }
}

class Leaf extends Mid{
    static {
        System.out.println("Leaf的静态初始化代码块");
    }
    {
        System.out.println("Leaf的普通初始化代码块");
    }
    public Leaf(){
        super("疯狂java讲义");
        System.out.println("执行了Leaf的构造器");
    }
}

public class Test {
    public static void main(String args[]){
        new Leaf();
       // new Leaf();
    }
}
