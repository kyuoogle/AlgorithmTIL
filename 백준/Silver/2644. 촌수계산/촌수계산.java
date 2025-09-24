import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M; // 사람 수, 관계 수
	static int A, B; // 촌 수를 구할 두 사람
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N + 1];		
		for(int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int chonSu = bfs(A, B);
		
		System.out.println(chonSu);
	}

	private static int bfs(int start, int target) {
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;                                                                           
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == target) 
				return dist[curr];
			
			for(int nxt : adj[curr]) {
				if(visited[nxt]) continue;
				visited[nxt] = true;
				dist[nxt]= dist[curr] + 1;
				q.offer(nxt);
			}
		}
		return -1;
	}
}

