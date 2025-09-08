import java.io.*;
import java.util.*;

public class Solution {
	/*
	 * 100일 중에서 치즈덜어리가 가장 많을 때의 덩어리 개수 구하기
	 * - 각 날짜마다 치즈를 먹고 덩어리를 구해야 하므로 방문 표시를 위해 visited[][]사용
	 * - bfs를 0 ~ 100회 반복
	 */
	
	//델타 배열 선언: 상하좌우 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int[][] map; // 치즈가 얼마나 맛있게요?
	static boolean[][] visited; // 방문 체크
	static int ans; // 최대 덩어리 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 한 변의 길이

			map = new int[N][N]; // N크기의 배열 생성

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 치즈 정보 입력
				}
			}
			
			//메인 로직
			ans = 0;

			for (int i = 0; i <= 100; i++) { // 0 ~ 100일 반복
				visited = new boolean[N][N]; // 날짜마다 방문 배열 초기화
				int nowCount = 0; //오늘 날짜의 덩어리 개수
				//행 열 순회
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[0].length; k++) {
						if (map[j][k] == i) { // 오늘 날짜에 먹힘?
							map[j][k] = 0; // 먹혔으면 0
						}
					}
				}

				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) { // 다시 모든 칸 순회
						// 아직 남았고 미방문이면, 해당 덩어리 전체를 BFS로 방문 처리 및 카운트++
						if (map[j][k] != 0 && visited[j][k] == false) { 
							bfs(j, k);
							nowCount++;
						}
					}
				}
				// 오늘의 덩어리 개수가 최대라면 최대값 갱신
				if (nowCount > ans) {
					ans = nowCount;
				}
			}

			System.out.println("#" + test_case + " " + ans);

		} // [E] test_case

	}
	
	// BFS용 좌표 클래스
	// 오늘 강의시간에 배운 클래스를 생성해서 BFS에 이용
	// 코드 가독성 향상 및 좌표 이외 정보를 함께 저장할 때 용이함
	// 예를 들어, 최단 거리를 구하는 문제에서 좌표 (x , y)와 dist를 같이 넣고 빼면서
	// 쉽게 최단 거리를 구할 수 있음
	static class Point {
		int x;
		int y;
		// 생성자
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// BFS
	//  (x, y)에서 시작
	private static void bfs(int x, int y) {
		// 탐색용 큐를 생성 후 방문 처리, 이를 큐가 빌 때까지 반복
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			// 하나 꺼내서 4방향으로 인접 칸 확인
			Point p = q.poll(); 
			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				// 경계 안이고, 아직 방문 전, 치즈가 남았다면 방문 처리 후 큐에 넣어 계속 확장
				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length 
				&& visited[cx][cy] == false
						&& map[cx][cy] != 0) {
					visited[cx][cy] = true;
					q.offer(new Point(cx, cy));
				}
			}
		}
	}
}