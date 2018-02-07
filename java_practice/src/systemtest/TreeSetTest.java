package systemtest;

import java.util.TreeSet;

/**
 * Created by ye on 2016/11/26.
 */

class R implements Comparable {
    int count;
    public R (int count) {
        this.count = count;
    }

    public String toString () {
        return "R[count:"+ count +"]";
    }

    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass()==R.class) {
            R r = (R)obj;
            return r.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object obj) {
        R r = (R)obj;
        return count>r.count ? 1 : count<r.count ? -1 :0;
    }
}

public class TreeSetTest {
    public static void main (String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new R(5));
        ts.add(new R(-3));
        ts.add(new R(9));
        ts.add(new R(-2));
        System.out.println(ts);
        R first = (R)ts.first();
        first.count = 20;
        R last = (R)ts.last();
        last.count = -2;
        System.out.println(ts);
        System.out.println(ts.remove(new R(-2)));
        System.out.println(ts);
        System.out.println(ts.remove(new R(5)));
        System.out.println(ts);
    }
}
