package KnapSack;
import java.util.*;

public class ZeroOneKnapsackMemoization {
    public static void main(String[] args){
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int Weight = 7;

        int[][] t = new int[10][10];
        for(int[] a : t){
            Arrays.fill(a,-1);
        }

        int maxVal = Knapsack(wt,val,Weight,wt.length,t);
        System.out.println(maxVal);
    }
    public static int Knapsack(int[] wt, int[] val, int Weight, int n,int[][]t){
        if(n == 0 || Weight == 0){
            return 0;
        }
        if(t[n][Weight] != -1){
            return t[n][Weight];
        }
        if(wt[n-1] <= Weight) {
            t[n][Weight] = Math.max((val[n - 1] + Knapsack(wt, val, Weight - wt[n - 1], n - 1, t)), Knapsack(wt, val, Weight, n - 1, t));
            return t[n][Weight];
        }else if(wt[n-1] > Weight){
            t[n][Weight] = Knapsack(wt,val,Weight,n-1,t);
            return t[n][Weight];
        }
        return 0;
    }
}
