package UnboundedKnapSack.Problems;

public class CoinChangeI {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Minimum coins required : " + helper(coins,amount));
    }

    private static int helper(int[] coins, int amount) {
        return solve(coins,amount,coins.length);
    }

    private static int solve(int[] coins, int amount, int curr) {
        if(amount == 0 && curr == 0) return Integer.MAX_VALUE;
        if(curr == 0) return 0;

        int nPick = solve(coins,amount,curr-1);
        int pick = 0;
        if(coins[curr-1] <= amount){
            pick = 1+solve(coins,amount-coins[curr-1],curr);
        }
        return Math.min(pick,nPick);
    }


}
