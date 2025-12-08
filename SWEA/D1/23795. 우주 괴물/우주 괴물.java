import java.util.*;
import java.io.*;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	// 괴물 위치 체크
        	int x = 0, y = 0;
        	
        	int[][] map = new int[N][N];
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if(map[i][j] == 2) {
        				x = i; 
        				y = j;
        			}
        		}
        	}
        	
        	int[] dx = {-1, 1, 0, 0};
        	int[] dy = {0, 0, -1, 1};
        	
        	boolean[][] hit = new boolean[N][N];
        	
        	for(int d = 0; d < 4; d++) {
        		int nx = x + dx[d];
        		int ny = y + dy[d];
        		
        		while(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1) {
        			hit[nx][ny] = true;
        			nx += dx[d];
        			ny += dy[d];
        		}
        	}
        	
        	int safe = 0;
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(map[i][j] == 0 && !hit[i][j]) {
        				safe++;
        			}
        		}
        	}
        	
        	System.out.println("#" + tc + " " + safe);
        }
	}
}
