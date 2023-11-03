package CrioAndExtras;

import java.util.Scanner;
import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dpMem = new int[n+1];
        Arrays.fill(dpMem,-1);

        System.out.println("Using recursion : " + fibRec(n));
        System.out.println("Using memoization : " + fibMem(n,dpMem));
        System.out.println("Using Bottom Up : " + fibBtm(n));
    }
    public static int fibRec(int n){
        if(n <= 1){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    }
    public static int fibMem(int n, int[] dpMem){
        if(n <= 1){
            return n;
        }

        if(dpMem[n] != -1){
            return dpMem[n];
        }

        dpMem[n] = fibMem(n-1,dpMem) + fibMem(n-2,dpMem);
        return dpMem[n];
    }

    public static int fibBtm(int n){
        int first = 0;
        int second = 1;

        int curr = 1;
        for(int i = 2; i <= n; i++){
            curr = first + second;
            first = second;
            second = curr;
        }
        return  curr;
    }
}
