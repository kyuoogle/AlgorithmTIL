import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][][] dist;
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = str.charAt(j);
		}
		
		dist = new int[N][M][2];
		System.out.println(bfs());
	}
	
	public static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		dist[0][0][0] = 1;
		q.add(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1], b = curr[2];
			if(x == N - 1 && y == M - 1) return dist[x][y][b];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == '0' && dist[nx][ny][b] == 0) {
					dist[nx][ny][b] = dist[x][y][b] + 1;
					q.add(new int[] {nx, ny, b});
				}
				
				if(map[nx][ny] == '1' && b == 0 && dist[nx][ny][1] == 0) {
					dist[nx][ny][1] = dist[x][y][0] + 1;
					q.add(new int[] {nx, ny, 1});
				}
			}
		}
		return -1;
	}
}
