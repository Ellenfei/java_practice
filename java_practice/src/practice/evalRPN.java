package practice;

import java.util.Stack;

/**
 * Created by ye on 2017/3/2.
 */
public class evalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.print(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        /*//int len = tokens.length;
       // if (tokens.length <)
        if (tokens.length==1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<Integer>();

        for (String s : tokens) {
            if (s.equals("+") ) {
                stack.push(stack.pop() + stack.pop());

            } else if (s.equals("-") ) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            }else if (s.equals("/") ) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();*/

        int[] res = new int[tokens.length/2+1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    res[index-2] = res[index-2] + res[index-1];
                    index--;
                    break;
                case "-" :
                    res[index-2] = res[index-2] - res[index-1];
                    index--;
                    break;
                case "*" :
                    res[index-2] = res[index-2] * res[index-1];
                    index--;
                    break;
                case "/" :
                    res[index-2] = res[index-2] / res[index-1];
                    index--;
                    break;
                default:
                    res[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return res[0];
    }
}
