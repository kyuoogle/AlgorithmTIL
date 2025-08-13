package linkedList;

import java.io.*;
import java.util.*;

public class SWEA_5108 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스크케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		//테스트케이스
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //초기 수열 길이 입력
			int M = Integer.parseInt(st.nextToken()); //추가 횟수
			int L = Integer.parseInt(st.nextToken()); //출력할 인덱스 번호
			
			LinkedList<Integer> nums = new LinkedList<>(); //연결리스트 선언
			st = new StringTokenizer(br.readLine()); //다음 줄 읽기 위해 다시 선언
			//수열 입력하기
			for(int i = 0; i < N; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			//해당 인덱스에 수 추가하기
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()); //다음 쥴 읽기 위해 다시 선언
				int idx = Integer.parseInt(st.nextToken()); //입력 받은 인덱스
				nums.add(idx, Integer.parseInt(st.nextToken())); // 해당 인덱스에 추가할 값
			}
			//결과 출력
			System.out.println("#" + tc + " " + nums.get(L));
		}
		
	}
}
