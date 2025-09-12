import java.io.*;
import java.util.*;

public class Solution  {
	static int V, E; // 정점, 간선의 개수
	static int[] in_degree; // 진입 차수 정보 저장 배열
	static List<Integer>[] adj;
	static Queue<Integer> q; // 위상 정렬 수행을 위한 q 선언
	static int[] order; // 작업순서를 저장할 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테케는 10개로 고정
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			in_degree = new int[V + 1]; // 1~V번까지 노드에 번호가 붙어 크기 + 1로 배열 사용
			adj = new ArrayList[V + 1]; // 같은 이유로 + 1
			for(int i = 1; i < V + 1; i++) {
				adj[i] = new ArrayList<>();
			}
			
			q = new LinkedList<>();
			order = new int[V]; // 작업 순서 출력용 배열이라 크기 상관없음
			
			// 간선 정보 입력 받고 진입 차수 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				in_degree[v]++;
			}
			//위상 정렬
			topologicalSort();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < V; i++) {
				sb.append(order[i]).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
	
	public static void topologicalSort() {
		//1. 진입 차수가 0인 모든 정점 큐에 삽입
		for(int i = 1; i < V + 1; i++) {
			if(in_degree[i] == 0) {
				q.add(i);
			}
		}
		//2. 큐가 빌 때까지 반복
		int cnt = 0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			order[cnt++] = curr;
			
			//3. 현재 정점에서 나가는 간선 제거 및 진입 차수 감소시키기
			for(int neighbor: adj[curr]) {
				in_degree[neighbor]--;
				//4. 새롭게 진입 차수 0된 놈들 다시 큐에 삽입
				if(in_degree[neighbor] == 0) q.add(neighbor);
			}
		}
	}
}
