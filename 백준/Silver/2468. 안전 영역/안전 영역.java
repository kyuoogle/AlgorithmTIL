import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);   // ★ fix
            }
        }

        int ans = 0;
        // 비의 높이 0 ~ maxH까지 모두 검사 (maxH에서도 cnt=0이지만 영향 없음)
        for (int r = 0; r <= maxH; r++) {           // ★ fix
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > r) {
                        bfs(i, j, r);
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    public static void bfs(int sx, int sy, int rain) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] <= rain) continue;  // 잠긴 곳은 패스

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
