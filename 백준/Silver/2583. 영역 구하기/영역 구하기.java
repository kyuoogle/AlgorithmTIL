import java.io.*;
import java.util.*;

public class Main {	
	/*
	 * 모눈종이 위에 직사각형을 그리고, 그 직사각형을 제외한 부분의 넓이 구하기
	 * 각 칸의 넓이는 1로 간주
	 * -> BFS로 각 연결 영역의 넓이 계산 후, 개수와 오름차순 넓이 출력
	 */
	static int M, N, K; // 세로(행), 가로(열), 직사각형 수
	static int[][] paper; // 0: 빈칸, 1: 막힌 칸(직사각형)
	static boolean[][] visited; // 방문 체크용 배열
	static int[] dx = {-1, 1, 0, 0};   // 상하좌우
	static int[] dy = {0, 0, -1, 1};   // 상하좌우 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 세로(행)
		N = Integer.parseInt(st.nextToken()); // 가로(열)
		K = Integer.parseInt(st.nextToken()); // 직사각형 수
		
		paper = new int[M][N];
		visited = new boolean[M][N];

		// 직사각형 K개 칠하기
		// 입력 좌표: x1 y1 x2 y2  (좌하단, 우상단)이며 반개구간 [x1, x2), [y1, y2)
		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 배열은 (행=row=y, 열=col=x)
			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					paper[r][c] = 1; // 막힌 칸 표시
				}
			}
		}

		// 빈 영역들을 BFS로 탐색하여 넓이 수집
		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (paper[i][j] == 0 && !visited[i][j]) {
					areas.add(bfs(i, j));
				}
			}
		}

		Collections.sort(areas);
		StringBuilder sb = new StringBuilder();
		sb.append(areas.size()).append('\n');
		for (int idx = 0; idx < areas.size(); idx++) {
			if (idx > 0) sb.append(' ');
			sb.append(areas.get(idx));
		}
		System.out.println(sb);
	}
	
	public static int bfs(int sx , int sy) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (!inBounds(nx, ny)) continue;
				if (visited[nx][ny]) continue;
				if (paper[nx][ny] == 1) continue;

				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				area++;
			}
		}
		return area;
	}

	static boolean inBounds(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}
