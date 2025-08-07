package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	//막대는 자신보다 긴 막대 위에만 놓일 수 있음
	//막대는 다른 막대 위에 놓일 때, 완전히 포홤되지만 끝점이 겹치지 않게
	//각 막대를 자르는 레이저는 적어도 하나 존재
	//레이저는 어떤 막대의 양 끝점과도 겹치지 않음
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int len = line.length();
			
			sb.append("#").append(tc).append(" ")
			.append(stRazer(len, line)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int stRazer(int len, String line) {
		Stack<Character> st = new Stack<>();
		int stCnt = 0;
		char prev = ' ';
		
		for(int i = 0; i < len; i++) {
			char ch = line.charAt(i);
			
			if(ch == '(') {
				st.push(ch);
			} else {
				st.pop();
				if(prev == '(') {
					stCnt += st.size();
				} else {
					stCnt += 1;
				}
			}
			prev = ch;
		}
		
		return stCnt;
	}
}
