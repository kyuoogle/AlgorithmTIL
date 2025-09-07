import java.io.*;
import java.util.*;

public class Solution {

    // L일 동안 스케줄이 가능한지 검사
    private static boolean feasible(long ones, long twos, int L) {
        long odd  = (L + 1L) / 2; // L일 중 홀수날(+1 가능) 수
        long even = L / 2;        // L일 중 짝수날(+2 가능) 수

        // 짝수날이 부족하면 부족분을 홀수날 2번(+1,+1)으로 대체
        long missEven = Math.max(0L, twos - even);
        long needOdd  = ones + 2L * missEven;

        return needOdd <= odd;
    }

    // 최소 날짜 L 계산 (상한선 고정값 없이 int로 지수 탐색 -> 이분 탐색)
    private static int minDays(int[] heights) {
        int maxH = 0;
        for (int h : heights) maxH = Math.max(maxH, h);

        long ones = 0; // diff의 홀수 부분(+1 필수)
        long twos = 0; // diff의 2로 나눈 몫(+2로 처리 가능한 양)
        for (int h : heights) {
            int diff = maxH - h;
            ones += (diff % 2);
            twos += (diff / 2);
        }

        // 이미 모두 같다면 0일
        if (ones == 0 && twos == 0) return 0;

        // 지수 탐색으로 가능한 hi 찾기 (고정 상한 미사용, int 범위 내에서 증가)
        int lo = 0;
        int hi = 1;
        while (!feasible(ones, twos, hi)) {
            // hi를 두 배로 키우며 가능한 날을 찾는다.
            // int 오버플로우 방지: 최댓값에 근접하면 마지막으로 Integer.MAX_VALUE로 고정
            if (hi > Integer.MAX_VALUE / 2) {
                hi = Integer.MAX_VALUE;
                break;
            }
            hi <<= 1; // hi *= 2
        }

        // [lo, hi]에서 이분 탐색으로 최소 L
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(ones, twos, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] heights = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            int ans = minDays(heights);
            System.out.println("#" + tc + " " + ans);
        }
    }
}
