import java.util.*;
import java.io.*;

public class Main {
	
	static int N, E; // 정점의 수 N, 간선의 수 E
	static List<Integer>[] adj; // 인접리스트
	static boolean[] visited; // 방문 여부
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N + 1];
		
		for(int i = 1; i < N + 1; i++) adj[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int infection = bfs(1) - 1;
		System.out.println(infection);
	}

	private static int bfs(int start) {
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			cnt++;
			
			for(int nxt : adj[curr]) {
				if(visited[nxt]) continue;
				visited[nxt] = true;
				q.offer(nxt);
			}
		}
		return cnt;
	}
}

