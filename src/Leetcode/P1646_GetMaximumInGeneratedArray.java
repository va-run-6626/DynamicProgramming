package Leetcode;

public class P1646_GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Get max in generated array : "+ getMaximumGenerated(n));
    }

    private static int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 1; i <=n ; i++){
            if(i * 2 >= 2 && i * 2 <= n){
                nums[2 * i] = nums[i];
            }
            if(i * 2 +1 >= 2 && i * 2 +1<= n){
                nums[2 * i + 1] = nums[i]+nums[i+1];
            }
        }
        return nums[n];
    }
}
