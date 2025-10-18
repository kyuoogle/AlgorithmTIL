import java.io.*;
import java.util.*;

/**
 * BOJ 2887 - 행성 터널
 * - 아이디어: x/y/z 각각 정렬 후 인접 행성만 간선 생성 -> Kruskal MST
 */
public class Main {

    /* ====== Data Types ====== */
    static class Planet {
        int idx, x, y, z;
        Planet(int idx, int x, int y, int z) {
            this.idx = idx; this.x = x; this.y = y; this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
        public int compareTo(Edge o) { return Integer.compare(this.w, o.w); }
    }

    static class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n]; size = new int[n];
            for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }
        }
        int find(int a) {
            if (parent[a] == a) return a;
            return parent[a] = find(parent[a]);
        }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (size[a] < size[b]) { int t = a; a = b; b = t; }
            parent[b] = a; size[a] += size[b];
            return true;
        }
    }

    /* ====== Main ====== */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Planet[] P = readPlanets(br, N);

        List<Edge> edges = buildEdges(P);

        long ans = kruskal(N, edges);
        System.out.println(ans);
    }

    /* ====== I/O ====== */
    /** N개의 행성을 입력받아 배열로 반환 */
    private static Planet[] readPlanets(BufferedReader br, int N) throws IOException {
        StringTokenizer st;
        Planet[] P = new Planet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            P[i] = new Planet(i, x, y, z);
        }
        return P;
    }

    /* ====== Edge Construction ====== */
    /**
     * x/y/z 각각 정렬 후 인접한 쌍만 간선으로 추가
     * 최대 간선 수: 3*(N-1)
     */
    private static List<Edge> buildEdges(Planet[] P) {
        int N = P.length;
        Planet[] X = P.clone();
        Planet[] Y = P.clone();
        Planet[] Z = P.clone();

        Arrays.sort(X, (a, b) -> Integer.compare(a.x, b.x));
        Arrays.sort(Y, (a, b) -> Integer.compare(a.y, b.y));
        Arrays.sort(Z, (a, b) -> Integer.compare(a.z, b.z));

        ArrayList<Edge> edges = new ArrayList<>(3 * Math.max(0, N - 1));
        addAdjacentEdges(edges, X, 'x');
        addAdjacentEdges(edges, Y, 'y');
        addAdjacentEdges(edges, Z, 'z');
        return edges;
    }

    /** 정렬된 배열에서 인접한 쌍을 간선으로 추가 */
    private static void addAdjacentEdges(List<Edge> edges, Planet[] arr, char axis) {
        for (int i = 0; i < arr.length - 1; i++) {
            Planet a = arr[i], b = arr[i + 1];
            int w;
            if (axis == 'x') w = Math.abs(b.x - a.x);
            else if (axis == 'y') w = Math.abs(b.y - a.y);
            else w = Math.abs(b.z - a.z);
            edges.add(new Edge(a.idx, b.idx, w));
        }
    }

    /* ====== MST (Kruskal) ====== */
    private static long kruskal(int n, List<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(n);
        long total = 0L;
        int picked = 0;

        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                total += e.w;
                if (++picked == n - 1) break; // MST 완성
            }
        }
        return total;
    }
}
