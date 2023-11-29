package UnboundedKnapSack;

public class UnboundedKnapSackIteration {
    public static void main(String[] args) {
        int[]wt = {1,2,3};
        int[]val = {4,5,6};
        int Weight = 20;

        System.out.println("Maximum profit : " + solve(wt,val,Weight));
    }

    private static int solve(int[] wt, int[] val, int weight) {
        int[][] dp = new int[wt.length+1][weight+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }else if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j] , val[i-1]+dp[i][j-wt[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length][weight];
    }
}
