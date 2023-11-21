package Recursion;
import java.util.*;

public class UniqueSubsets {
    public static void main(String[] args){
        String ip = "abcd";
        StringBuilder op = new StringBuilder();
        Set<String> set = new HashSet<>();

        solve(ip,op,set);
        System.out.println(set);
    }
    public static void solve(String ip, StringBuilder op,Set<String> set){
        if(ip.isEmpty()){
            set.add(op.toString());
            return;
        }
        StringBuilder op1 = new StringBuilder(op.toString());
        op.append(ip.charAt(0));
        StringBuilder op2 = new StringBuilder(op.toString());

        ip = ip.substring(1,ip.length());
        solve(ip,op1,set);
        solve(ip,op2,set);
    }
}
