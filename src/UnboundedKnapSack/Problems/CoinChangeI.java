package UnboundedKnapSack.Problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeI {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Minimum coins required : " + helper1(coins,amount));
        System.out.println("Minimum coins required : " + helper2(coins,amount));
    }
    private static int helper1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans =  solve(coins,amount,dp);
        return (ans == Integer.MAX_VALUE) ? -1: ans;
    }
    private static int helper2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    private static int solve(int[] coins, int amount,int[] dp) {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(dp[amount] != -1) return dp[amount];

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = solve(coins, amount - coin,dp);
            if (ans != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, 1 + ans);
            }
        }
        return dp[amount] =  minCount;
    }


}
