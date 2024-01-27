package Leetcode;

import java.util.Arrays;

public class P629_KInversePairsArrays {
    private static final int MOD = 1_000_000_000+7;
    private static int[][] dp;
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println("K inverse Pairs Arrays recursive : " + solveRec(n,k));
        System.out.println("K inverse Pairs Arrays Memoization : " + solveMem(n,k));
        System.out.println("K inverse Pairs Arrays Iteration : " + solveItr(n,k));
    }

    private static int solveItr(int n, int k) {
        dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int N = 1; N <= n; N++){
            for(int K = 0; K <= k; K++){
                for(int i = 0;i <= Math.min(K,N-1); i++){
                    dp[N][K] = (dp[N][K] + dp[N-1][K-i])%MOD;
                }
            }
        }
        return dp[n][k];
    }

    private static int solveMem(int n, int k) {
        dp = new int[n+1][k+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return helperMem(n,k,dp);
    }

    private static int helperMem(int n, int k, int[][] dp) {
        if(k <= 0){
            return (k==0)?1:0;
        }
        if(dp[n][k] != -1){
            return dp[n][k];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = (ans +helperMem(n-1,k-i,dp)) % MOD;
        }
        return dp[n][k] = ans;
    }

    private static int solveRec(int n, int k) {
        if(k <= 0){
            return (k == 0) ? 1 : 0;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = (ans +solveRec(n-1,k-i))% MOD;
        }
        return ans;
    }
}
