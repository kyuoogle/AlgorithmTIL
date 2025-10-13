import java.io.*;
import java.util.*;


public class Main {
    static int N, M, K;
    static char[][] board;
    static int[][][] dist;       // dist[r][c][b]
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 부술 수 있는 최대 벽 개수

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim(); // 공백 없이 0/1
            for (int j = 0; j < M; j++) board[i][j] = line.charAt(j);
        }

        dist = new int[N][M][K + 1];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                Arrays.fill(dist[i][j], -1);

        System.out.println(bfs());
    }

    public static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 시작점 (0,0)에서 벽 0개 부순 상태, 거리 1
        dist[0][0][0] = 1;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], b = cur[2];

            // 도착 지점에 처음 도달했을 때의 dist가 최단거리
            if (r == N - 1 && c == M - 1) return dist[r][c][b];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (board[nr][nc] == '0') {
                    // 빈칸: 벽을 더 부수지 않고 이동
                    if (dist[nr][nc][b] == -1) {
                        dist[nr][nc][b] = dist[r][c][b] + 1;
                        q.offer(new int[]{nr, nc, b});
                    }
                } else { // '1' = 벽
                    if (b < K && dist[nr][nc][b + 1] == -1) {
                        dist[nr][nc][b + 1] = dist[r][c][b] + 1;
                        q.offer(new int[]{nr, nc, b + 1});
                    }
                }
            }
        }
        return -1; // 어떤 상태로도 도달 불가
    }
}
