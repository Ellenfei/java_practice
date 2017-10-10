package generatedatatest;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Ellen on 2017/9/28.
 * 1.产生业务请求带宽（正常请求）,服从高斯分布
 * 2.产生所有业务带宽（正常+异常）
 */
public class BandwidthData {
    private static final double BW_MAX = 100;
    private static final double BW_MIN = 100/80;
    private static final double PI = 3.1415;
    private static final double E = 2.7182;

    //normal bandwidth
    public static double getNormalBW(double expect, double variance) {
        Random random = new Random();
        double result = Math.sqrt(variance)*random.nextGaussian()+expect;
        //while (result % BW_MIN != 0 || result>100) {
        //result = Math.sqrt(variance)*random.nextGaussian()+expect;
        //}
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double getAllBW() {
        Random random = new Random();
        double result = random.nextDouble()*100;
        BigDecimal bg = new BigDecimal(result);
        return bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
