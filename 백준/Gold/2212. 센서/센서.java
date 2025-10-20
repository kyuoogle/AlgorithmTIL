import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 센서의 개수
		int k = Integer.parseInt(br.readLine()); // 집중국의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N개의 센서의 좌표
		int[] map = new int[n];
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(map);
		// 중복 제거
		int[] uniq = new int[n];
		int U = 0;
		uniq[U++] = map[0];
		for(int i = 1; i < n; i++) {
			if(map[i] != map[i - 1]) {
				uniq[U++] = map[i];
			}
		}
		// 집중국이 유니크 센서 수 이상이면 0 반환
		if(k >= U) {
			System.out.println(0);
			return;
		}
		// 인접 간격 배열 구하기(길이: U - 1)
		int[] gaps = new int[U - 1];
		for(int i = 1; i < U; i++) {
			gaps[i - 1] = uniq[i] - uniq[i - 1];
		}
		// 간격 오름차순 정렬 후, 가장 작은 것부터 U-K개 합산
		Arrays.sort(gaps);
		long ans = 0;
		// U개의 점을 K구간으로 나눈다면, 내부에 포함되는 간격의 개수는 (U - k)개
		for(int i = 0; i < U - k; i++) ans += gaps[i];
		
		System.out.println(ans);
	}
}
