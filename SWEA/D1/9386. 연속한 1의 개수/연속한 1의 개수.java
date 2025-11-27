import java.io.*;
//import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] nums = new int[N];
            String line = br.readLine().trim();   // "0011001110"
            for (int i = 0; i < N; i++) {
                nums[i] = line.charAt(i) - '0';   // '0' 또는 '1' => 0 또는 1
            }
            
            int cnt = 0, max = 0;
            for (int i = 0; i < N; i++) {
                if (nums[i] == 1) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 0;
                }
            }
            
            System.out.println("#" + tc + " " + max); 
        }
    }
}
