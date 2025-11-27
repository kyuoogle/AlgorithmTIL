import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); // 사진 데이터 개수

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 세로
            int M = Integer.parseInt(st.nextToken()); // 가로

            int[][] map = new int[N][M];

            // 사진 데이터 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxLen = 0;

            // 1. 가로(행) 방향 구조물 길이 검사
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                    } else {
                        if (cnt > maxLen) maxLen = cnt;
                        cnt = 0;
                    }
                }
                // 행 끝났을 때도 한 번 더 체크
                if (cnt > maxLen) maxLen = cnt;
            }

            // 2. 세로(열) 방향 구조물 길이 검사
            for (int j = 0; j < M; j++) {
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) {
                        cnt++;
                    } else {
                        if (cnt > maxLen) maxLen = cnt;
                        cnt = 0;
                    }
                }
                // 열 끝났을 때도 한 번 더 체크
                if (cnt > maxLen) maxLen = cnt;
            }

            sb.append('#').append(tc).append(' ')
              .append(maxLen).append('\n');
        }

        System.out.print(sb.toString());
    }
}
