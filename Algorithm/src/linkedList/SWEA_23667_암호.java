package linkedList;

import java.io.*;
import java.util.*;

public class SWEA_23667_암호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> pw = new LinkedList<Integer>();
			
			for(int i = 0; i < N; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}
			
			int current = 0;
			for(int i = 0; i < K; i++) {
				current = (current + M);
				
				if(current == 0) {
					
				} else {
					
				}
			}
		}	
	}
}