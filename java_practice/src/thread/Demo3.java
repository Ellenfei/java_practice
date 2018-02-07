package thread;

/**
 * Created by Ellen on 2017/6/2.
 */
class Bank {
    private int sum;
    Object obj = new Object();
    public void add(int n) {
        synchronized (obj) {
            sum += n;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sum=" + sum);
        }
    }
    /*
    public void synchronized add(int n) {
            sum += n;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sum=" + sum);
    }
     */
}
class Cus implements Runnable {
    private Bank b = new Bank();
    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            b.add(100);
        }
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Cus c = new Cus();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
