import java.io.*;
import java.util.*;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;           // EOF
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    static class Edge implements Comparable<Edge> {
        double w; int u, v;
        Edge(double w, int u, int v) { this.w = w; this.u = u; this.v = v; }
        public int compareTo(Edge o) { return Double.compare(this.w, o.w); }
    }

    static int[] parent, rankArr;
    static void dsuInit(int n){
        parent = new int[n]; rankArr = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    static int find(int x){ return parent[x]==x ? x : (parent[x]=find(parent[x])); }
    static boolean union(int a, int b){
        a = find(a); b = find(b);
        if (a == b) return false;
        if (rankArr[a] < rankArr[b]) { int t=a; a=b; b=t; }
        parent[b] = a;
        if (rankArr[a] == rankArr[b]) rankArr[a]++;
        return true;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader(System.in);
        int T = fr.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int W = fr.nextInt();   // 줄바꿈이든 공백이든 안전
            int N = fr.nextInt();

            int[] x = new int[N];
            int[] y = new int[N];
            int[] r = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = fr.nextInt();
                y[i] = fr.nextInt();
                r[i] = fr.nextInt();
            }

            int L = N, R = N + 1;
            dsuInit(N + 2);

            List<Edge> edges = new ArrayList<>();
            edges.add(new Edge(W, L, R)); // 벽-벽

            // 센서-벽
            for (int i = 0; i < N; i++) {
                double leftGap  = x[i] - r[i];
                double rightGap = (W - x[i]) - r[i];
                edges.add(new Edge(Math.max(0.0, leftGap),  i, L));
                edges.add(new Edge(Math.max(0.0, rightGap), i, R));
            }

            // 센서-센서
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double center = Math.hypot(x[i] - x[j], y[i] - y[j]);
                    double gap = center - r[i] - r[j];
                    edges.add(new Edge(Math.max(0.0, gap), i, j));
                }
            }

            Collections.sort(edges);

            double answer = 0.0;
            for (Edge e : edges) {
                if (union(e.u, e.v) && find(L) == find(R)) {
                    answer = e.w / 2.0; // 최대 반지름
                    break;
                }
            }

            sb.append(String.format(Locale.US, "%.6f%n", answer));
        }

        System.out.print(sb.toString());
    }
}
