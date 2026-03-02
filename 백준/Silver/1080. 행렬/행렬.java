import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        readMatrix(br, A);
        readMatrix(br, B);

        int cnt = 0;

        // 3x3 뒤집기를 적용할 수 있는 범위에서만 그리디로 맞추기
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip3x3(i, j);
                    cnt++;
                }
            }
        }

        // 최종 동일성 체크
        if (!isSame()) {
            System.out.println(-1);
            return;
        }

        System.out.println(cnt);
    }

    static void readMatrix(BufferedReader br, int[][] mat) throws IOException {
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                mat[i][j] = s.charAt(j) - '0';
            }
        }
    }

    static void flip3x3(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] ^= 1; // 0<->1
            }
        }
    }

    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}