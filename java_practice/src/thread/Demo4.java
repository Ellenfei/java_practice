package thread;

/**
 * Created by Ellen on 2017/6/2.
 */
class Res {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
            this.sex = sex;
            flag = true;
            this.notify();

    }

    public synchronized void out() {
        if (!flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(name + "......" + sex);
        flag = false;
        this.notify();

    }
}

class Input implements Runnable {
        private Res res;

        Input(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int x = 0;
            while (true) {
                if (x == 0)
                    res.set("mile", "man");
                else
                    res.set("ÀöÀö", "Å®Å®Å®");
                x = (x + 1) % 2;
            }
        }
    }

class Output implements Runnable {
    private Res res;
    Output(Res res){
        this.res = res;
    }
        @Override
        public void run() {
            while(true)
             res.out();
        }
}

public class Demo4 {
    public static void main(String[] args) {
        Res r = new Res();
        new Thread(new Input(r)).start();
        new Thread(new Output(r)).start();
    }
}
