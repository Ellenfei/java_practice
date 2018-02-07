package practice;

/**
 * Created by ye on 2016/10/18.
 */

abstract class Device{
    private String name;
    public abstract double getPrice();
    public Device(){}
    public Device(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

public class AnonymousInner {
    public void test(Device d){
        System.out.println("buy a "+d.getName()+" cost "+d.getPrice());
    }

    public static void main(String args[]){
        AnonymousInner ai = new AnonymousInner();
        ai.test(new Device() {
            @Override
            public double getPrice() {
                return 68.7;
            }
        });

        ai.test(new Device("phone") {
            {
                System.out.println("匿名内部类的初始化块。。。");
            }
            @Override
            public double getPrice() {
                return 5999;
            }

            public String getName(){
                return "computer";
            }
        });
    }
}
