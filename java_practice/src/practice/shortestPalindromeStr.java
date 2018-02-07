package practice;

/**
 * Created by ye on 2017/2/26.
 */
public class shortestPalindromeStr {
    public static void main(String[] args) {
        System.out.print(shortestPalindrome("ace"));
    }

    public static String shortestPalindrome(String s) {
        //if (s.length()<2 || s==null) return s;
        StringBuilder sb = new StringBuilder(s);
        String s_rev = sb.reverse().toString();
        String res = s+"#"+s_rev;
        int[] next = getNext(res);
        int remove = next[res.length()-1];
       // if (remove == 0) return s_rev.substring(0,s_rev.length()-1-remove)+s;
        return s_rev.substring(0,s_rev.length()-remove)+s;
    }

    public static int[] getNext(String s) {
        int j=1,k=0;
        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;
        while(j < s.length()-1) {
            if (s.charAt(j)==s.charAt(k)) {
                next[j+1] = next[j]+1;
                j++;
                k++;
            } else if(k==0) {
                next[j+1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
