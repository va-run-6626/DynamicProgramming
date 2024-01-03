package DpOnStrings.Problems;

public class Prog11_MinimumNumberOfInsertionsToMakePalindrome {
    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println("Min Insertions to make plaindrome : "+ solve(s));
    }
    private static int solve(String s){
        String b = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return s.length() - dp[s.length()][b.length()];
    }
}
