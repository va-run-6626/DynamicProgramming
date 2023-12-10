package DpOnStrings.Problems;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "abcdefg";
        System.out.println("Longest common subsequence : " + helper(s1,s2));
    }

    private static String helper(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i = n; i >= 0;){
            if(check) break;
            for(int j = m; j >= 0;){
                if(dp[i][j] == 0){
                    check = true;
                    break;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    if(sb.isEmpty()) {
                        sb.append(s1.charAt(i-1));
                    }else {
                        sb.insert(0, s1.charAt(i - 1));
                    }
                    i--;
                    j--;
                }else{
                    if(dp[i][j-1] > dp[i-1][j]){
                        j--;
                    }else{
                        i--;
                    }
                }
            }
        }
        return sb.toString();
    }




}
