import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 정상 시야
        int normalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normalCnt++;
                }
            }
        }

        // 색약 시야: G를 R로 통합
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        // 방문 배열 초기화
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);

        int abnormalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    abnormalCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + abnormalCnt);
    }

    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }
}
