import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int sr = -1, sc = -1;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') { sr = i; sc = j; }
            }
        }

        System.out.println(bfs(sr, sc));
    }

    static int bfs(int sr, int sc) {
        visited = new boolean[N][M][64];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0, 0}); // r, c, key, dist
        visited[sr][sc][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], k = cur[2], d = cur[3];

            if (map[r][c] == '1') return d; // 목표 도착

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nk = k;

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                char cell = map[nr][nc];
                if (cell == '#') continue;

                // 문이면 키 확인
                if (cell >= 'A' && cell <= 'F') {
                    int need = 1 << (cell - 'A');
                    if ((nk & need) == 0) continue;
                }

                // 키면 획득
                if (cell >= 'a' && cell <= 'f') {
                    nk |= 1 << (cell - 'a');
                }

                if (!visited[nr][nc][nk]) {
                    visited[nr][nc][nk] = true;
                    q.offer(new int[]{nr, nc, nk, d + 1});
                }
            }
        }
        return -1;
    }
}
