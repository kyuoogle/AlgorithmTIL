package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1255 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 번호 입력 받기
		int testNum = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= 10; tc++) {
			//8개의 데이터가 담길 큐 선언
			ArrayDeque<Integer> q = new ArrayDeque<>();
			//배열의 각 칸에 데이터 담기
			StringTokenizer pwSt = new StringTokenizer(br.readLine()); 
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(pwSt.nextToken()));
			}
			//메인 로직
			
		}
		System.out.println("#" + testNum + " ");
	}
}
