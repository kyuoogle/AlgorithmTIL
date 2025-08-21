import java.io.*;
import java.util.*;

public class Main {

    // 1-based Fenwick Tree (BIT)
    static class Fenwick {
        int n;
        int[] bit;
        Fenwick(int n) {
            this.n = n;
            this.bit = new int[n + 1];
        }
        // add delta at idx
        void add(int idx, int delta) {
            for (; idx <= n; idx += idx & -idx) bit[idx] += delta;
        }
        // prefix sum [1..idx]
        int sum(int idx) {
            int s = 0;
            for (; idx > 0; idx -= idx & -idx) s += bit[idx];
            return s;
        }
        // smallest idx such that sum(idx) >= k (k >= 1, and always exists)
        int lowerBound(int k) {
            int idx = 0;
            int step = Integer.highestOneBit(n);
            for (; step != 0; step >>= 1) {
                int next = idx + step;
                if (next <= n && bit[next] < k) {
                    k -= bit[next];
                    idx = next;
                }
            }
            return idx + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Fenwick 초기화: 모두 살아있음을 1로 표시
        Fenwick fw = new Fenwick(N);
        for (int i = 1; i <= N; i++) fw.add(i, 1);

        sb.append('<');

        long pos = 0;       // 현재 "살아있는 사람들" 중에서의 0-based 순번
        int alive = N;      // 남은 인원 수

        for (int cnt = 0; cnt < N; cnt++) {
            // 다음 제거될 사람의 순번 (0-based)
            pos = (pos + K - 1) % alive;

            // 1-based로 변환해서 k번째 살아있는 사람의 '원래 번호'를 찾음
            int kth = (int) pos + 1;
            int idx = fw.lowerBound(kth); // 원래 번호

            // 출력
            sb.append(idx);
            if (cnt != N - 1) sb.append(", ");

            // 제거: alive[idx] = 0
            fw.add(idx, -1);
            alive--; // 다음 라운드에서 모듈러 기준 줄어듦
            // pos는 그대로 두면 "방금 지운 자리의 다음 사람"을 자연스럽게 가리킴
        }

        sb.append('>');
        System.out.println(sb.toString());
    }
}
