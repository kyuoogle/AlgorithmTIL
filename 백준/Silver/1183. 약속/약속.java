import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        if ((n & 1) == 1) System.out.println(1);
        else System.out.println(Math.abs(a[n/2] - a[n/2 - 1]) + 1);
    }
}