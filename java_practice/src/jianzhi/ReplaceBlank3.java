package jianzhi;

/**
 * Created by Ellen on 2017/12/11.
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
 */
public class ReplaceBlank3 {
    public static void main(String[] args) {

    }

    /**
    * @param string     要转换的字符数组
    * @param usedLength 字符数组中已经使用的长度
    * @return 转换后使用的字符长度，-1表示处理失败
    */

    public static int replaceBlank(char[] string, int usedLength) {
        if (string.length<usedLength) {
            return -1;
        }
        //空格个数
        int count = 0;
        for (int i=0; i<usedLength; i++) {
            if (string[i]==' ') {
                count++;
            }
        }
        //转换后字符长度
        int targetLength = 2*count+usedLength;
        //保存长度用于返回
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
