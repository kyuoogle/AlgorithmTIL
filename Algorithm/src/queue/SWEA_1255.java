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
		
		for(int tc = 1; tc <= 10; tc++) {
			//테스트 케이스 번호 입력 받기
			int testNum = Integer.parseInt(br.readLine());
			
			//8개의 데이터가 담길 큐 선언
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			//배열의 각 칸에 데이터 담기
			StringTokenizer pwSt = new StringTokenizer(br.readLine()); 
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(pwSt.nextToken()));
			}
			
			//메인 로직
			while(true) {
				//루프 종료를 위한 변수 선언
				boolean end = false;
				
				for(int dc = 1; dc <= 5; dc++) {
					int currNum = q.poll();
					currNum -= dc;
					
					if(currNum <= 0) {
						q.offer(0);
						end = true;
						break;
					}
					q.offer(currNum);
				}
				if(end) break;
			}
			System.out.print("#" + testNum + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
		}
	}
}
