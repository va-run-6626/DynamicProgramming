package MatrixChainMultiplication.Problems;

import java.util.Arrays;

public class EvaluateExpressionToTrueBooleanParenthesization {
    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println("No of ways yo parenthesization in true = "+solve(s));
    }
    private static int solve(String s){
        //recursion
        //return helper1(s,0,s.length()-1,true);

        //memoization
        int[][][] dp = new int[s.length()+1][s.length()+1][2];
        for(int[][] b : dp){
            for(int[] a : b){
                Arrays.fill(a,-1);
            }
        }
        return helper2(s,0,s.length()-1,true,dp);
    }

    private static int helper2(String s, int i, int j, boolean isTrue, int[][][] dp) {
        if(i > j) return 0;
        if(i==j){
            if(isTrue){
                return s.charAt(i) == 'T'?1:0;
            }else{
                return s.charAt(i) == 'F'?1:0;
            }
        }
        if(isTrue && dp[i][j][1] != -1) return dp[i][j][1];
        if(!isTrue && dp[i][j][0] != -1) return dp[i][j][0];

        int ans = 0;
        int leftTrue, leftFalse , rightTrue, rightFalse;
        for(int k = i+1; k <= j-1; k = k+2){
            if(dp[i][k-1][1] != -1)
                leftTrue = dp[i][k-1][1];
            else
                leftTrue = helper2(s,i,k-1,true,dp);

            if(dp[i][k-1][0] != -1)
                leftFalse = dp[i][k-1][0];
            else
                leftFalse = helper2(s,i,k-1,false,dp);

            if(dp[k+1][j][1] != -1)
                rightTrue = dp[k+1][j][1];
            else
                rightTrue = helper2(s,k+1,j,true,dp);

            if(dp[k+1][j][0] != -1)
                rightFalse = dp[k+1][j][0];
            else
                rightFalse = helper2(s,k+1,j,false,dp);

            if(s.charAt(k) == '&'){
                if(isTrue){
                    ans += (leftTrue * rightTrue);
                }else{
                    ans += (leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }
            }else if(s.charAt(k) == '|'){
                if(isTrue){
                    ans += (leftTrue * rightTrue) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }else{
                    ans += (leftFalse * rightFalse);
                }
            }else if(s.charAt(k) == '^'){
                if(isTrue){
                    ans += (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }else{
                    ans += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }
        return ans;
    }

    private static int helper1(String s, int i, int j, boolean isTrue) {
        if(i > j) return 0;
        if(i==j){
            if(isTrue){
                return s.charAt(i) == 'T'?1:0;
            }else{
                return s.charAt(i) == 'F'?1:0;
            }
        }
        int ans = 0;
        for(int k = i+1; k <= j-1; k = k+2){
            int leftTrue = helper1(s,i,k-1,true);
            int leftFalse = helper1(s,i,k-1,false);
            int rightTrue = helper1(s,k+1,j,true);
            int rightFalse = helper1(s,k+1,j,false);

            if(s.charAt(k) == '&'){
                if(isTrue){
                    ans += leftTrue * rightTrue;
                }else{
                    ans += (leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }
            }else if(s.charAt(k) == '|'){
                if(isTrue){
                    ans += (leftTrue * rightTrue) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }else{
                    ans += (leftFalse * rightFalse);
                }
            }else if(s.charAt(k) == '^'){
                if(isTrue){
                    ans += (leftFalse * rightTrue) + (leftTrue * rightFalse);
                }else{
                    ans += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }
        return ans;
    }
}
