import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] snail = new int[N][N];
			
			//델타 선언: 우하좌상 순서
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			int x = 0, y = 0, d = 0;
			
			for(int v = 1; v <= N * N; v++) {
				snail[x][y] = v;
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || snail[nx][ny] != 0) {
					d = (d + 1) % 4;
					nx = x + dx[d];
					ny = y + dy[d];
				}
				x = nx;
				y = ny;
			}
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(j > 0) sb.append(" ");
					sb.append(snail[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
