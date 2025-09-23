import java.io.*;
import java.util.*;

public class Main {
	/*
	 * [문제 요약]
	 * - 0과 1로 이루어진 n(세로) x m(가로) 격자에서
	 *   1로 연결된(상/하/좌/우) 영역(그림)의 개수와, 가장 큰 그림의 넓이를 구한다.
	 *
	 * [접근 방식]
	 * - 모든 칸을 순회하며, 값이 1이고 아직 방문하지 않았다면 BFS로 연결된 영역을 한 번에 탐색한다.
	 * - BFS가 끝나면 해당 그림의 넓이를 반환받아 최대 넓이를 갱신하고, 그림 개수를 1 증가시킨다.
	 *
	 * [좌표계/인덱싱 통일]
	 * - (x, y)를 (열, 행)으로 사용한다. (x는 가로 방향 열 인덱스, y는 세로 방향 행 인덱스)
	 * - 2차원 배열 인덱싱은 [행][열]이므로 visited[y][x], bild[y][x] 형태로 접근한다.
	 *
	 * [시간/공간 복잡도]
	 * - 각 칸은 최대 한 번 큐에 들어갔다 나오므로 O(n*m)
	 * - 방문 배열과 큐 등 추가 공간은 O(n*m)
	 */

	static int n, m;              // 세로 크기 n(행 수), 가로 크기 m(열 수)
	static int[][] bild;          // 격자 정보 (0: 빈칸, 1: 그림)
	static boolean[][] visited;   // 방문 체크 배열
	// 4방향 탐색 (상/하/좌/우). (dx, dy)는 (열 변화, 행 변화) 순서로 사용
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	// 세로 n, 가로 m 입력 (행, 열)
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	// 격자 배열 선언
    	bild = new int[n][m];
    	
    	// 격자 정보 입력: n줄에 걸쳐 m개씩의 정수(0/1)
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			bild[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 방문 배열 초기화 (자바의 기본값은 false이므로 별도의 fill 불필요)
    	visited = new boolean[n][m];
    	
    	int cnt = 0;  // 그림(연결 요소)의 개수
    	int max = 0;  // 가장 큰 그림의 넓이(칸 수)
    	
    	// 모든 칸을 순회하면서, 아직 방문하지 않은 1을 만나면 새로운 그림 시작
    	for(int i = 0; i < n; i++) {           // i: 행(y)
    		for(int j = 0; j < m; j++) {       // j: 열(x)
    			if(bild[i][j] == 1 && !visited[i][j]) {
    				// bfs의 파라미터 순서는 (x, y) = (열, 행)로 전달
    				max = Math.max(max, bfs(j, i));
    				cnt++; // 새로운 그림 하나 발견
    			}
    		}
    	}

    	// 요구 출력: 그림의 개수와 가장 큰 그림의 넓이
    	System.out.println(cnt);
    	System.out.println(max);
	}

	/**
	 * 시작 좌표 (x, y)에서 BFS로 인접한(상/하/좌/우) 1들을 모두 방문 처리하고
	 * 해당 연결 요소의 넓이(칸 수)를 반환한다.
	 *
	 * @param x 시작 열 인덱스 (0 ~ m-1)
	 * @param y 시작 행 인덱스 (0 ~ n-1)
	 * @return 연결된 그림의 넓이
	 */
	private static int bfs(int x, int y) {
		// 큐에는 현재 위치 (x, y)를 (열, 행) 순서로 담는다
		Queue<int[]> q = new LinkedList<>();
		
		// 시작점 큐에 넣고 방문 처리
		q.add(new int[] {x, y});
		visited[y][x] = true; // [행][열] 순서 주의
		
		int size = 1; // 시작 칸 포함 넓이 1에서 시작
		
		while(!q.isEmpty()) {
			// 현재 칸 꺼내기
			int[] a = q.poll();
			int ax = a[0]; // 현재 열
			int ay = a[1]; // 현재 행
			
			// 4방향으로 인접 칸 확인
			for(int d = 0; d < 4; d++) {
				int nx = ax + dx[d]; // 다음 열
				int ny = ay + dy[d]; // 다음 행
				
				// 경계 체크: 0 <= ny < n, 0 <= nx < m 이어야 유효
				if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
				
				// 아직 방문하지 않았고, 값이 1인 칸이면 그림에 포함
				if(!visited[ny][nx] && bild[ny][nx] == 1) {
					visited[ny][nx] = true;       // 방문 처리 (중복 진입 방지: 큐에 넣기 전에 처리)
					q.add(new int[] {nx, ny});    // 이웃 칸을 큐에 추가
					size++;                        // 그림 넓이 +1
				}
			}
		}
		return size; // 시작점으로부터 연결된 모든 칸의 수
	}
}
