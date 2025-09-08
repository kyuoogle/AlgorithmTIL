import java.io.*;
import java.util.*;

public class Main {
	// 고려할 사항...
	// 1. 재귀 호출을 어떻게 할 것인지
	// 2. 퀸을 놓을 수 있는 지 여부를 어떻게 조건문으로 판별할 것인지
	// 각 원소의 index를 '열', 원소 값을 '행'으로 생각해 일차원 배열 사용해보자
	public static int[] arr;
	public static int N; // 체스판의 크기
	public static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		nQueen(0);
		
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		// 기저 조건: 행을 다 채우면 카운트를 1 올리고 리턴
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = i;
			// isQueen() 해당 열에서 i번째 행에 퀸을 놓을 수 있는 지 확인하는 함수
			if(isQueen(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	// 놓을 위치가 다른 퀸에게 위협받는지 확인하는 검사
	private static boolean isQueen(int c) {
		// 해당 열의 행과 i열의 행이 일치한다면(같은 행에 존재한다면)
		for(int i = 0; i < c; i++) {
			if(arr[c] == arr[i]) return false;
			// 대각선 상에 놓인다면(열의 차와 행의 차가 같아서 대각선에 놓이는 경우)
			else if(Math.abs(c - i) == Math.abs(arr[c] - arr[i]))
				return false;
		}
		return true;
	}
}
