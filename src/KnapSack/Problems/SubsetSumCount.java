package KnapSack.Problems;

public class SubsetSumCount {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;

        int[][] dp = new int[arr.length+1][sum+1];

//      Memoization
//        for(int i = 0; i < dp.length; i++){
//            for(int j = 0; j < dp[0].length; j++){
//                dp[i][j] = -1;
//            }
//        }
//        int count = helper(arr,sum,arr.length,dp);

        for(int i = 0; i <= sum; i++){
            dp[0][i] = 0;
        }
        for(int j = 0; j <= arr.length; j++){
            dp[j][0] = 1;
        }
        for(int i = 1; i <= arr.length; i++){
            for(int j = 0; j <= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[arr.length][sum]);
    }
    public static int helper(int[] arr, int sum, int n,int[][]dp){
        if(sum == 0)return 1;
        if(n == 0)return 0;
        if(dp[n][sum] != -1) return dp[n][sum];

        int count = 0;
        if(arr[n-1] <= sum){
            count += (helper(arr,sum,n-1,dp)+helper(arr,sum-arr[n-1],n-1,dp));
        }else{
            count += helper(arr,sum,n-1,dp);
        }
        dp[n][sum] = count;
        return count;
    }
}
