package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5_CatchingFlies1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxFlies = 0;

            // 파리채의 시작점(왼쪽 위)을 탐색
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int currentFlies = 0;
                    // M x M 영역 안의 파리 수 계산
                    // 이 부분이 M x M 영역을 탐색하는 델타 배열과 같은 역할을 함
                    for (int row_delta = 0; row_delta < M; row_delta++) {
                        for (int col_delta = 0; col_delta < M; col_delta++) {
                            currentFlies += board[i + row_delta][j + col_delta];
                        }
                    }

                    // 최대값 갱신
                    if (currentFlies > maxFlies) {
                        maxFlies = currentFlies;
                    }
                }
            }
            System.out.println("#" + tc + " " + maxFlies);
        }


    }
}
