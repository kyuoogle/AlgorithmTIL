import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int removed;
    static int leafCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        adj = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
            } else {
                adj[i].add(p);
                adj[p].add(i);
            }
        }

        removed = Integer.parseInt(br.readLine().trim());

        if (removed == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leafCount);
    }

    static void dfs(int node) {
        visited[node] = true;

        int child = 0; // 삭제 노드 제외하고 실제로 내려갈 수 있는 자식 수(트리 관점)
        for (int next : adj[node]) {
            if (next == removed || visited[next]) continue;
            child++;
            dfs(next);
        }

        if (child == 0) leafCount++;
    }
}