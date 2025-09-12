import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] in_degree;
    static List<Integer>[] adj;
    static Queue<Integer> q;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in_degree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        q = new LinkedList<>();
        order = new int[N];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            in_degree[v]++;
        }

        // 위상 정렬
        topologicalSort();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(order[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void topologicalSort() {
        // 진입 차수 0인 노드 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            order[cnt++] = curr;

            for (int neighbor : adj[curr]) {
                in_degree[neighbor]--;
                if (in_degree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }
}
