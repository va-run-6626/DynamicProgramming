package UnboundedKnapSack.Problems;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int sum = 5;
        int ans = helper2(coins,sum);
        System.out.println("number of ways : " + helper1(coins,sum));
        System.out.println("number of ways : " + helper2(coins,sum));
    }

    private static int helper2(int[] coins, int sum) {
        int[][] dp = new int[coins.length+1][sum+1];
        for(int i = 0; i <= sum; i++){
            dp[0][i] = 0;
        }
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }

    private static int helper1(int[] coins, int sum) {
        int[][] dp = new int[coins.length+1][sum+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(coins,sum,coins.length,dp);
    }

    private static int solve(int[] coins, int sum, int curr,int[][] dp) {
        if(curr == 0 && sum == 0) return 1;
        if(curr == 0) return 0;

        if(dp[curr][sum] != -1)return dp[curr][sum];
        int ans = solve(coins,sum,curr-1,dp);
        if(coins[curr-1] <= sum){
            ans += solve(coins,sum - coins[curr-1],curr,dp);
        }
        return dp[curr][sum]=ans;
    }
}
