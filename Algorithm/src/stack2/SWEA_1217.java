package stack2;

import java.util.Scanner;

public class SWEA_1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + (tc + 1) + " " + power(N, M));
		}
	}
	
	public static int power(int N, int M) {
		//기저 조건 설정
		if(M == 0) 
			return 1;
		
		//재귀 부분
		return N * power(N, M-1);
	}
}
