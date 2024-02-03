package Leetcode;

public class P1043_PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println("Partition Array For Maximum Sum : " + new Solution().maxSumAfterPartitioning(arr,k));
    }
}
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int curmaxi = 0, best = 0;
            for (int t = 1; t <= k &&t<= i; ++t) {
                curmaxi = Math.max(curmaxi, arr[i - t]);
                best = Math.max(best, dp[i - t] + curmaxi * t);
            }
            dp[i] = best;
        }
        return dp[n];
    }
}