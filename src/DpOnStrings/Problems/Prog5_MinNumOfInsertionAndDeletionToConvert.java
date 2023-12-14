package DpOnStrings.Problems;

import java.util.Arrays;

public class Prog5_MinNumOfInsertionAndDeletionToConvert {
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        System.out.println("Min # of insertion and deletion Memoization : " + helper1(a,b));
        System.out.println("Min # of insertion and deletion Tabulation: " + helper2(a,b));
    }

    private static int helper2(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <= b.length(); j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    private static int helper1(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int[] as : dp){
            Arrays.fill(as,-1);
        }
        return solve(a,b,0,0,dp);
    }

    private static int solve(String a, String b, int i, int j,int[][] dp) {
        if(i == a.length()) return b.length() - j;
        if(j == b.length()) return a.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] =  solve(a,b,i+1,j+1,dp);
        }
        int insert = solve(a,b,i,j+1,dp);
        int delete = solve(a,b,i+1,j,dp);
        return dp[i][j] = 1+Math.min(insert,delete);
    }


}
