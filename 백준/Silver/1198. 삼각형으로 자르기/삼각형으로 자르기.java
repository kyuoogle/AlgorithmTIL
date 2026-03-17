import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        double max = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, area(p[i], p[j], p[k]));
                }
            }
        }

        System.out.println(max);
    }

    static double area(int[] a, int[] b, int[] c) {
        return Math.abs(
                a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
              - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]
        ) / 2.0;
    }
}