package practice;

/**
 * Created by ye on 2016/10/17.
 */
public class AccessStatic {
    static class StaticInner{
        private static int p1 = 5;
        private int p2 = 10;
    }
    public static void main(String args[]){
        System.out.println(StaticInner.p1);
        System.out.println(new StaticInner().p2);
    }
}
