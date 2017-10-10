package src.test.simplegraph;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Ellen on 2017/10/1.
 * generate loss data
 */
public class LossData {
    //private static final double MAX_LOSS = 50;
    //private static final double EXPERT = 12;

    public static double getNormalDelay (double maxLoss, double expect, double variance) {
        Random random = new Random();
        double result = Math.sqrt(variance)*random.nextGaussian()+expect;
        while (result>maxLoss || result<0) {
            result = Math.sqrt(variance)*random.nextGaussian()+expect;
        }
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double getAllDelay(double maxLoss) {
        Random random = new Random();
        double result = random.nextDouble()*maxLoss;
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
