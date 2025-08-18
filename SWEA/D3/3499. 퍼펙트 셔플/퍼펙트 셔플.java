import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수 입력
		
		for(int tc = 1; tc <= T; tc++) {
			// 입력할 이름의 수
			int N = Integer.parseInt(br.readLine().trim());
			
			// 카드의 이름들을 저장할 배열 선언
			// names1: 앞 절반(홀수일 때 하나 더 많음), names2: 뒤 절반
			String[] names1 = new String[N];
			String[] names2 = new String[N];
			
			// 각 배열에 이름 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 앞 더미 크기: (N이 홀수면 하나 더)
			int half = (N + 1) / 2;
			
			// 앞 절반 채우기 (0 ~ half-1)
			for(int i = 0; i < half; i++) {
				names1[i] = st.nextToken();
			}
			// 뒤 절반 채우기 (half ~ N-1), names2는 0부터 채움
			for(int i = half; i < N; i++) {
				names2[i - half] = st.nextToken();
			}
			
			// 퍼펙트 셔플 결과를 담을 배열
			String[] names = new String[N];
			
			// 짝수 인덱스는 names1, 홀수 인덱스는 names2
			for(int i = 0; i < N; i++) {
				if ((i & 1) == 0) {                 // i가 짝수이면 앞 더미
				//(i & 1) == 0은 비트 연산으로 마지막 비트가 0이면 짝수라는 뜻
				//(i % 2) == 0이랑 같은 의미
					names[i] = names1[i / 2];
				} else {                            // i가 홀수이면 뒤 더미
					names[i] = names2[i / 2];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < N; i++) {
				if (i > 0) sb.append(' ');
				sb.append(names[i]);
			}
			System.out.println(sb);
		}
	}
}
