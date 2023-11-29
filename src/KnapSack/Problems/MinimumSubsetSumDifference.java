package KnapSack.Problems;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1,2,7};
        System.out.println("Minimum subset sum diff : " + solve(arr));
    }
    public static int solve(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(int i= 0; i <= sum; i++){
            dp[0][i] = false;
        }
        for(int i = 0; i <= arr.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum/2; i++){
            if(dp[arr.length][i]){
                min = Math.min(min,sum-(2*i));
            }
        }
        return min;
    }
}
