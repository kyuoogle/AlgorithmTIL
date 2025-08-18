import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수 입력
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 이번 케이스에서 정수 개수
			
			int[] nums = new int[N]; // 정수들을 담을 배열
			
			// N개의 정수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) { // 0부터 N-1까지 채워야 함
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int ansDanjo = -1; // 단조 증가하는 곱의 최댓값 (없으면 -1)
			
			// 모든 쌍 (i < j)에 대해 곱 계산
			for(int i = 0; i < N - 1; i++) {          
				for(int j = i + 1; j < N; j++) {
					
					int Danjo = nums[i] * nums[j]; // 두 수의 곱
					boolean isDanjo = true;        // 단조 증가 여부 체크 플래그
					String str = String.valueOf(Danjo); // 곱을 문자열로 변환하여 자릿수 비교
					
					// 곱의 각 자리수를 왼쪽에서 오른쪽으로 검사
					for(int k = 0; k < str.length() - 1; k++) {
						// 앞자리 > 뒷자리인 경우 단조 증가 조건 위반
						if(str.charAt(k) > str.charAt(k + 1)) {
							isDanjo = false;
							break;
						}
					}
					
					// 단조 증가하는 수라면 최댓값 갱신
					if(isDanjo) {
						ansDanjo = Math.max(ansDanjo, Danjo);
					}
				}
			}
			
			// 결과 출력
			System.out.println("#" + tc + " " + ansDanjo);
		}
	}
}
