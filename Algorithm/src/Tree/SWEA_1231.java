package Tree;

import java.io.*;
import java.util.*;

public class SWEA_1231 {
	/*
	 * SWEA_1231: 중위순회
	 * 
	 * -N번의 번호들이 붙은 이진 트리가 주어질 때, 트리를 중위순회 했을 때의 문자열 출력
	 * -트리를 직접 구현하지 않고 배열을 이용해 구현했음.
	 * ※정점: 노드, 간선은 정점과 정점을 잇는 선
	 * P[i] = i번 정점의 문자 값
	 * L[i] = i번 정점의 왼쪽 자식 정점 번호 (없으면 0)
	 * R[i] = i번 정점의 오른쪽 자식 정점 번호 (없으면 0)
	 * 
	 */
	
	// 트리를 구현하지 않고, 배열 3개를 이용해 구현
	// 각 정점의 문자값, 왼쪽 자식, 오른쪽 자식을 담을 배열 3개 선언
	static char[] P;
	static int[] L, R;		
	static StringBuilder Word;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		for(int tc = 1; tc <= 10; tc++) {
			//정점의 수 N
			int N = Integer.parseInt(br.readLine());
			//배열 초기화
			//인덱스가 0부터 시작하기 때문에, 1로 시작하기 위해 + 1
			P = new char[N + 1];
			L = new int[N + 1];	
			R = new int[N + 1];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//정점 번호
				int idx = Integer.parseInt(st.nextToken());
				//정점에 저장된 문자
				char ch = st.nextToken().charAt(0);
				P[idx] = ch;
				
				// 자식은 있을 수도 있고 없을 수도 있음
				// 자식이 없으면 해당 숫자 자체가 입력에 없는 것,
				// hasMoreTokens() 메서드를 이용해 쉽게 처리

				//왼쪽 자식 번호
				if(st.hasMoreTokens())
					L[idx] = Integer.parseInt(st.nextToken());
				//오른쪽 자식 번호
				if(st.hasMoreTokens())
					R[idx] = Integer.parseInt(st.nextToken());
			}
				
			Word = new StringBuilder();
			inorderTraversal(1); //루트는 항상 1번 정점
			// 결과 출력을 위한 포맷팅
			sb.append("#").append(tc).append(" ").append(Word).append("\n");
				
				
		}
		System.out.println(sb);
	}
	//중위 순회 메서드 생성(L -> V -> R)
	public static void inorderTraversal(int V) {
		//기저 조건 설정: 자식이 없거나, 잘못된 정점을 가리키는 경우
		if(V == 0) return; // 즉시 반환 처리
		
		//왼쪽 서브트리 방문
		//위에서 처리한대로 0이면 없음 처리
		inorderTraversal(L[V]);
		
		//현재 정점의 문자 기록
		Word.append(P[V]);
		
		//오른쪽 서브트리 방문
		//왼쪽과 동일
		inorderTraversal(R[V]);
	}
}
