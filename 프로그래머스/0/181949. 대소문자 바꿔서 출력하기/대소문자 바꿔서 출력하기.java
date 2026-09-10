import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String ans = "";
        
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(Character.isUpperCase(c)) {
                ans += Character.toLowerCase(c);
            } else {
                ans += Character.toUpperCase(c);
            }
        }
        
        System.out.println(ans);
    }
}