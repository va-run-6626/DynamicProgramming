package DpOnStrings.Problems;

public class Prog9_PrintLongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println("Longest Repeating Subsequence : "+ helper(s));
    }

    private static String helper(String s) {
        int l = s.length();
        int[][] dp = new int[l+1][l+1];
        for(int i = 0; i <= l; i++){
            for(int j = 0; j <= l; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s.charAt(i-1) == s.charAt(j-1) && i != j){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = l;
        int j = l;
        while(i > 0 && j > 0){
            if(dp[i][j] == 1 + dp[i-1][j-1]){
                if(sb.isEmpty()){
                    sb.append(s.charAt(i-1));
                }else{
                    sb.insert(0,s.charAt(i-1));
                }
                i--;
                j--;
            }else if(dp[i][j] == dp[i-1][j]){
                i--;
            }else{
                j--;
            }
        }
        return sb.toString();
    }
}