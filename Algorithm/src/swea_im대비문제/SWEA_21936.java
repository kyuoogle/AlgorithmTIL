package swea_im대비문제;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_21936 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String str = br.readLine().trim();
			
			String ans = "NONE";
			
			for(int i = 0; i <= N - M; i++) {
				String palinM = str.substring(i, i + M);
				if(isPalindrome(palinM)) {
					ans = palinM;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isPalindrome(String s) {
		int L = 0, R = s.length() - 1;
		
		while(L < R) {
			if(s.charAt(L) != s.charAt(R)) 
				return false;
			L++;
			R--;
		}
		return true;
	}
}
