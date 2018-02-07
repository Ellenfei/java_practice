package practice;

/**
 * Created by ye on 2016/10/17.
 */

abstract class Shape{
    {
        System.out.println("执行Shape的初始化块。。。");
    }

    private String color;
    public abstract double calPerimeter();
    public abstract String getType();
    public Shape(){}
    public Shape(String color){
        System.out.println("执行了Shape的构造器。。。");
        this.color = color;
    }

}

public class Circle extends Shape{
    private double radius;
    public Circle(String  color,double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public double calPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String getType() {
        return "circle";
    }


    public static void main(String args[]){
        Shape s1 = new Circle("RED",2);
        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        //System.out.println(s1.getColor());
    }
}
