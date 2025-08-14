package Heap_and_IM;

import java.io.*;

public class SWEA_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            // 공백 없이 붙어있는 숫자 문자열 처리
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }

            int sum = 0;
            int start = N / 2;
            int end = N / 2;
            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    sum += farm[i][j];
                }
                if (i < N / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
