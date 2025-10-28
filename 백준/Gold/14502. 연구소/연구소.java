import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int ans = 0;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0);
		
		System.out.println(ans);
		
	}
	
	public static void makeWall(int cnt) {
		// 벽 3개를 다 세우면 
		if(cnt == 3 ) {
			int safe = spreadVirus();
			if(safe > ans) ans = safe;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1; // 벽 세움
					makeWall(cnt + 1); // 다음 벽
					map[i][j] = 0; // 원상복구
				}
			}
		}
	}
	
	public static int spreadVirus() {
		int[][] tmp = new int[N][M];
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					q.offer(new int[]{nx, ny});
				}
			}
		}
		
		int safeCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) safeCnt++;
			}
		}
		return safeCnt;
	}
}
