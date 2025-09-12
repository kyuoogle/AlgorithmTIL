import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, W;
    static int[] build_time;
    static int[] in_degree;
    static List<Integer>[] adj;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            build_time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                build_time[i] = Integer.parseInt(st.nextToken());
            }

            in_degree = new int[N + 1];
            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adj[X].add(Y);
                in_degree[Y]++;
            }

            W = Integer.parseInt(br.readLine());
            
            // DP 배열 초기화
            dp = new int[N + 1];
            
            topologicalSort();
        }
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 추가하고 DP값 초기화
        for (int i = 1; i <= N; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
                dp[i] = build_time[i];
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            // 현재 건물에서 다음 건물들로 이동
            for (int neighbor : adj[current]) {
                // DP 값 갱신: 현재까지 걸린 시간 + 다음 건물의 건설 시간
                dp[neighbor] = Math.max(dp[neighbor], dp[current] + build_time[neighbor]);
                in_degree[neighbor]--;
                
                // 다음 건물의 진입 차수가 0이 되면 큐에 추가
                if (in_degree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        System.out.println(dp[W]);
    }
}