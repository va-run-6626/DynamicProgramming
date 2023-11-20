package Recursion;
import java.util.*;

public class Subsets {
    public static void main(String[] args){
        String ip = "abcd";
        StringBuilder op = new StringBuilder();

        solve(ip,op);
    }
    public static void solve(String ip, StringBuilder op){
        if(ip.isEmpty()){
            System.out.println(op.toString());
            return;
        }
        StringBuilder op1 = new StringBuilder(op.toString());
        op.append(ip.charAt(0));
        StringBuilder op2 = new StringBuilder(op.toString());

        ip = ip.substring(1,ip.length());
        solve(ip,op1);
        solve(ip,op2);
    }
}
