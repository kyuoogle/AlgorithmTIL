import java.io.*;
import java.util.*;

public class Main {

    static int n, k, cnt, res = -1;
    static int[] a, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        sort(0, n - 1);
        System.out.println(res);
    }

    static void sort(int s, int e) {
        if (s >= e || cnt >= k) return;

        int m = (s + e) >> 1;
        sort(s, m);
        sort(m + 1, e);
        merge(s, m, e);
    }

    static void merge(int s, int m, int e) {
        int i = s, j = m + 1, t = s;

        while (i <= m && j <= e) {
            if (a[i] <= a[j]) tmp[t++] = a[i++];
            else tmp[t++] = a[j++];
        }

        while (i <= m) tmp[t++] = a[i++];
        while (j <= e) tmp[t++] = a[j++];

        for (int x = s; x <= e; x++) {
            cnt++;
            if (cnt == k) res = tmp[x];
            a[x] = tmp[x];
        }
    }
}