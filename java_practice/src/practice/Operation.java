package practice;

/**
 * Created by ye on 2016/10/18.
 */
public enum Operation {
        PLUS{
            public double eval(double x,double y){
                return x+y;
            }
        },
        MINUS{
            public double eval(double x,double y){
                return x-y;
            }
        };

    public abstract double eval(double x,double y);

        public static void main(String args[]){
            System.out.println(Operation.PLUS.eval(3,4));
            System.out.println(Operation.MINUS.eval(7,4));
        }
}
