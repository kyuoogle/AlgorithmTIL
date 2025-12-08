import java.util.*;
import java.io.*;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] sumRow = new int[N];
            int[] sumCol = new int[N];
        	
        	int[][] map = new int[N][N];
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			sumRow[i] += map[i][j];
                    sumCol[j] += map[i][j];
        		}
        	}
        	int maxScore = 0;

            // 모든 지점에서 점수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int score = sumRow[i] + sumCol[j] - map[i][j];
                    if (score > maxScore) maxScore = score;
                }
            }
        	System.out.println("#" + tc + " " + maxScore);
        }
	}
}
