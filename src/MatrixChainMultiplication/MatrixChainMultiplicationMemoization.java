package MatrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        System.out.println("Minimum cost of matrix Chain multiplication is : "+ solve(arr,1,arr.length-1,dp));
    }

    private static int solve(int[] arr, int i, int j,int[][] dp) {
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = solve(arr,i,k,dp)+solve(arr,k+1,j,dp) + arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }
}
