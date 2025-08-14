package Tree;

import java.io.*;
import java.util.*;

public class SWEA_1232 {
	/*
	 * 사칙 연산 기호와 정수로 구성된 표현식 이진 트리가 주어짐
	 * 트리를 후위 순회해 평가(후위 표기식)
	 * 연산 과정은 실수로, 결과는 소수점 이하 버려 정수로 출력
	 */
	//트리 구현을 위한 배열 5개 선언
	static boolean[] isOp; //i번 노드가 연산자라면 true 반환
	static char[] op; //연산자 저장
	static double[] num; //숫자 노드의 값을 실수로 저장: 계산 중간과정은 모두 실수로 처리하라고 문제에 명시
	static int[] L, R; //왼쪽 자식, 오른쪽 자식 저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) { //테스트케이스 10개로 고정
			int N = Integer.parseInt(br.readLine()); //정점 개수 입력
			
			//루트, 자식 노드의 계산을 쉽게 하기 위해 시작 인덱스를 1로 시작
			isOp = new boolean[N + 1];
			op = new char[N + 1];
			num = new double[N + 1];
			L = new int[N + 1];
			R = new int[N + 1];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String decision = st.nextToken(); //숫자나 연산자를 담는 용도, 숫자면 파싱/연산자면 기호 저장
				
				//연산자 노드는 idx op L R
				//숫자 노드는 idx value
				if(st.hasMoreTokens()) {
					//연산자
					isOp[idx] = true;
                    op[idx]   = decision.charAt(0);
                    L[idx]    = Integer.parseInt(st.nextToken());
                    R[idx]    = Integer.parseInt(st.nextToken());
                } else {
                    // 숫자 노드
                    isOp[idx] = false;
                    num[idx]  = Double.parseDouble(decision);
                }	
			}
			double res = value(1); // 루트는 항상 1
            sb.append('#').append(tc).append(' ').append((int) res).append('\n'); // 소수점 이하는 버림
		}
		System.out.println(sb);
	}

	static double value(int i) {
		//기저 조건 설정
		if(!isOp[i]) return num[i]; //숫자 노드면 값 그대로
		
		//사칙 연산 처리 로직
		double a = value(L[i]); //왼쪽 서브트리 결과
		double b = value(R[i]); //오른쪽 서브트리 결과
		
		//연산자별 조건 연산 설정(switch 문)
		switch(op[i]) {
			case '+': 
				return a + b;
	        case '-': 
	        	return a - b;
	        case '*': 
	        	return a * b;
	        case '/': 
	        	return a / b;
	        
	        default:
	        	return -1; //잘못된 상황
		}
	}
}
