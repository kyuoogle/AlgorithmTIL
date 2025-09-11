import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = 1_000_000_000;
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (i != j && val == 1) {
                        dist[i][j] = 1;
                    }
                }
            }

            floydWarshall();

            int minCC = getMinCC();

            sb.append("#").append(tc).append(" ").append(minCC).append("\n");
        }

        System.out.print(sb);
    }

    static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < N; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    static int getMinCC() {
        int minCC = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += dist[i][j];
            }
            minCC = Math.min(minCC, sum);
        }
        return minCC;
    }
}
