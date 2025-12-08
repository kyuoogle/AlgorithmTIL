import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] map;
    static int[][] memo;   // 각 칸에서 시작했을 때 등산로 길이

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 규칙: 더 낮은 곳 중에서 '가장 낮은 곳' 단 하나로만 이동
    static int getLength(int x, int y) {
        if (memo[x][y] != 0) return memo[x][y];

        int cur = map[x][y];
        int minLower = Integer.MAX_VALUE;
        int nx = -1, ny = -1;

        // 더 낮은 곳 중 최저 지점 찾기
        for (int d = 0; d < 4; d++) {
            int tx = x + dx[d];
            int ty = y + dy[d];

            if (tx < 0 || ty < 0 || tx >= N || ty >= N) continue;

            if (map[tx][ty] < cur) {
                if (map[tx][ty] < minLower) {
                    minLower = map[tx][ty];
                    nx = tx;
                    ny = ty;
                }
            }
        }

        // 더 낮은 곳이 없다면 길이 = 1 (자기 자신만)
        if (nx == -1) {
            return memo[x][y] = 1;
        }

        // 더 낮은 곳 중 최저점으로만 이동
        return memo[x][y] = 1 + getLength(nx, ny);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            memo = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, getLength(i, j));
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
