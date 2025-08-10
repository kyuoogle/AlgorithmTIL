package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_계곡찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            //배열의 크기 선언 및 2차원 배열 선언
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            // 각 칸에 입력 받은 값 대입
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int cnt = 0;

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    boolean isValley = true;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (arr[nx][ny] <= arr[i][j]) {
                            isValley = false;
                            break;
                        }
                    }
                    if (isValley) cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}
