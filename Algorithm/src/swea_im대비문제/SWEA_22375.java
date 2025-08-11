package swea_im대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_22375 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			//배열의 크기 N 입력 받기 및 그에 따른 배열 선언
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			//A와 B 배열 입력 받기
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(stA.nextToken());
			}
			StringTokenizer stB = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				B[i] = Integer.parseInt(stB.nextToken());
			}
			//메인 로직
			int cnt = 0; // 스위치 켠 횟수
			for(int i = 0; i < N; i++) {
				if(A[i] != B[i]) {
					converter(A, i);
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	public static void converter(int[] arr, int index) {
		for(int i = index; i < arr.length; i++) {
			arr[i] = 1 - arr[i];
		}
	}
}
