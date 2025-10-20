import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] parent;
	static List<int[]> edges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		
		//UnionFind 초기화
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		//인접 행렬 입력
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				// 무방향 그래프라 중복 방지
				if(i < j) {
					edges.add(new int[] {i, j, cost});
				}
			}
		}
		
		Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
		
		long total = 0;
		int cnt = 0;
		
		for(int[] e: edges) {
			if(union(e[0], e[1])) {
				total += e[2];
				cnt++;
				if(cnt == N - 1) break;
			}
		}
		
		System.out.println(total);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		parent[pb] = pa;
		return true;
	}
}
