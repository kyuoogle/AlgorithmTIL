import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
		
			char curr = '0';
			
			int cnt = 0;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != curr) {
					cnt++;
					curr = str.charAt(i);
				}
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
}
