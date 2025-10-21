import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map; // 0: 빈칸, 1: 벽, 2: 청소됨

    // 0:북, 1:동, 2:남, 3:서 (문제 정의 그대로)
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }

    static int simulate() {
        int cleaned = 0;

        while (true) {
            // 1) 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소됨
                cleaned++;
            }

            // 2) 왼쪽부터 4칸 탐색
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = rotateLeft(d);
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (inBounds(nr, nc) && map[nr][nc] == 0) {
                    // 청소 안 된 빈칸 발견 → 전진
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 3) 네 방향 모두 못 갔으면 뒤로 후진 (방향 유지)
            int backR = r - dr[d];
            int backC = c - dc[d];

            // 뒤가 벽이면 작동 멈춤
            if (!inBounds(backR, backC) || map[backR][backC] == 1) {
                break;
            }

            // 벽이 아니면 후진만
            r = backR;
            c = backC;
        }

        return cleaned;
    }

    static int rotateLeft(int dir) {
        // 왼쪽 회전: 북(0)->서(3)->남(2)->동(1)->북(0)
        return (dir + 3) % 4;
    }

    static boolean inBounds(int rr, int cc) {
        return 0 <= rr && rr < N && 0 <= cc && cc < M;
    }
}
