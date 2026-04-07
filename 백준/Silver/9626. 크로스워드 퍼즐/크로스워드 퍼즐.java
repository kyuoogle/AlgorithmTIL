import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        char[][] a = new char[m + u + d][n + l + r];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[u + i][l + j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) sb.append(a[i][j]);
                else sb.append((i + j) % 2 == 0 ? '#' : '.');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}