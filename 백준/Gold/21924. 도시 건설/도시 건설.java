import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] parent, rank;
	
	static class Edge implements Comparable<Edge> {
		int u, v;
		long w;
		
		Edge(int u, int v, long c) {
			this.u = u;
			this.v = v;
			this.w = c;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		rank = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		List<Edge> edges = new ArrayList<>(M);
		long total = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			edges.add(new Edge(a, b, c));
			total += c;
		}
		
		Collections.sort(edges);
		
		long mst = 0;
		int picked = 0;
		
		for(Edge e : edges) {
			if(union(e.u, e.v)) {
				mst += e.w;
				if(++picked == N - 1) break;
			}
		}
		
		if(picked!= N - 1) System.out.println(-1);
		else System.out.println(total - mst);
	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a), pb = find(b);
		if(pa == pb) return false;
		if(rank[pa] < rank[pb]) parent[pa] = parent[pb];
		else if(rank[pa] > rank[pb]) parent[pb] = pa;
		else {
			parent[pb] = pa;
			rank[pa]++;
		}
		return true;
	}
}
