import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); // 출력 효율

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];   // 실제 입력 배열 (1-indexed)
        int[] prefix = new int[N + 1]; // 누적합 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + nums[i]; // 누적합 계산
        }

        // M개의 구간 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 구간 [a, b] 합 = prefix[b] - prefix[a - 1]
            sb.append(prefix[b] - prefix[a - 1]).append('\n');
        }

        System.out.print(sb);
    }
}
