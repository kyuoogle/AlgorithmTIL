import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] in_degree;
    static List<Integer>[] adj;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        in_degree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        pq = new PriorityQueue<>();
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	adj[A].add(B);
        	in_degree[B]++;
        }
        topologicalSort();
        System.out.println(sb.toString().trim());
    }

    public static void topologicalSort() {
        // 진입 차수 0인 노드 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (in_degree[i] == 0) {
                pq.add(i);
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for (int neighbor : adj[curr]) {
                in_degree[neighbor]--;
                if (in_degree[neighbor] == 0) {
                    pq.add(neighbor);
                }
            }
        }
    }
}
