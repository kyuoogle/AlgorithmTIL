import java.io.*;
import java.util.*;

public class Main {
	
	static int N; // 이차원 평면의 크기
	static int[][] map; // 평면 정보 입력을 위한 배열
	static boolean[][] visited; // 방문처리용
	// 델타 배열: 배열 순회를 위해(상, 하, 좌, 우 4방향)
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 N = Integer.parseInt(br.readLine());
		 
		 // 섬 정보 입력
		 map = new int[N][N];
		 for(int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 // 섬 라벨링(나뉜 구역 체크): 1을 만나면 BFS로 2, 3, 4, ...로 라벨 부여
		 visited = new boolean[N][N];
		 int label = 2; // 육지가 1로 되어있기 때문에 2로 시작
		 for(int i = 0; i < N; i++) {
			 for(int j = 0; j < N; j++) {
				 if(map[i][j]  == 1 && !visited[i][j]) {
					 labelBFS(i, j, label);
					 label++;
				 }
			 }
		 }
		 
		 // 각 섬에서 바다로만 확장하는 BFS로 최소 다리 길이 계산
		 // id는 위에서 붙여 놓은 섬의 라벨
		 int ans = Integer.MAX_VALUE;
		 for(int id = 2; id < label; id++) {
			 ans = Math.min(ans, bridgeBFS(id, ans));
		 }
		 
		 System.out.println(ans);
	}
	
	// 섬 라벨링을 위한 BFS: (sx, sy)에서 연결된 땅을 모두 label로 변환
	private static void labelBFS(int sx, int sy, int label) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		map[sx][sy] = label;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(!inBound(nx, ny)) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny] != 1) continue; // 땅이 아니면 라벨링할 필요없으니까 재낌
				
				visited[nx][ny] = true;
				map[nx][ny] = label;
				q.offer(new int[] {nx, ny});
			}
		}
	}

	/*
	 * 특정 섬의 id를 인자로 받아 그곳에서 시작하는 BFS
	 * 시작점은 섬의 모든 땅 칸(1)
	 * 바다로 확장하면서 다른 섬을 만나면 그 거리 값이 다리 길이 후보
	 * ans 변수를 통해 최소값을 계속 갱신해 마지막에 나오는 값을 반환
	 */
	private static int bridgeBFS(int id, int ans) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[][] dist = new int[N][N];
		for(int[] row : dist) Arrays.fill(row, -1);
		
		// 이제 현재 섬의 모든 칸을 큐에 넣고 거리 0으로 세팅
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == id) {
					q.offer(new int[] {i, j});
					dist[i][j] = 0;
				}
			}
		}
		
		int best = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			//현재까지의 거리(바다를 지난 칸 수)가 ans보다 크거나 같으면 BFS를 진행하는 의미가 없음
			if(dist[x][y] >= best || dist[x][y] >= ans) continue;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if(!inBound(nx, ny)) continue;
				
				// 다른 섬을 만났을 때: 현재 dist[x][y]가 다리의 길이가 됨
				if(map[nx][ny] > 0 && map[nx][ny] != id) {
					best = Math.min(best, dist[x][y]);
					// 분명히 더 짧은 게 있을 수 있겠지만, dist 레벨이 증가하는 순서로 나오기 때문에
					// 계속 탐색하게 두되, ans로 상한값을 체크해 잘림
					continue;
				}
				
				// 바다로만 확장
				if(map[nx][ny] == 0 && dist[nx][ny] == -1) {
					dist[nx][ny] = dist[x][y] + 1;
					
					if(dist[nx][ny] < best && dist[nx][ny] < ans) {
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return best;
	}
	
	private static boolean inBound(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}