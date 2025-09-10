import java.io.*;
import java.util.*;

public class Solution {
	/* 
	 * 출발지에서 도착지까지 가는 경로 중 복구 시간이 가장 짧은 경로에 대한 총 복구 시간을 구하는 문제
	 * 이차원 배열의 각 칸마다 도로가 파여진 정도(깊이)가 주어짐
	 * - 깊이 1에 시간 1이 필요함
	 * 이때 좌상단에서 우하단까지의 경로 중 공사 시간이 가장 적게 걸리는 경로를 선택하고,
	 * 해당 경로의 시간을 출력
	 * 
	 * 출발지와 도착지를 제외한 곳이 0인 곳은 복구 작업이 불필요한 곳임
	 */
	static int N; // 지도 크기
	static int[][] road; // 복구할 곳 정보가 담긴 지도
	static int[][] dist; // 시작점에서 각 칸까지의 최단 거리 기록용
	// 델타 선언: 우, 좌, 하, 상
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//프림, 다익스트라 문제에서 사용하므로 암기
	//우선순위 큐용(Comparable 구현해 우선순위 큐 정렬 기준 정의)
	static class Node implements Comparable<Node> {
        int x, y, cost; // 현재 좌표, 누적 복구비용

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			//배열(공사할 도로가 있는 지도) 크기 입력
			N = Integer.parseInt(br.readLine());
			
			// 지도 정보를 담을 배열 선언 및 정보 입력
			road = new int[N][N];
			
			// 최단 거리를 기록할 배열 선언
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					road[i][j] = str.charAt(j) - '0'; // 지도 정보 입력
					dist[i][j] = Integer.MAX_VALUE; // 배열 초기화
				}
			}
			dijkstra();
			System.out.println("#" + tc + " " + dist[N-1][N-1]);
		}
	}

	public static void dijkstra() {
		//우선 순위 큐를 써보자
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 시작점(좌측 최상단(0, 0)) 설정
		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			//큐에서 현재 노드를 꺼내고 좌표, 누적 비용 추출
			Node curr = pq.poll();
			int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;
            
            //이미 더 짧은 최단 경로가 있다면 냅두기
            if(dist[x][y] < cost) continue;
            
            //지도 4방향 탐색
            for(int i = 0; i < 4; i++) {
            	int nx = x + dx[i];
            	int ny = y + dy[i];
            	
            	// 지도 경계 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = cost + road[nx][ny]; //다음 칸까지 이동했을 때의 복구 비용 누적 계산
                 // 최단 경로 갱신
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
		}
	}
}
