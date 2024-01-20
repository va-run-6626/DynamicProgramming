package Leetcode;

import java.util.Arrays;
import java.util.Map;

public class P931_MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
        System.out.println("Minimum Falling sum : " + minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        int[][] dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans,solve(0,i,matrix,dp));
        }
        return ans;
    }

    private static int solve(int row, int col, int[][] matrix,int[][] dp) {
       int n = matrix.length;
       if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
       if(row == n-1)
           return dp[row][col] = matrix[row][col];
       int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
       if(col > 0){
           left = solve(row+1,col-1,matrix,dp);
       }
       int straight = solve(row+1,col,matrix,dp);
       if(col < n-1){
           right = solve(row+1,col+1,matrix,dp);
       }
       dp[row][col] = Math.min(left,Math.min(straight,right)) + matrix[row][col];
       return dp[row][col];
    }
}
