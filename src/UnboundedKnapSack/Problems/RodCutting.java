package UnboundedKnapSack.Problems;

public class RodCutting {
    public static void main(String[] args) {
        int[] prices = {1,5,8,9,10,17,17,20};
        int Len = 8;
        int ans = helper2(prices,Len);
        System.out.println("Maximum profit by Unbounded knapsack : "+helper1(prices,Len,prices.length));
        System.out.println("Maximum profit by Unbounded Knapsack Iteration : " +ans);
    }

    private static int helper2(int[] prices, int len) {
        int[][] dp = new int[prices.length+1][len+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(i <= j){
                    dp[i][j] = Math.max(dp[i-1][j] , prices[i-1]+dp[i][j-i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[prices.length][len];
    }

    private static int helper1(int[] prices, int len, int ind) {
        int[][] dp = new int[prices.length+1][len+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(prices,len,ind,dp);
    }

    private static int solve(int[] prices, int len, int i,int[][] dp) {
        if(i == 0 || len == 0){
            return 0;
        }
        if(dp[i][len] != -1) return dp[i][len];
        int notPick = solve(prices,len,i-1,dp);
        int pick = 0;
        if(i <= len){
            pick = prices[i-1] + solve(prices,len - i,i,dp);
        }
        return dp[i][len] =  Math.max(pick,notPick);
    }
}
