package Recursion;

public class PermutationsWithSpaces {
    public static void main(String[] args) {
        String ip = "ABC";
        StringBuilder op = new StringBuilder(String.valueOf(ip.charAt(0)));

        helper(ip,op,1);
    }
    public static void helper(String ip, StringBuilder op, int curr){
        if(curr == ip.length()){
            System.out.println(op.toString());
            return;
        }
        StringBuilder op1 = new StringBuilder(op.append(ip.charAt(curr)).toString());
        op.deleteCharAt(op.length()-1);
        StringBuilder op2 = new StringBuilder(op.append(" ").append(ip.charAt(curr)).toString());
        helper(ip,op1,curr+1);
        helper(ip,op2,curr+1);
    }
}
