import java.io.*;
import java.util.*;

public class Main {
    static int L;
    static int[][] dist;
    static final int[] dr = {-2,-2,-1,-1, 1, 1, 2, 2};
    static final int[] dc = {-1, 1,-2, 2,-2, 2,-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            L = Integer.parseInt(br.readLine().trim());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());

            dist = new int[L][L];
            for (int i = 0; i < L; i++) Arrays.fill(dist[i], -1);

            out.append(bfs(sr, sc, tr, tc)).append('\n');
        }
        System.out.print(out);
    }

    static int bfs(int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[sr][sc] = 0;
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int t = dist[r][c];

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= L || nc < 0 || nc >= L) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = t + 1;
                if (nr == tr && nc == tc) return dist[nr][nc];
                q.add(new int[]{nr, nc});
            }
        }
        return -1;
    }
}
