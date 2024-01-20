package MatrixChainMultiplication.Problems;

import java.util.HashMap;
import java.util.Map;

public class Prog3_ScrambledStrings {
    public static void main(String[] args) {
        String a = "GREAT";
        String b = "RGEAT";
        Map<String,Boolean> map = new HashMap<>();
        System.out.println("Are Scrambled : "+ solve1(a,b));
        System.out.println("Are Scrambled : "+ solve2(a,b,map));
    }

    private static boolean solve2(String a, String b, Map<String, Boolean> map) {
        if(a.equals(b)) return true;
        if(a.length() <= 1) return false;

        String check = a+"_"+b;
        if(map.containsKey(check)) return map.get(check);

        int n = a.length();
        boolean flag = false;

        boolean SwapFirstLast, SwapLastFirst, NSwapFirstFirst, NSwapLastLast;
        for(int i = 1; i <= n-1; i++){

            check = a.substring(0,i)+"_"+b.substring(n-i,n);
            if(map.containsKey(check))
                SwapFirstLast = map.get(check);
            else
                SwapFirstLast = solve2(a.substring(0,i),b.substring(n-i,n),map);

            check = a.substring(i,n)+"_"+b.substring(0,n-i);
            if(map.containsKey(check))
                SwapLastFirst = map.get(check);
            else
                SwapLastFirst = solve2(a.substring(i,n),b.substring(0,n-i),map);

            check = a.substring(0,i)+"_"+b.substring(0,i);
            if(map.containsKey(check))
                NSwapFirstFirst = map.get(check);
            else
                NSwapFirstFirst = solve2(a.substring(0,i),b.substring(0,i),map);

            check = a.substring(i,n)+"_"+b.substring(i,n);
            if(map.containsKey(check))
                NSwapLastLast = map.get(check);
            else
                NSwapLastLast = solve2(a.substring(i,n),b.substring(i,n),map);

            if((SwapFirstLast && SwapLastFirst) || (NSwapFirstFirst && NSwapLastLast)){
                flag = true;

                check = a+"_"+b;
                map.put(check,flag);
                break;
            }
        }
        return flag;
    }

    private static boolean solve1(String a , String b){
        if(a.equals(b)) return true;
        if(a.length() <= 1) return false;

        int n = a.length();
        boolean flag = false;
        for(int i = 1; i <= n-1; i++){
            boolean SwapFirstLast = solve1(a.substring(0,i),b.substring(n-i,n));
            boolean SwapLastFirst = solve1(a.substring(i,n),b.substring(0,n-i));
            boolean NSwapFirstFirst = solve1(a.substring(0,i),b.substring(0,i));
            boolean NSwapLastLast = solve1(a.substring(i,n),b.substring(i,n));
            if((SwapFirstLast && SwapLastFirst) || (NSwapFirstFirst && NSwapLastLast)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
