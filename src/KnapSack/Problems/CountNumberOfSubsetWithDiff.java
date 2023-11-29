package KnapSack.Problems;

public class CountNumberOfSubsetWithDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        System.out.println("Answer : " + solve(arr,diff));
    }

    private static int solve(int[] arr, int diff) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int s1 = (sum + diff)/2;
        int[][] dp = new int[arr.length+1][s1+1];
        for(int i = 0; i <= s1; i++){
            dp[0][i] = 0;
        }
        for(int i = 0; i <= arr.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= s1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][s1];
    }

}
