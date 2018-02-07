package practice;

/**
 * Created by ye on 2016/10/17.
 */
public class Cow {
    private double weight;
    public Cow(){}
    public Cow(double weight){
        this.weight = weight;
    }

    private class cowLeg{
        private String color;
        private double length;
        public cowLeg(){}
        public cowLeg(String color,double length){
            this.color = color;
            this.length = length;
        }
        public void  info(){
            System.out.println("cowleg is "+color +" and the length is "+length+" and the weight is "+weight);
        }
    }
    public void test(){
        cowLeg cowleg = new cowLeg("red",10);
        cowleg.info();
    }

    public static void main(String args[]){
        Cow cow = new Cow(500);
        cow.test();
    }
}
