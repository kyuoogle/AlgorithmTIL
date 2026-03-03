import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;

    static ArrayDeque<Edge> edges = new ArrayDeque<>();
    static ArrayDeque<Edge> extra = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        // 입력: i<j 구간만 보고 간선 후보 수집
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = i + 1; j < N; j++) {
                if (line.charAt(j) == 'Y') edges.addLast(new Edge(i, j));
            }
        }

        // 간선 자체가 M개 미만이면 불가능
        if (edges.size() < M) {
            System.out.println(-1);
            return;
        }

        int[] deg = new int[N];
        int used = 0;

        // 1) MST 만들기(그리디로 가능한 것부터 union)
        while (!edges.isEmpty()) {
            Edge e = edges.pollFirst();
            if (union(e.u, e.v)) {
                deg[e.u]++;
                deg[e.v]++;
                used++;
            } else {
                extra.addLast(e);
            }
        }

        // MST가 N-1개 안 나오면 연결 자체가 불가능
        if (used != N - 1) {
            System.out.println(-1);
            return;
        }

        // 2) 남은 간선에서 (M - (N-1))개 더 뽑기
        int need = M - (N - 1);
        while (need-- > 0) {
            if (extra.isEmpty()) {
                System.out.println(-1);
                return;
            }
            Edge e = extra.pollFirst();
            deg[e.u]++;
            deg[e.v]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(deg[i]);
        }
        System.out.print(sb);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    static class Edge {
        int u, v;
        Edge(int u, int v) { this.u = u; this.v = v; }
    }
}