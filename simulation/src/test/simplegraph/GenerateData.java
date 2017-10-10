package src.test.simplegraph;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * Created by Ellen on 2017/9/27.
 */
public class GenerateData {
    //����
    private static final double BAND_EXPERT = 15;
    private static final double BAND_VARIANCE = 3;
    //��Ƶ����ʱ��Ҫ��
    private static final double VIEO_MAX_DELAY = 50;
    private static final double VIEO_DELAY_EXPERT = 12;
    private static final double VIEO_DELAY_VARIANCE = 1.5;
    //��������ʱ��Ҫ��
    private static final double E_MAX_DELAY = 200;
    private static final double E_DELAY_EXPERT = 60;
    private static final double E_DELAY_VARIANCE = 1.5;
    //��ý��ʱ��Ҫ��
    private static final double MEDIA_MAX_DELAY = 1;
    private static final double MEDIA_DELAY_EXPERT = 0.5;
    private static final double MEDIA_DELAY_VARIANCE = 1.5;
    //�����ʼ���ʱ��Ҫ��
    //������
    private static final double MAX_LOSS_ABNORMAL = 0.3;
    private static final double MAX_LOSS = 0.1;
    private static final double LOSS_EXPERT = 0.6;
    private static final double LOSS_VARIANCE = 0.25;
    public static void main(String[] args) {
        GenerateData.getVideoTrainData();
    }

    //the video training data
    public static void getVideoTrainData() {
        File trainFile = new File("video_train_in.data");
        File trainOutFile = new File("video_train_out.data");
        FileOutputStream out = null;
        FileOutputStream out1 = null;
        try {
            out = new FileOutputStream(trainFile);
            out1 = new FileOutputStream(trainOutFile);
            //List<Integer> data = SimpleGraphD.getPartDistance();
            for (int i=0; i<100; i++) {
                List<Vertex> dataS = SDVertexData.getPartSVertex();
                List<Vertex> dataD = SDVertexData.getPartDVertex();
                //����
                double normalBW = BandwidthData.getNormalBW(BAND_EXPERT, BAND_VARIANCE);
                //ʱ��
                double normalVideoDelay = DelayData.getNormalDelay(VIEO_MAX_DELAY, VIEO_DELAY_EXPERT, VIEO_DELAY_VARIANCE);
                // generate a random for index of data
                //������
                double normalLoss = LossData.getNormalDelay(MAX_LOSS, LOSS_EXPERT, LOSS_VARIANCE);
                Random random = new Random();
                int indexS, indexD;
                //��Ƶ����ѵ����������
                indexS = random.nextInt(dataS.size());
                indexD = random.nextInt(dataD.size());
                //System.out.println(dataS.get(indexS).getId());
                //buffer.writeInt(data.get(index));
                //Դ�ڵ�
                out.write(String.valueOf(dataS.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataD.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(normalBW).getBytes());
                out.write("\t".getBytes());
                //��Ƶ����ʱ��
                out.write(String.valueOf(normalVideoDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(normalLoss).getBytes());
                out.write("\r\n".getBytes());
                out.flush();
                //out.write("\t".getBytes());
                //���
                out1.write(String.valueOf(1).getBytes());
                out1.write("\r\n".getBytes());
                out1.flush();


            }
            //��Ƶ����ѵ���쳣����
            for (int i=0; i<100; i++) {
                List<Vertex> dataSAll = SDVertexData.getAllSVertex();
                List<Vertex> dataDAll = SDVertexData.getAllDVertex();
                //����
                double abnormalBW = BandwidthData.getAllBW();
                //ʱ��
                double abnormalVideoDelay = DelayData.getAllDelay(VIEO_MAX_DELAY);
                // generate a random for index of data
                //������
                double abnormalLoss = LossData.getAllDelay(MAX_LOSS_ABNORMAL);
                Random random = new Random();
                int indexS, indexD;
                indexS = random.nextInt(dataSAll.size());
                indexD = random.nextInt(dataDAll.size());
                //System.out.println(dataSAll.get(indexS).getId());
                //buffer.writeInt(data.get(index));
                //Դ�ڵ�
                out.write(String.valueOf(dataSAll.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataDAll.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(abnormalBW).getBytes());
                out.write("\t".getBytes());
                //��Ƶ����ʱ��
                out.write(String.valueOf(abnormalVideoDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(abnormalLoss).getBytes());
                out.write("\r\n".getBytes());
                out.flush();
                //out.write("\t".getBytes());
                //���
                out1.write(String.valueOf(0).getBytes());
                out1.write("\r\n".getBytes());
                out1.flush();


            }

        } catch (IOException e) {
            System.out.println("д���ļ�����");
        } finally {
            try {
                if (out!=null) {
                    out.close();
                } else {}
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //the E-mail training data
    public static void getETrainData() {
        File trainFile = new File("e_train.data");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(trainFile);
            for (int i=0; i<10; i++) { //List<Integer> data = SimpleGraphD.getPartDistance();
                List<Vertex> dataS = SDVertexData.getPartSVertex();
                List<Vertex> dataD = SDVertexData.getPartDVertex();
                //����
                double normalBW = BandwidthData.getNormalBW(BAND_EXPERT, BAND_VARIANCE);
                double abnormalBW = BandwidthData.getAllBW();
                //ʱ��
                double normalEDelay = DelayData.getNormalDelay(E_MAX_DELAY, E_DELAY_EXPERT, E_DELAY_VARIANCE);
                double abnormalEDelay = DelayData.getAllDelay(E_MAX_DELAY);
                // generate a random for index of data
                //������
                double normalLoss = LossData.getNormalDelay(MAX_LOSS, LOSS_EXPERT, LOSS_VARIANCE);
                double abnormalLoss = LossData.getAllDelay(MAX_LOSS);
                Random random = new Random();
                int indexS, indexD;
                //��������
                indexS = random.nextInt(dataS.size());
                indexD = random.nextInt(dataD.size());
                //System.out.println(dataS.get(indexS).getId());
                //Դ�ڵ�
                out.write(String.valueOf(dataS.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataD.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(normalBW).getBytes());
                //ʱ��
                out.write(String.valueOf(normalEDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(normalLoss).getBytes());
                out.write("\t".getBytes());
                out.write(String.valueOf(1).getBytes());
                out.write("\r\n".getBytes());
                out.flush();

            }
            //�쳣����
            for (int i=0; i<10; i++) {
                List<Vertex> dataSAll = SDVertexData.getAllSVertex();
                List<Vertex> dataDAll = SDVertexData.getAllDVertex();
                //����
                double abnormalBW = BandwidthData.getAllBW();
                //ʱ��
                double abnormalEDelay = DelayData.getAllDelay(E_MAX_DELAY);
                // generate a random for index of data
                //������
                double abnormalLoss = LossData.getAllDelay(MAX_LOSS);
                Random random = new Random();
                int indexS, indexD;
                indexS = random.nextInt(dataSAll.size());
                indexD = random.nextInt(dataDAll.size());
                //System.out.println(dataSAll.get(indexS).getId());
                //Դ�ڵ�
                out.write(String.valueOf(dataSAll.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataDAll.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(abnormalBW).getBytes());
                out.write("\t".getBytes());
                //ʱ��
                out.write(String.valueOf(abnormalEDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(abnormalLoss).getBytes());
                out.write("\t".getBytes());
                out.write(String.valueOf(0).getBytes());
                out.write("\r\n".getBytes());
                out.flush();
            }

        } catch (IOException e) {
            System.out.println("д���ļ�����");
        } finally {
            try {
                if (out!=null) {
                    out.close();
                } else {}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //the media training data
    public static void getMediaTrainData() {
        File trainFile = new File("media_train.data");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(trainFile);
            //List<Integer> data = SimpleGraphD.getPartDistance();
            //��������
            for (int i=0; i<10; i++) {
                List<Vertex> dataS = SDVertexData.getPartSVertex();
                List<Vertex> dataD = SDVertexData.getPartDVertex();
                //����
                double normalBW = BandwidthData.getNormalBW(BAND_EXPERT, BAND_VARIANCE);
                //ʱ��
                double normalMediaDelay = DelayData.getNormalDelay(MEDIA_MAX_DELAY, MEDIA_DELAY_EXPERT, MEDIA_DELAY_VARIANCE);
                // generate a random for index of data
                //������
                double normalLoss = LossData.getNormalDelay(MAX_LOSS, LOSS_EXPERT, LOSS_VARIANCE);
                Random random = new Random();
                int indexS, indexD;

                indexS = random.nextInt(dataS.size());
                indexD = random.nextInt(dataD.size());
                //System.out.println(dataS.get(indexS).getId());
                //Դ�ڵ�
                out.write(String.valueOf(dataS.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataD.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(normalBW).getBytes());
                out.write("\t".getBytes());
                //ʱ��
                out.write(String.valueOf(normalMediaDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(normalLoss).getBytes());
                out.write("\t".getBytes());
                out.write(String.valueOf(1).getBytes());
                out.write("\r\n".getBytes());
                out.flush();

            }
            //�쳣����
            for (int i=0; i<10; i++) {
                List<Vertex> dataSAll = SDVertexData.getAllSVertex();
                List<Vertex> dataDAll = SDVertexData.getAllDVertex();
                //����
                double abnormalBW = BandwidthData.getAllBW();
                //ʱ��
                double abnormalMediaDelay = DelayData.getAllDelay(MEDIA_MAX_DELAY);
                // generate a random for index of data
                //������
                double abnormalLoss = LossData.getAllDelay(MAX_LOSS_ABNORMAL);
                Random random = new Random();
                int indexS, indexD;
                indexS = random.nextInt(dataSAll.size());
                indexD = random.nextInt(dataDAll.size());
                //System.out.println(dataSAll.get(indexS).getId());
                //Դ�ڵ�
                out.write(String.valueOf(dataSAll.get(indexS).getId()).getBytes());
                out.write("\t".getBytes());
                //�޽ڵ�
                out.write(String.valueOf(dataDAll.get(indexD).getId()).getBytes());
                out.write("\t".getBytes());
                //����
                out.write(String.valueOf(abnormalBW).getBytes());
                out.write("\t".getBytes());
                //ʱ��
                out.write(String.valueOf(abnormalMediaDelay).getBytes());
                out.write("\t".getBytes());
                //������
                out.write(String.valueOf(abnormalLoss).getBytes());
                out.write("\t".getBytes());
                out.write(String.valueOf(0).getBytes());
                out.write("\r\n".getBytes());
                out.flush();
            }

        } catch (IOException e) {
            System.out.println("д���ļ�����");
        } finally {
            try {
                if (out!=null) {
                    out.close();
                } else {}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
