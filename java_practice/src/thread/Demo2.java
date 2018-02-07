package thread;

/**
 * Created by Ellen on 2017/6/1.
 */
class Ticket1 implements Runnable {
    //private String name;
    private  int tick = 30;//四个线程共用一个tick，但是static声明周期长，内存浪费
    Object obj = new Object();
    public void run() {
        while(true) {
            synchronized (obj) {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "sale:" + tick--);
                }
            }
        }
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Ticket1 t = new Ticket1();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
    }
}
