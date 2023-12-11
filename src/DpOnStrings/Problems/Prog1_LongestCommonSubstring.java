package DpOnStrings.Problems;

import java.util.Arrays;

public class Prog1_LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println("longest Common substring : " + helper1(s1,s2));
        System.out.println("longest Common substring : " + helper2(s1,s2));
    }

    private static int helper2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    private static int helper1(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][][] dp = new int[len1+1][len2+1][Math.min(len2,len1)];
        for(int[][] a : dp){
            for(int[] b: a){
                Arrays.fill(b,-1);
            }
        }
        return solve(s1,s2,len1,len2,0,dp);
    }

    private static int solve(String s1, String s2, int i, int j, int res,int[][][]dp) {
        if(i == 0 || j == 0){
            return res;
        }
        int resAssign = res;
        if(dp[i][j][res] != -1) return dp[i][j][res];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            res = solve(s1,s2,i-1,j-1,res+1,dp);
        }
        res = Math.max(res,Math.max(solve(s1,s2,i-1,j,0,dp),solve(s1,s2,i,j-1,0,dp)));
        return dp[i][j][resAssign] = res;
    }
}
