import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int price = 0, max = 0;
        int r = Math.min(n, m);

        for (int i = 0; i < r; i++) {
            int v = a[m - 1 - i] * (i + 1);
            if (v > max) {
                max = v;
                price = a[m - 1 - i];
            }
        }

        System.out.println(price + " " + max);
    }
}