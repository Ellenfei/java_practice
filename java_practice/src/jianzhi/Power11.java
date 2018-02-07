package jianzhi;

/**
 * Created by Ellen on 2017/12/18.
 */
public class Power11 {

    public static void main(String[] args) {
        int base = 3;
        int expoent = 2;
        System.out.println(power(base, expoent));
    }

    public static double power(int base, int exponent) {
        if (base==0 && exponent<=0) {
            throw new RuntimeException("Invalid input!");
        }

        if (exponent==0) {
            return 1;
        }
        int exp = exponent;
        if (exponent<0) {
            exp = -exponent;
        }
        double result = powerUnsign(base, exp);
        if (exponent<0) {
            result = 1/result;
        }
        return result;
    }

    public static double powerUnsign(int base, int exponent) {
        if (exponent==0) {
            return 1;
        }
        if (exponent==1) {
            return base;
        }
        double res = powerUnsign(base, exponent>>1);
        res *= res;
        if ((exponent & 0x1) == 1) {
            res = res*base;
        }
        return res;
    }
}
