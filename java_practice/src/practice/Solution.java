package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ellen on 2017/6/20.
 * ���⣺�ж�һ�����ǲ���2�Ľ״η�
 */
//����һ������
class InputData {
    private static String s=null;
    public static void input() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = input.readLine();
        } catch (IOException e) {
            throw new RuntimeException("������󣡣�");
        }
    }
    public static int getInt() {
        input();
        return Integer.parseInt(s);
    }
}

//�жϽ��
class Result {
    public static void print(int num) {
        if ((num & (num-1))==0)
            System.out.println(num+"��2�Ľ״η�");
        else
            System.out.println(num+"����2�Ľ״η�");
    }
}
public class Solution {
    public static void main(String[] args) {
        System.out.println("please input an Integer: ");
        int num = InputData.getInt();
        //System.out.println(num);

        Result.print(num);

    }
}
