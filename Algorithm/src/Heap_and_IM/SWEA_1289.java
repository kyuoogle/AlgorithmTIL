package Heap_and_IM;

import java.io.*;
import java.util.*;
 
public class SWEA_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
 
            // 문장을 받아서 ch 에 저장
            char[] bit = br.readLine().toCharArray();
            int cnt = bit[0] - '0';
            for (int i = 0; i < bit.length - 1; i++) {
                if (bit[i] != bit[i + 1])
                    cnt++;
            }
            System.out.println("#"+test+" "+cnt);
        }
    }
}