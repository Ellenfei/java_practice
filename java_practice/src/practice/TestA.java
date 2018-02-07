package practice;


/**
 * Created by ye on 2016/10/16.
 */

class Transport{
    public String name;
    public String color;
    public Transport(String name,String color){
        this.name = name;
        this.color = color;
        System.out.println("name:"+name+"  color "+color);
    }

}

class Car extends Transport{
    public Car(){
        super("car ","red");
    }
    public void run(){
        System.out.println("car can run...");
    }
}

class plane extends Transport{
    double money;
    public plane(double money){
        super("plane "," yellow");
        this.money = money;
    }
    public void run(){
        System.out.println("plane can fly...");
    }
}
public class TestA {
    public static void main(String args[]){
        Car car = new Car();
        car.run();
        new plane(5000000).run();
    }

}





