import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] numA = new int [N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				numA[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] numB = new int [M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				numB[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = Integer.MIN_VALUE;
			
			if(N <= M) {
				for(int i = 0; i <= M - N; i++) {
					int sum = 0;
					for(int j = 0; j < N; j++) {
						sum += numB[i + j] * numA[j];
					}
					ans = Math.max(ans,  sum);
				}	
			} else {
				for(int i = 0; i <= N - M; i++) {
					int sum = 0;
					for(int j = 0; j < M; j++) {
						sum += numB[j] * numA[i + j];
					}
					ans = Math.max(ans,  sum);
				}
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
