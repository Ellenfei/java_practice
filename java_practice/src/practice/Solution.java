package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ellen on 2017/6/20.
 * 问题：判断一个数是不是2的阶次方
 */
//输入一个整数
class InputData {
    private static String s=null;
    public static void input() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = input.readLine();
        } catch (IOException e) {
            throw new RuntimeException("输入错误！！");
        }
    }
    public static int getInt() {
        input();
        return Integer.parseInt(s);
    }
}

//判断结果
class Result {
    public static void print(int num) {
        if ((num & (num-1))==0)
            System.out.println(num+"是2的阶次方");
        else
            System.out.println(num+"不是2的阶次方");
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
