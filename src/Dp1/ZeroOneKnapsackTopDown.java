package Dp1;

import java.util.Arrays;

public class ZeroOneKnapsackTopDown {
    public static void main(String[] args){
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int Weight = 7;

        int[][] t = new int[wt.length+1][Weight+1];
        for(int i = 0; i < wt.length+1; i++){
            for(int j = 0; j < Weight+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        int maxVal = Knapsack(wt,val,Weight,wt.length,t);
        System.out.println(maxVal);
    }
    public static int Knapsack(int[] wt, int[] val, int Weight, int n, int[][] t){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < Weight +1; j++){
                if(wt[i-1] <= j){
                    t[i][j] = Math.max((val[i-1] + t[n-1][j - wt[i-1]]),t[i-1][j]);
                }else if(wt[i-1] > j){
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][Weight];
    }

}
