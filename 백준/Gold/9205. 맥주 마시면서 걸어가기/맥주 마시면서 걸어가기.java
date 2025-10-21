import java.io.*;
import java.util.*;

public class Main {

    static final int LIMIT = 1000; // 20병 × 50m
    static int T, n;
    static int[][] points; // [i][0]=x, [i][1]=y  (0: start, 1..n: stores, n+1: fest)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            points = new int[n + 2][2];
            // start
            points[0] = readPoint(br);
            // stores
            for (int i = 1; i <= n; i++) points[i] = readPoint(br);
            // festival
            points[n + 1] = readPoint(br);

            sb.append(bfs() ? "happy" : "sad").append('\n');
        }
        System.out.print(sb.toString());
    }

    static int[] readPoint(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    }

    static boolean bfs() {
        boolean[] visited = new boolean[n + 2];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 위치에서 바로 페스티벌 갈 수 있으면 끝
            if (dist(cur, n + 1) <= LIMIT) return true;

            // 아직 안 들른 편의점들 중 이동 가능한 곳 큐에 추가
            for (int next = 1; next <= n; next++) {
                if (!visited[next] && dist(cur, next) <= LIMIT) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }

    static int dist(int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
