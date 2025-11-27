import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            int[] nums = new int[N];
            StringTokenizer st = null;
            int idx = 0;
            
            // N개의 숫자를 안전하게 읽기 (여러 줄에 걸쳐 있을 수도 있음)
            while (idx < N) {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                while (st.hasMoreTokens() && idx < N) {
                    nums[idx++] = Integer.parseInt(st.nextToken());
                }
            }
            
            int cnt = 1;   // 현재 연속 증가 구간 길이
            int max = 1;   // 최소 길이는 1
            
            for (int i = 1; i < N; i++) {
                if (nums[i] > nums[i - 1]) {   // "커진" 경우 (딱 +1 아님!)
                    cnt++;
                } else {
                    cnt = 1;                   // 끊기면 현재 원소 하나로 리셋
                }
                if (cnt > max) max = cnt;
            }
            
            sb.append('#').append(tc).append(' ')
              .append(max).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}
