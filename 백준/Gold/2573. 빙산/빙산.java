import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] A;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        int year = 0;
        while (true) {
            int comps = countComponents();
            if (comps >= 2) { System.out.println(year); return; }
            if (isAllZero()) { System.out.println(0); return; }

            // 1) 동시에 녹이기 위한 감소량 계산
            int[][] dec = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] <= 0) continue;
                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                        if (A[ni][nj] == 0) sea++;
                    }
                    dec[i][j] = sea;
                }
            }
            // 2) 동시 업데이트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] > 0) {
                        A[i][j] = Math.max(0, A[i][j] - dec[i][j]);
                    }
                }
            }
            year++;
        }
    }

    static int countComponents() {
        vis = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] > 0 && !vis[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int si, int sj) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{si, sj});
        vis[si][sj] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (vis[nx][ny] || A[nx][ny] == 0) continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    static boolean isAllZero() {
        for (int[] row : A) for (int v : row) if (v > 0) return false;
        return true;
    }
}
