package DpOnStrings.Problems;

import java.util.Arrays;

public class Prog3_ShortestCommonSuperSequence {
    public static void main(String[] args) {
         String a = "geek";
         String b = "eke";
        System.out.println("Shortest Common Super Sequence using Dp memoization: "+ helper1(a,b));
        System.out.println("Shortest Common Super Sequence using lcs : "+ helper2(a,b));
        System.out.println("Shortest Common Super Sequence using Dp tabulation : "+ helper3(a,b));
    }

    private static int helper3(String a, String b) {
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x+1][y+1];
        for(int i = 0;i <= x; i++){
            for(int j = 0; j <=y; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }

    private static int helper1(String a, String b) {
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x+1][y+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return solve(a,b,x,y,dp);
    }

    private static int solve(String a, String b, int x, int y,int[][] dp) {
        if(x == 0)return y;
        if(y == 0)return x;

        if(dp[x][y] != -1)return dp[x][y];

        if(a.charAt(x-1) == b.charAt(y-1)){
            return dp[x][y] =  1 + solve(a,b,x-1,y-1,dp);
        }else{
            return dp[x][y] = 1 + Math.min(solve(a,b,x-1,y,dp),solve(a,b,x,y-1,dp));
        }
    }

    private static int helper2(String a, String b) {
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x+1][y+1];
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs = dp[x][y];
        return (x+y-lcs);
    }
}
