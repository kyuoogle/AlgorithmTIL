import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isComposite = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        // 에라토스테네스의 체
        for (int i = 2; i * i <= n; i++) {
            if (isComposite[i]) continue;

            for (int j = i * i; j <= n; j += i) {
                isComposite[j] = true;
            }
        }

        for (int i = Math.max(2, m); i <= n; i++) {
            if (!isComposite[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}