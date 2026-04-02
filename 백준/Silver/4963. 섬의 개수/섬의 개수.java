import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static int[][] a;
    static boolean[][] v;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            a = new int[h][w];
            v = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) a[i][j] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1 && !v[i][j]) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static void dfs(int x, int y) {
        v[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (a[nx][ny] == 0 || v[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
}