package jianzhi;

import java.util.Stack;

/**
 * Created by Ellen on 2017/12/28.
 */
public class IsPopOrder22 {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
    }
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push==null || pop==null || push.length==0 || pop.length==0 || push.length!=pop.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex<pop.length) {
            while (pushIndex<push.length && (stack.isEmpty() || stack.peek()!=pop[popIndex])) {
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            if (popIndex<pop.length && stack.peek()==pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
