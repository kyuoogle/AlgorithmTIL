import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // TiPi[i][1] = T[i] (소요 기간), TiPi[i][2] = P[i] (수익)
        int[][] TiPi = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            TiPi[i][1] = Integer.parseInt(st.nextToken()); // T[i]
            TiPi[i][2] = Integer.parseInt(st.nextToken()); // P[i]
        }

        // dp[d] = d일 '아침'까지 얻을 수 있는 최대 이익
        // 인덱스 0..N+1 사용 (0은 시작 전 상태, N+1은 마지막 날 다음날)
        int[] dp = new int[N + 2]; // 기본값 0

        // 3) 정방향 갱신: i = 1..N
        for (int i = 1; i <= N; i++) {
            // (1) 전날의 최대 이익을 오늘 아침으로 캐리 (쉬는 선택)
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // (2) i일에 상담을 선택하는 경우, 상담이 끝나는 날의 아침(end)로 이익 전파
            int t = TiPi[i][1];
            int p = TiPi[i][2];
            int end = i + t; // 이 상담이 끝난 다음 시작 가능한 날 (N+1까지 허용)

            if (end <= N + 1) {
                dp[end] = Math.max(dp[end], dp[i] + p);
            }
        }

        // 마지막 날의 결과도 N+1로 캐리
        dp[N + 1] = Math.max(dp[N + 1], dp[N]);

        // N+1일 아침까지의 최대 이익
        System.out.println(dp[N + 1]);
    }
}
