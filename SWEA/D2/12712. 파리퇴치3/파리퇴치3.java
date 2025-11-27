import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());    // 사진 데이터 개수

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());      // 배열 크기
            int M = Integer.parseInt(st.nextToken());      // 스프레이 세기

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 델타: + 모양 (상, 하, 좌, 우)
            int[] dxPlus = {-1, 1, 0, 0};
            int[] dyPlus = {0, 0, -1, 1};

            // 델타: x 모양 (좌상, 우상, 좌하, 우하)
            int[] dxDiag = {-1, -1, 1, 1};
            int[] dyDiag = {-1, 1, -1, 1};

            int max = 0;

            // 모든 칸을 중심으로 검사
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {

                    // 1. + 모양 스프레이
                    int sumPlus = map[x][y];   // 중심 포함
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = x + dxPlus[d] * k;
                            int ny = y + dyPlus[d] * k;

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            sumPlus += map[nx][ny];
                        }
                    }

                    // 2. x 모양 스프레이
                    int sumDiag = map[x][y];   // 중심 포함
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = x + dxDiag[d] * k;
                            int ny = y + dyDiag[d] * k;

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            sumDiag += map[nx][ny];
                        }
                    }

                    // 둘 중 큰 값으로 최댓값 갱신
                    max = Math.max(max, Math.max(sumPlus, sumDiag));
                }
            }

            sb.append('#').append(tc).append(' ')
              .append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
