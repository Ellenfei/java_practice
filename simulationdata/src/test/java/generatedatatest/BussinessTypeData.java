package generatedatatest;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Ellen on 2017/10/10.
 */
public class BussinessTypeData {
    private static final int NORMAL_TYPE_NUM = 4;
    private static final String[] BUSSINESS = {"视频电话会议", "电子商务", "流媒体", "电子邮件/文件传输"};
    private static final int ALL_TYPE_NUM = 10;
    private static HashMap<Integer, String> map = null;
    //generate normal bussiness
    public static int getNormalBussiness() {
        //HashMap result = new HashMap();
        for (int i=0; i<NORMAL_TYPE_NUM; i++) {
            map.put(i+1, BUSSINESS[i]);
        }

        Random random  = new Random();
        int type = random.nextInt()*NORMAL_TYPE_NUM;
        return type;
    }
    //generate all bussiness
    public static int getAllBussiness() {

        Random random  = new Random();
        int type = random.nextInt()*ALL_TYPE_NUM;
        return type;
    }
}
