import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] A = new int[N];
            int[] B = new int[N];
            
            //A와 B 배열 입력 받기
            StringTokenizer stA = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(stA.nextToken());
            }
            StringTokenizer stB = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(stB.nextToken());
            }
            
            int cnt = 0;
            
            for(int i = 0; i < N; i++) {
            	if(A[i] != B[i]) {
            		for(int j = i; j < N; j++) {
            			A[j] = 1 - A[j];
            		}
            		cnt++;
            	}
            }
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
