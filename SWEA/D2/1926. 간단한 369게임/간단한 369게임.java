import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            int cnt = 0;
            boolean isClap = false;
            for(int j = str.length() - 1; j >= 0; j--) {
                if(str.charAt(j) == '3'
                        || str.charAt(j) == '6'
                        || str.charAt(j) == '9') {
                    cnt++;
                    isClap = true;
                }
            }
            if(isClap) {
                for (int c = 0; c < cnt; c++) {
                    sb.append("-");
                }
            } else sb.append(i);
  
            sb.append(" ");
        }
        System.out.print(sb);
    }
}