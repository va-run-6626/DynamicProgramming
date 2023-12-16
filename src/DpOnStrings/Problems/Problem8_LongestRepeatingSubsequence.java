package DpOnStrings.Problems;

public class Problem8_LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println("Longest Repeating Subsequence : "+helper(s));
    }

    private static int helper(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s.charAt(i-1) == s.charAt(j-1) && i != j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}
