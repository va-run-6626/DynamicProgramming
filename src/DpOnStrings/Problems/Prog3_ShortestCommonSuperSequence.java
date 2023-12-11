package DpOnStrings.Problems;

public class Prog3_ShortestCommonSuperSequence {
    public static void main(String[] args) {
         String a = "geek";
         String b = "eke";
        System.out.println("Shortest Common Super Sequence : "+ helper(a,b));
    }

    private static int helper(String a, String b) {
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
