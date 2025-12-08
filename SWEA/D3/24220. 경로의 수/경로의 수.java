import java.io.*;
import java.util.*;

public class Solution {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int start, end;
    static int count;

    static void dfs(int node) {
        if (node == end) {
            count++;
            return;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }

        visited[node] = false; // 백트래킹
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // 1) N, E
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 그래프 초기화 (1번 ~ N번)
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 2) 한 줄에 E개의 간선 정보 (a b 쌍이 E개)
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);     // 방향 그래프: a -> b
            }

            // 3) 출발 정점 S, 도착 정점 G
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            count = 0;

            dfs(start);

            System.out.println("#" + tc + " " + count);
        }
    }
}
