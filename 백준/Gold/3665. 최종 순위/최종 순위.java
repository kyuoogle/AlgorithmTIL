import java.io.*;
import java.util.*;

public class Main {
	static int n, m; // 팀의 수 n, 순위 변경 정보의 개수 m
	static boolean[][] adj; // 기존 순위 및 변경 순위 인접 행렬로 저장
	static int[]inDegree; // 진입 차수  저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테케 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine()); // 팀의 수 입력
			// 작년 등수 저장
			int[] lastRank = new int[n + 1];
			// 등수 정보 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i < n + 1; i++) {
				lastRank[i] = Integer.parseInt(st.nextToken());
			}
			// 인접 행렬과 진입 차수 배열 크기 지정
			adj = new boolean[n + 1][n + 1];
			inDegree = new int[n + 1];
			
			//작년 순위로 그래프 만들기
			// 높은 순위 팀이 낮은 순위 팀을 가리키도록
			// 이에 따라 진입 차수 증가시키기
			for(int i = 1; i < n + 1; i++) {
				for(int j = i + 1; j < n + 1; j++) {
					adj[lastRank[i]][lastRank[j]] = true;
					inDegree[lastRank[j]]++;
				}
			}
			
			//올해 바뀐 등수 반영
			m = Integer.parseInt(br.readLine()); // 변경된 순위 정보의 개수 입력
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()); // 높은 순위
				int v = Integer.parseInt(st.nextToken()); // 낮은 순위
				
				//간선 방향 바꾸기
				// u -> v에서 v -> u로 변경 및 진입 차수 수정
				// 반대 케이스도 마찬가지로 방향 변경 및 진입 차수 수정
				if(adj[u][v]) {
					adj[u][v] = false;
					adj[v][u] = true;
					inDegree[u]++;
					inDegree[v]--;
				} else {
					adj[u][v] = true;
					adj[v][u] = false;
					inDegree[u]--;
					inDegree[v]++;
				}
			}
			//위상 정렬 메서드 부르기
			topologicalSort();
		}
	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>(); // 인접리스트 쓰기
		// 진입 차수가 0인 정점들은 Queue에 바로 넣고 시작
		for(int i = 1; i < n + 1; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder(); // 정답 출력용
		boolean possible = true; // 확실한 순위인지 판단할 변수
		int cnt = 0; // 정렬된 노드 수
		
		//Queue가 비어있지 않다면 아래 위상정렬 과정을 계속 반복
		while(!q.isEmpty()) {
			// 확실한 순위를 찾을 수 없으면
			// 큐에 2개 이상의 노드가 있다는 건, 여러 가능한 순위가 있다는 뜻이기 때문에
			// 순위는 불확실한 것
			if(q.size() > 1) {
				System.out.println("?");
				possible = false;
				break;
			}
			
			//하나의 정점을 꺼내서 출력하고 정렬한 노드 수 증가시키기
			int curr = q.poll();
			sb.append(curr).append(" ");
			cnt++;
			
			//현재 정점 curr이 가리키는 next의 진입차수를 줄이는 과정
			for(int next = 1; next < n + 1; next++) {
				if(adj[curr][next]) {
					adj[curr][next] = false;
					inDegree[next]--;
					// 위 과정을 진행 중
					// 만약 다음 노드의 진입 차수가 0이면 큐에 추가
					if(inDegree[next] == 0) {
						q.add(next);
					}
				}
			}
		}
		// 순위가 확실하지 않거나, 정점 수가 부족하면: 사이클 존재한다는 뜻
		// IMPOSSIBLE 출력 아니면 순위 출력
		if(!possible || cnt < n) System.out.println("IMPOSSIBLE");
		else System.out.println(sb.toString().trim());
	}
}
