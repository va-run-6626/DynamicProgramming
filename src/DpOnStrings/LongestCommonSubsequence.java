package DpOnStrings;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcdefgh";
        String s2 = "akbcdhij";
        System.out.println("Longest common subsequence : "+ helper1(s1,s2,s1.length(),s2.length()));
        System.out.println("Longest common subsequence : "+ helper2(s1,s2,s1.length(),s2.length()));
    }

    private static int helper2(String s1, String s2, int i, int j) {
        int[][] dp = new int[i+1][j+1];
        for(int a = 0; a <= i; a++){
            for(int b = 0; b <= j; b++){
                if(a == 0 || b == 0){
                    dp[a][b] = 0;
                }else if(s1.charAt(a-1) == s2.charAt(b-1)){
                    dp[a][b] = 1+dp[a-1][b-1];
                }else{
                    dp[a][b] = Math.max(dp[a-1][b],dp[a][b-1]);
                }
            }
        }
        return dp[i][j];
    }

    private static int helper1(String s1, String s2, int i, int j){
        int[][] dp = new int[i+1][j+1];
        for(int a = 0; a < dp.length; a++){
            for(int b = 0; b < dp[0].length; b++){
                dp[a][b] = -1;
            }
        }
        return solve(s1,s2,i,j,dp);
    }

    private static int solve(String s1, String s2, int i, int j, int[][] dp) {
        if(i == 0 || j == 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return  dp[i][j] = 1 + solve(s1,s2,i-1,j-1,dp);
        }
        int a = solve(s1,s2,i-1,j,dp);
        int b = solve(s1,s2,i,j-1,dp);
        return dp[i][j] = Math.max(a,b);
    }

}
