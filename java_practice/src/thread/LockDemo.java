package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ellen on 2017/6/2.
 */
class ResLock {
    private String name;
    private int count;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    //private Condition condition = lock.newCondition();
    private Condition condition_pro = lock.newCondition();
    private Condition condition_con = lock.newCondition();
    public void set(String name) throws InterruptedException{
        lock.lock();
        try {
            while (flag)
                condition_pro.await();
            this.name = name+"-----"+count++;
            System.out.println(Thread.currentThread().getName() + "...生产者................"+this.name );
            flag = true;
            condition_con.signal();
        } finally {
            lock.unlock();//释放锁的动作一定要执行
        }

    }
    public  void out() throws InterruptedException{
        lock.lock();
        try {
            while (!flag)
                condition_con.await();
            System.out.println(Thread.currentThread().getName() + "...消费者..."+this.name );
            flag = false;
            condition_pro.signalAll();

        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private ResLock res;

    Producer(ResLock res) {
        this.res = res;
    }

    @Override
    public void run()  {
        while (true) {
                try {
                    res.set("++商品++");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

class Consumer implements Runnable {
    private ResLock res;
    Consumer(ResLock res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true)
            try {
                res.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

public class LockDemo {
    public static void main(String[] args) {
        int i=0,j;
        //j=i++;
        j=i++ + i++ + i++ + ++i;
        System.out.println(j);
        System.out.println(i);
        ResLock rl = new ResLock();
        Producer p = new Producer(rl);
        Consumer c = new Consumer(rl);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
