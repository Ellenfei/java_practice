package thread;

/**
 * Created by Ellen on 2017/9/20.
 */
public class Demo5 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable...");
            }
        })
        {
            public void run() {
                System.out.println("subThread...");
            }
        }.start();
    }
}
