package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6_CatchingFlies3 {
    // + 모양(상하좌우)
    static final int[] dxPlus = {-1, 1, 0, 0};
    static final int[] dyPlus = {0, 0, -1, 1};
    // x 모양(대각선)
    static final int[] dxDiag = {-1, -1, 1, 1};
    static final int[] dyDiag = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] a = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 중심 포함
                    int sumPlus = a[x][y];
                    int sumDiag = a[x][y];

                    // + 모양
                    for (int dir = 0; dir < 4; dir++) {
                        for (int k = 1; k <= M - 1; k++) {
                            int nx = x + dxPlus[dir] * k;
                            int ny = y + dyPlus[dir] * k;
                            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                                sumPlus += a[nx][ny];
                            } else break; // 더 나가면 전부 경계 밖
                        }
                    }

                    // x 모양(대각)
                    for (int dir = 0; dir < 4; dir++) {
                        for (int k = 1; k <= M - 1; k++) {
                            int nx = x + dxDiag[dir] * k;
                            int ny = y + dyDiag[dir] * k;
                            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                                sumDiag += a[nx][ny];
                            } else break;
                        }
                    }

                    int best = Math.max(sumPlus, sumDiag);
                    if (best > cnt) cnt = best;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}