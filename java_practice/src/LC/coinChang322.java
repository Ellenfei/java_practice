package LC;

/**
 * Created by Ellen on 2017/9/21.
 * 动态规划
 */
public class coinChang322 {

    public static void main(String[] args) {
        int[] coins = {3};
        //System.out.println(0x7fffffff);
        System.out.println(coinChange(coins,2));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=1; i<=amount; i++) dp[i] = 0x7ffffffe;//溢出
        for (int coin : coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==0x7ffffffe ? -1 : dp[amount];
    }
}
