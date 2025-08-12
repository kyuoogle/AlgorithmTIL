package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			//카드 장 수 입력
			int N = Integer.parseInt(br.readLine());
			//카드를 반으로 나눈 후 저장할 두 개의 큐 선언
			Queue<String> half1 = new LinkedList<>();
			Queue<String> half2 = new LinkedList<>();
			//토큰화
			StringTokenizer st = new StringTokenizer(br.readLine());
			//N이 홀수일 때 앞쪽 덱으로 하나 더 들어가게 하기 위해서
			int half = (N + 1) / 2;
			//카드의 절반(홀수일 경우 +1) 첫번째 덱으로
			for(int i = 0; i < half; i++) {
				half1.offer(st.nextToken());
			}
			//나머지 카드는 두번째 덱에
			while(st.hasMoreTokens()) {
				half2.offer(st.nextToken());
			}
			
			//두 덱에서 번갈아 카드 꺼내어 다시 하나의 덱으로 만들기
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			while(!half1.isEmpty() || !half2.isEmpty()) {
				if(!half1.isEmpty()) {
					sb.append(half1.poll()).append(" ");
				}
				if(!half2.isEmpty()) {
					sb.append(half2.poll()).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
