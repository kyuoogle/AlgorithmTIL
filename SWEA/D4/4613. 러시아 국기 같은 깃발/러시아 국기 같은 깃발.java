import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수 입력
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//N줄, M개의 문자
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] russia = new char [N][M];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					russia[i][j] = str.charAt(j);
				}
			}
			
			int minColoring = Integer.MAX_VALUE;
			
			for (int blueStart = 1; blueStart < N - 1; blueStart++) {
                for (int redStart = blueStart + 1; redStart < N; redStart++) {
                    int changes = 0;
                    // 흰색 영역 계산
                    for (int i = 0; i < blueStart; i++) {
                        for (int j = 0; j < M; j++) {
                            if (russia[i][j] != 'W') {
                                changes++;
                            }
                        }
                    }
                    // 파란색 영역 계산
                    for (int i = blueStart; i < redStart; i++) {
                        for (int j = 0; j < M; j++) {
                            if (russia[i][j] != 'B') {
                                changes++;
                            }
                        }
                    }
                    // 빨간색 영역 계산
                    for (int i = redStart; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (russia[i][j] != 'R') {
                                changes++;
                            }
                        }
                    }
                    minColoring = Math.min(minColoring, changes);
                }
            }
            System.out.println("#" + tc + " " + minColoring);
		}
	}
}
