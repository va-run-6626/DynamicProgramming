package DpOnStrings.Problems;

public class Prog10_SequencePatternMatching {
    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";

        System.out.println("Is Sequence : " + solve(a,b));
    }
    private static boolean solve(String a , String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length();i++){
            for(int j = 0; j <= b.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = getStringBuilder(a, b, dp);
        if(sb.toString().equals(a)){
            return true;
        }
        return false;
    }

    private static StringBuilder getStringBuilder(String a, String b, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int i = a.length();
        int j = b.length();
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                if(sb.isEmpty()){
                    sb.append(a.charAt(i-1));
                }else{
                    sb.insert(0, a.charAt(i-1));
                }
                i--;
                j--;
            }else if(dp[i][j-1] > dp[i-1][j]){
                j--;
            }else{
                i--;
            }
        }
        return sb;
    }
}
