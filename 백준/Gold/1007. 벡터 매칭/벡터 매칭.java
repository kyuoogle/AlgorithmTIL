import java.io.*;
import java.util.*;

public class Main {
    static int[][] P;
    static boolean[] positive;
    static double min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            P = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                P[i][0] = Integer.parseInt(st.nextToken());
                P[i][1] = Integer.parseInt(st.nextToken());
            }

            positive = new boolean[n];
            min = Double.MAX_VALUE;

            combination(0, n / 2);
            System.out.println(min);
        }
    }

    static void combination(int index, int cnt) {
        // n/2개 다 골랐으면 벡터 계산하고 종료
        if (cnt == 0) {
            min = Math.min(min, getVector());
            return;
        }

        // 끝까지 왔는데 아직 더 골라야 하면 종료
        if (index == P.length) return;

        // 남은 점 개수로 cnt개를 못 채우면 가지치기
        if (P.length - index < cnt) return;

        for (int i = index; i < P.length; i++) {
            positive[i] = true;
            combination(i + 1, cnt - 1);
            positive[i] = false;
        }
    }

    static double getVector() {
        long sum_x = 0;
        long sum_y = 0;

        for (int i = 0; i < P.length; i++) {
            if (positive[i]) {
                sum_x += P[i][0];
                sum_y += P[i][1];
            } else {
                sum_x -= P[i][0];
                sum_y -= P[i][1];
            }
        }

        return Math.sqrt(sum_x * sum_x + sum_y * sum_y);
    }
}