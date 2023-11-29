package UnboundedKnapSack;

import jdk.swing.interop.LightweightContentWrapper;

public class UnboundedKanpSackMemoization {
    public static void main(String[] args) {
        int[]wt = {1,2,3};
        int[]val = {4,5,6};
        int Weight = 20;

        System.out.println("Maximum profit : " + solve(wt,val,Weight));
    }

    private static int solve(int[] wt, int[] val, int weight) {
        int[][] dp = new int[wt.length+1][weight+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(wt,val,weight,wt.length,dp);
    }

    private static int helper(int[] wt, int[] val, int weight, int i,int[][] dp) {
        if(weight == 0 || i == 0){
            return 0;
        }
        if(dp[i][weight] != -1) return dp[i][weight];
        int notPick = helper(wt,val,weight,i-1,dp);
        int pick = 0;
        if(wt[i-1] <= weight){
            pick = val[i-1] + helper(wt,val,weight-wt[i-1],i,dp);
        }
        return dp[i][weight] = Math.max(notPick,pick);
    }
}
