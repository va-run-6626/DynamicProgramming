package Recursion;

import javax.print.DocFlavor;

public class PermutationWithCasechange {
    public static void main(String[] args) {
        String ip = "ab";
        StringBuilder op = new StringBuilder();

        helper(ip,op,0);
    }
    public static void helper(String ip, StringBuilder op, int curr){
        if(curr == ip.length()){
            System.out.println(op.toString());
            return;
        }
        StringBuilder op1 = new StringBuilder(op.append(ip.charAt(curr)).toString());
        op.deleteCharAt(op.length()-1);
        StringBuilder op2 = new StringBuilder(op.append(Character.toUpperCase(ip.charAt(curr))).toString());
        helper(ip,op1,curr+1);
        helper(ip,op2,curr+1);
    }
}
