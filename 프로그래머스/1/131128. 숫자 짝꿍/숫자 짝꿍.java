import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int [10];
        int[] yCount = new int [10];
        
        for(int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            xCount[num]++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            yCount[num]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--) {
            int cnt = Math.min(xCount[i], yCount[i]);
            for(int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}