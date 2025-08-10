package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_SpringCooler {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = arr[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            sum += arr[nx][ny];
                        }
                    }
                    if (sum > ans) ans = sum;
                }
            }
            System.out.println("#" + tc + " "  + ans);
        }
    }
}
