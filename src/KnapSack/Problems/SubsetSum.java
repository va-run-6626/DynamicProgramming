package KnapSack.Problems;

public class SubsetSum {
    public static void main(String[] args){
        int[] arr = {2,3,7,8,10};
        int sum = 11;

        Boolean[][] tMem = new Boolean[arr.length+1][sum+1];
        for(int i = 0; i <= arr.length; i++){
            for(int j = 0; j <= sum; j++){
                tMem[i][j] = null;
            }
        }

        boolean[][] TBtm = new boolean[arr.length+1][sum+1];
        for(int i = 0; i <=  arr.length;i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0){
                    TBtm[i][j] = false;
                }
                if(j == 0){
                    TBtm[i][j] = true;
                }
            }
        }
        System.out.println("Is Possible using recursion : " + subsetRec(arr,arr.length,sum));
        System.out.println("Is Possible using memoization: " + subsetMem(arr,arr.length,sum,tMem));
        System.out.println("Is Possible using Bottom Up: " + subsetBtm(arr,sum,TBtm));
    }

    // tc -> n sc -> n^2
    static boolean subsetBtm(int[] arr, int sum,boolean[][] tBtm){
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    tBtm[i][j] = tBtm[i-1][j - arr[i-1]] || tBtm[i-1][j];
                }else{
                    tBtm[i][j] = tBtm[i-1][j];
                }
            }
        }
        return tBtm[arr.length][sum];
    }
    //o(n) space -> n^2 + stack
    static boolean subsetMem(int[] arr, int ind, int sum,Boolean[][] tMem){
        if(ind == 0 && sum == 0){
            return true;
        }
        if(ind == 0){
            return false;
        }

        if(tMem[ind][sum] != null){
            return tMem[ind][sum];
        }
        if(arr[ind-1] <= sum){
           tMem[ind][sum] = subsetMem(arr,ind-1,sum - arr[ind-1],tMem) || subsetMem(arr, ind-1,sum,tMem);
           return tMem[ind][sum];
        }else{
            tMem[ind][sum]=subsetMem(arr,ind-1,sum,tMem);
            return tMem[ind][sum];
        }
    }

    // tc -> o(n^2) sc -> space used by stack
    static boolean subsetRec(int[] arr, int ind, int sum){
        if(ind == 0 && sum == 0){
            return true;
        }
        if(ind == 0){
            return false;
        }
        if(arr[ind-1] <= sum){
            return subsetRec(arr,ind-1,sum - arr[ind-1]) || subsetRec(arr, ind-1,sum);
        }else{
            return subsetRec(arr,ind-1,sum);
        }
    }
}
