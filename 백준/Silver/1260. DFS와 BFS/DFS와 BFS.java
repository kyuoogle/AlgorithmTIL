import java.io.*;
import java.util.*;

public class Main {
    static int[][] adj; // 인접 행렬
    static boolean[] visited; // 방문 체크 배열
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = 1;
        }

        DFS(V);
        System.out.println();
        
        // DFS 후 visited 배열 초기화
        visited = new boolean[N + 1]; 
        BFS(V);
    }

    private static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adj[node][i] == 1) {
                DFS(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p + " ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adj[p][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}