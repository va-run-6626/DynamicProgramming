package DpOnStrings.Problems;

import java.sql.SQLOutput;

public class Prog4_PrintingShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";

        System.out.println("Shortest Common supersequence : " + helper(a,b));
    }

    private static String helper(String a, String b) {
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x+1][y+1];
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = x;
        int j = y;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                if(sb.isEmpty()){
                    sb.append(a.charAt(i-1));
                }else{
                    sb.insert(0,a.charAt(i-1));
                }
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                if(sb.isEmpty()){
                    sb.append(b.charAt(j-1));
                }else{
                    sb.insert(0,b.charAt(j-1));
                }
                j--;
            }else{
                if(sb.isEmpty()){
                    sb.append(a.charAt(i-1));
                }else{
                    sb.insert(0,a.charAt(i-1));
                }
                i--;
            }
        }
        while (i > 0){
            sb.insert(0,a.charAt(i-1));
            i--;
        }
        while (j > 0){
            sb.insert(0,b.charAt(j-1));
            j--;
        }
        return sb.toString();
    }
}
