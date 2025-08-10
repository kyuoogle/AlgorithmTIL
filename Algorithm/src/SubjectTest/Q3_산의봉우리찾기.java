package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_산의봉우리찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] nums = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    nums[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    boolean isPeak = true;

                    for (int d = 0; d < dx.length; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (nums[nx][ny] >= nums[i][j]) {
                                isPeak = false;
                                break;
                            }
                        }
                    }
                    if (isPeak) cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}
