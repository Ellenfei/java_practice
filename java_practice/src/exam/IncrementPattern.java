package exam;

/**
 * Created by Ellen on 2017/5/7.
 */
public class IncrementPattern {
    public static void main(String[] args) {
        incrementPatternPrint(3,4);
    }
    public static void incrementPatternPrint(int start, int n) {
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++)
            System.out.print(start);
            System.out.println();
            start++;
        }
        for(int i=n; i>0; i--) {
            start--;
            for(int j=0; j<i; j++)
                System.out.print(start);
            System.out.println();
        }
    }
}
