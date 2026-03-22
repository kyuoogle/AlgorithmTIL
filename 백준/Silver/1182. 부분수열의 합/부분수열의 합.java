import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 공집합 제거
        if (S == 0) count--;

        System.out.println(count);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }

        // 포함
        dfs(idx + 1, sum + arr[idx]);

        // 미포함
        dfs(idx + 1, sum);
    }
}