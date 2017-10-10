package generatedatatest;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Ellen on 2017/10/10.
 * generate delay data
 */
public class DelayData {
    public static double getNormalDelay (double maxDelay, double expect, double variance) {
        Random random = new Random();
        double result = Math.sqrt(variance)*random.nextGaussian()+expect;
        while (result>maxDelay) {
            result = Math.sqrt(variance)*random.nextGaussian()+expect;
        }
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double getAllDelay(double maxDelay) {
        Random random = new Random();
        double result = random.nextDouble()*maxDelay;
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
