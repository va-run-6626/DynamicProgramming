package MatrixChainMultiplication;

public class MatrixChainMultiplicationRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println("Minimum cost of matrix Chain multiplication is : "+ solve(arr,1,arr.length-1));
    }

    private static int solve(int[] arr, int i, int j) {
        if(i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = solve(arr,i,k)+solve(arr,k+1,j) + arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans,tempAns);
        }
        return ans;
    }
}
