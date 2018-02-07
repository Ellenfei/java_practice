package thread;

/**
 * Created by Ellen on 2017/6/1.
 */
class Ticket extends Thread {
    //private String name;
    private static int tick = 10;//四个线程共用一个tick，但是static声明周期长，内存浪费
    Ticket (String name) {
        super(name);
    }
    public void run() {
        while(true) {
            if (tick>0) {
                System.out.println(this.getName() +"sale:"+tick--);
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("窗口1");
        Ticket t2 = new Ticket("窗口2");
        Ticket t3 = new Ticket("窗口3");
        Ticket t4 = new Ticket("窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
