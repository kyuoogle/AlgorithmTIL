import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스 수

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            // 모든 칸을 중심 풍선으로 가정
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    int sum = map[x][y]; // 자기 자신

                    // 상하좌우 4방향
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        // 범위 안에 있을 때만 더함
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            sum += map[nx][ny];
                        }
                    }

                    if (sum > max) max = sum;
                }
            }

            sb.append('#').append(tc).append(' ')
              .append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
