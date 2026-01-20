import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[30][30];

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // n <= m
            int n = Integer.parseInt(st.nextToken()); // 서쪽
            int m = Integer.parseInt(st.nextToken()); // 동쪽

            System.out.println(factorial(m, n));
        }
    }
    static int factorial(int n, int r) {

        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = factorial(n-1, r-1) + factorial(n-1, r);
    }

}