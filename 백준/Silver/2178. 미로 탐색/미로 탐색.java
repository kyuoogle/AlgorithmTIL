import java.util.*;
import java.io.*;

public class Main {
	static int N, M; 
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
		
		for(int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			for(int j = 1; j < M + 1; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		System.out.println(bfs(1,1));
	}
	
	// BFS
    public static int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N + 1][M + 1];

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 1; // 시작 칸도 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            // 도착 지점 도달
            if (x == N && y == M) return dist[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 1-based 범위 체크
                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return -1; // 도착 불가
    }
}

