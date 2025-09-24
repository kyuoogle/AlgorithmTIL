import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		/*
		 *  7
			0110100
			0110101
			1110101
			0000111
			0100000
			0111110
			0111000
		 */
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		List<Integer> sizes = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(!visited[i][j] && map[i][j] == 1)
					sizes.add(bfs(i, j));
			}
		}
		
		Collections.sort(sizes);
		
		StringBuilder sb = new StringBuilder();
		sb.append(sizes.size()).append("\n");
		
		for(int sz : sizes) {
			sb.append(sz).append("\n");
		}
		
		System.out.println(sb.toString());
	}


	private static int bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		visited[sx][sy] = true;
		q.offer(new int[] {sx, sy});
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
				
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				cnt++;
			}
			
		}
		return cnt;
	}
}

