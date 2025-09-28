import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[Math.max(4, N + 1)]; // 계단 점수
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        // N이 작은 경우 바로 처리
        if (N == 1) {
            System.out.println(a[1]);
            return;
        }
        if (N == 2) {
            System.out.println(Math.max(a[1] + a[2], a[2])); // 1+2번 or 2번만
            return;
        }

        int[] dp = new int[N + 1];

        dp[1] = a[1];
        dp[2] = Math.max(a[1] + a[2], a[2]); // 1+2번 or 2번만
        dp[3] = Math.max(a[1] + a[3], a[2] + a[3]); // (1→3) vs (2→3)

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]);
        }

        System.out.println(dp[N]);
    }
}
