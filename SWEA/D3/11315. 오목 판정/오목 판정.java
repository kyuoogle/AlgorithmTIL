import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0, -1, 1, -1, 1};
	static int[] dy = { 1, 1, 1, 0, 0 };
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 배열 크기 입력
			int N = Integer.parseInt(br.readLine());
			// 문자열 배열 선언
			char[][] Omok = new char[N][N];
			
			for(int i =0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					Omok[i][j] = str.charAt(j);
				}
			}
			//o가 연속 5개: 승리이므로 YES 출력
			//그외는 NO 출력(출력 주의할 것)
			String ans = "NO";
			boolean isOmok = false;
			
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Omok[i][j] == 'o') {
                        for (int d = 0; d < 5; d++) {
                            int count = 1; // 오목 돌 계산 
                            for (int pow = 1; pow <= 4; pow++) {
                                int nx = dx[d] * pow + i;
                                int ny = dy[d] * pow + j;
                                if ( nx >= N || nx < 0 || ny >= N || ny < 0 || Omok[nx][ny] != 'o') {
                                    isOmok = false;
                                    break;
                                }
                                count++;
                            }
                                if (count == 5) {
                                    ans = "YES";
                                    isOmok = true;
                                    break;
                                }
                            }
                        }
                    if(isOmok) break;
                    }
                if(isOmok) break;
                }
            System.out.println("#" + tc + " " + ans);
			
		}
	}
}
