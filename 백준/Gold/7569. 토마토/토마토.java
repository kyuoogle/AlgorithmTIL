import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H; // 가로 M(열), 세로 N(행), 높이 H(층)
    static int[][][] box;   // -1: 빈칸, 0: 익지않음, 1: 익음
    static int[][][] dist;  // 익는 데 걸린 일수 (시작 0)
    // 6방향: (행, 열, 층)
    static int[] di = {-1, 1, 0, 0, 0, 0};
    static int[] dj = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // ★ 차원 순서: [H][N][M]
        box  = new int[H][N][M];
        dist = new int[H][N][M];

        // dist 초기화: 미방문 = -1
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[h][i], -1);
            }
        }

        // 입력: 각 층마다 N줄, 한 줄에 M개
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(row.nextToken());
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        // 초기 익은 토마토들을 모두 큐에 넣고 dist=0
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 1) {
                        q.offer(new int[]{h, i, j});
                        dist[h][i][j] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ch = cur[0], ci = cur[1], cj = cur[2];

            for (int d = 0; d < 6; d++) {
                int nh = ch + dh[d];
                int ni = ci + di[d];
                int nj = cj + dj[d];

                // ★ 경계 체크 (0 <= < dim)
                if (nh < 0 || nh >= H || ni < 0 || ni >= N || nj < 0 || nj >= M) continue;

                // 빈칸(-1) 제외, 익지 않은 칸(0)만, 미방문(dist==-1)만
                if (box[nh][ni][nj] != 0) continue;
                if (dist[nh][ni][nj] != -1) continue;   // ★ 방문 체크는 dist로

                box[nh][ni][nj] = 1;
                dist[nh][ni][nj] = dist[ch][ci][cj] + 1;
                q.offer(new int[]{nh, ni, nj});
            }
        }

        int ans = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) return -1;       // 아직 안 익은 토마토 남음
                    if (dist[h][i][j] > ans) ans = dist[h][i][j];
                }
            }
        }
        return ans; // 모두 익는 최소 일수 (처음부터 모두 익음이면 0)
    }
}
