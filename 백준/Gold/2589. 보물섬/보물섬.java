import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static char[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		// 모든 칸을 훑으며 육지(L)일 때만 BFS 실행 
        // -> 그 시작점에서의 최장 최단 거리 반환값으로 ans 갱신
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'L') {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);
	}
	
	// BFS
	public static int bfs(int sx, int sy) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		int[][] dist = new int [n][m];
		
		visited[sx][sy] = true;
		dist[sx][sy] = 0;
		q.add(new int[] {sx, sy});
		
		int far = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			far = Math.max(far, dist[x][y]); // 현재 칸까지의 최단 거리로 far 갱신
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 범위 밖
				if(map[nx][ny] != 'L' || visited[nx][ny]) continue; // 바다거나 이미 방문했을 땐 지나 가
				visited[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1; // 한 칸 이동하므로 +1
				q.add(new int[] {nx, ny});
			}
		}
		return far; // 시작점에서 가장 멀리 도달한 칸까지의 최단 거리
	}
}
