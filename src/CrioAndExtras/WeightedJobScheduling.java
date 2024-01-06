package CrioAndExtras;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
    public static class Jobs{
        int start;
        int end;
        int jobProfit;
        public Jobs(int start, int end, int jobProfit){
            this.start = start;
            this.end = end;
            this.jobProfit = jobProfit;
        }
    }
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        System.out.println("Maximum Profit : " + solve(startTime,endTime,profit));
    }
    private static int solve(int[] startTime, int[] endTime, int[] profit){
        Jobs[] allJobs = new Jobs[startTime.length];
        for(int i = 0; i < startTime.length; i++){
            allJobs[i] = new Jobs(startTime[i],endTime[i],profit[i]);
        }

        Arrays.sort(allJobs, new Comparator<Jobs>() {
            @Override
            public int compare(Jobs j1, Jobs j2) {
                return j1.end - j2.end;
            }
        });

        //Recursive Solution
        //return helperRec(allJobs, allJobs.length);

        int[] dp = new int[allJobs.length+1];

        //Memoization
        //Arrays.fill(dp,-1);
        //return helperMem(allJobs,allJobs.length,dp);

        //tabulation
        return helperTab(allJobs,allJobs.length);
    }

    private static int helperTab(Jobs[]allJobs,int n){
        int[] dp = new int[n];
        dp[0] = allJobs[0].jobProfit;
        for(int i = 1; i < allJobs.length; i++){
            int includeJob = allJobs[i].jobProfit;
            int LNC = latestNonConflict(allJobs,i);
            if(LNC != -1){
                includeJob += dp[LNC];
            }
            dp[i] = Math.max(includeJob,dp[i-1]);
        }
        return dp[n-1];
    }
    private static int helperMem(Jobs[] allJobs, int n,int[] dp){
        if(n == 1) return allJobs[n-1].jobProfit;

        if(dp[n] != -1) return dp[n];

        int includeJob = allJobs[n-1].jobProfit;
        int i = latestNonConflict(allJobs,n);
        if(i != -1){
            includeJob += helperRec(allJobs,i+1);
        }
        int excludeJob = helperRec(allJobs,n-1);
        return dp[n] = Math.max(includeJob,excludeJob);
    }
    private static int helperRec(Jobs[] allJobs, int n) {
        if(n == 1) return allJobs[n-1].jobProfit;

        int includeJob = allJobs[n-1].jobProfit;
        int i = latestNonConflict(allJobs,n);
        if(i != -1){
            includeJob += helperRec(allJobs,i+1);
        }
        int excludeJob = helperRec(allJobs,n-1);
        return Math.max(includeJob,excludeJob);
    }

    private static int latestNonConflict(Jobs[] allJobs, int i) {
        for(int j = i-1; j >= 0; j--){
            if(allJobs[j].end <= allJobs[i-1].start) {
                return j;
            }
        }
        return -1;
    }

}
