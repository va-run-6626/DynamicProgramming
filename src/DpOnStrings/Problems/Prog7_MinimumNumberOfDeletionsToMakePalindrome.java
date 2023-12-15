package DpOnStrings.Problems;

public class Prog7_MinimumNumberOfDeletionsToMakePalindrome {
    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println("Min number of deletions : " + helper(a));
    }

    private static int helper(String a) {
        String b = new StringBuilder(a).reverse().toString();
        int[][] dp = new int[a.length()+1][a.length()+1];
        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <= b.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return a.length() - dp[a.length()][a.length()];
    }
}
