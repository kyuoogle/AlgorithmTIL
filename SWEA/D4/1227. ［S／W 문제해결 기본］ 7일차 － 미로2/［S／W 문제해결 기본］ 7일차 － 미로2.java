import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static boolean isSuccess = false;
    static boolean[][] visited;
    static int[][] maze;

    // 델타배열 (상, 하, 좌, 우)
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10; // 테스트케이스 수 10개

        for (int tc = 1; tc <= T; tc++) {
            // 테스트케이스 번호
            int tcNum = Integer.parseInt(br.readLine().trim());

            // 100x100 미로 입력
            maze = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String temp = br.readLine();
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = temp.charAt(j) - '0';
                }
            }

            // 시작점(2), 도착점(3) 찾기
            int sx = -1, sy = -1, ex = -1, ey = -1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (maze[i][j] == 2) { sx = i; sy = j; }
                    if (maze[i][j] == 3) { ex = i; ey = j; }
                }
            }

            // 초기화
            isSuccess = false;
            visited = new boolean[100][100];

            // DFS 시작 (시작점이 유효할 때만)
            if (sx != -1 && sy != -1) dfs(sx, sy, ex, ey);

            // 출력: isSuccess로 판단
            System.out.println("#" + tcNum + (isSuccess ? " 1" : " 0"));
        }
    }

    private static void dfs(int x, int y, int ex, int ey) {
        // 경계/벽/방문 체크
        if (x < 0 || y < 0 || x >= 100 || y >= 100) return;
        if (maze[x][y] == 1 || visited[x][y]) return;

        // 방문 처리 먼저
        visited[x][y] = true;

        // 도착점 도달
        if (x == ex && y == ey) {
            isSuccess = true;
            return;
        }

        // 이미 성공했으면 더 깊게 안 들어감(가지치기)
        if (isSuccess) return;

        // 4방 탐색
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (!isSuccess) dfs(nx, ny, ex, ey);
        }
    }
}
