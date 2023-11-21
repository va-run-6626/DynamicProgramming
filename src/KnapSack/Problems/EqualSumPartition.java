package KnapSack.Problems;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(isPossible(nums));
    }
    public static boolean isPossible(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1)return false;
        Boolean[][] dp = new Boolean[nums.length+1][sum/2 +1];

        //memoization
        //return helper(nums,sum/2,nums.length,dp);

        //iteration
        for(int i = 0; i <= sum/2; i++){
            dp[0][i] = false;
        }
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum/2; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum/2];
    }
    public static boolean helper(int[] nums,int sum, int n, Boolean[][] dp){
        if(sum == 0)return true;
        if(n == 0) return false;
        if(dp[n][sum] != null) return dp[n][sum];

        if(nums[n-1] <= sum){
            return dp[n][sum] = helper(nums,sum,n-1,dp) || helper(nums,sum - nums[n-1],n-1,dp);
        }else{
            return dp[n][sum] = helper(nums,sum,n-1,dp);
        }
    }
}
