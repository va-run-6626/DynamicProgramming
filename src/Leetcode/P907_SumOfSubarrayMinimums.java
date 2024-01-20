package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class P907_SumOfSubarrayMinimums {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2,7};
        System.out.println("Sum of subarray minimums : " + solve(arr));
    }
    private static int solve(int[] arr) {
        int n = arr.length;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        long[] left = new long[n];
        long[] right = new long[n];

        // Calculate left boundaries
        for (int i = 0; i < n; ++i) {
            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? i + 1 : i - s1.peek();
            s1.push(i);
        }
        System.out.println(Arrays.toString(left));
        // Calculate right boundaries
        for (int i = n - 1; i >= 0; --i) {
            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                s2.pop();
            }
            right[i] = s2.isEmpty() ? n - i : s2.peek() - i;
            s2.push(i);
        }
        System.out.println(Arrays.toString(right));
        // Calculate the final sum
        long result = 0;
        for (int i = 0; i < n; ++i) {
            result = (result + arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }
}
