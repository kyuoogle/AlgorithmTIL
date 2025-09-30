import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총감독
        int C = Integer.parseInt(st.nextToken()); // 부감독

        long total = N; // 각 시험장에 총감독 1명은 무조건 배치
        for (int i = 0; i < N; i++) {
            long remain = (long)a[i] - B; // 남은 인원(음수 가능)
            if (remain > 0) {
                // 부감독 수 = ceil(remain / C)
                total += (remain + C - 1) / C;
            }
        }

        System.out.println(total);
    }
}
