package MatrixChainMultiplication.Problems;

public class Prog1_PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "abcbd";
        System.out.println("Palindromic partitioning recursive : "+ solve1(s,0,s.length()-1));
        System.out.println("Palindromic partitioning recursive : "+ solve2(s));
    }

    private static int solve2(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                dp[i][j] = -1;
            }
        }
        return helper(s,0,s.length()-1,dp);
    }

    private static int helper(String s, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(isPalindrome(s,i,j)) return 0;

        if(dp[i][j] != -1)return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = helper(s,i,k,dp)+helper(s,k+1,j,dp)+1;
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }

    private static int solve1(String s, int i, int j) {
        if(i >= j) return 0;
        if(isPalindrome(s,i,j)) return 0;

        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = solve1(s,i,k)+solve1(s,k+1,j)+1;
            ans = Math.min(ans,tempAns);
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
