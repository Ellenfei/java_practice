package jianzhi;

/**
 * Created by Ellen on 2017/12/11.
 * ��ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.�����������We%20are%20happy.����
 */
public class ReplaceBlank3 {
    public static void main(String[] args) {

    }

    /**
    * @param string     Ҫת�����ַ�����
    * @param usedLength �ַ��������Ѿ�ʹ�õĳ���
    * @return ת����ʹ�õ��ַ����ȣ�-1��ʾ����ʧ��
    */

    public static int replaceBlank(char[] string, int usedLength) {
        if (string.length<usedLength) {
            return -1;
        }
        //�ո����
        int count = 0;
        for (int i=0; i<usedLength; i++) {
            if (string[i]==' ') {
                count++;
            }
        }
        //ת�����ַ�����
        int targetLength = 2*count+usedLength;
        //���泤�����ڷ���
        int tmp = targetLength;
        if (targetLength>string.length) {
            return -1;
        }
        usedLength--;
        targetLength--;
        while (usedLength>=0 && usedLength<targetLength) {
            if (string[usedLength]==' ') {
                string[targetLength--] = '%';
                string[targetLength--] = '2';
                string[targetLength--] = '0';
            } else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return tmp;
    }
}
