import java.io.*;
import java.util.*;

/**
 * BOJ 1826 - 연료 채우기
 * 아이디어: 현재 연료로 도달 가능한 주유소들을 모두 넣고(거리 <= cur),
 *           그 중 연료가 가장 큰 것부터 보충하는 그리디.
 *           도중에 더 이상 갈 수 없는데 힙이 비어 있으면 실패(-1).
 * 복잡도: O(N log N)
 */
public class Main {
    static class Station {
        int pos, fuel; // 시작점으로부터 거리, 보급 연료
        Station(int pos, int fuel) { this.pos = pos; this.fuel = fuel; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Station[] st = new Station[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            st[i] = new Station(a, b);
        }

        StringTokenizer last = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(last.nextToken()); // 목적지까지 거리
        int P = Integer.parseInt(last.nextToken()); // 초기 연료

        // 주유소를 위치(거리) 오름차순 정렬
        Arrays.sort(st, Comparator.comparingInt(o -> o.pos));

        // 최대 힙: 도달 가능한 주유소들의 연료량을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long cur = P;     // 현재 도달 가능한 최대 거리(= 현재 연료)
        int idx = 0;      // st에서 아직 처리하지 않은 첫 주유소 인덱스
        int count = 0;    // 멈춘(보급한) 횟수

        while (cur < L) {
            // 현재 연료로 도달 가능한 주유소를 모두 힙에 넣는다
            while (idx < N && st[idx].pos <= cur) {
                pq.offer(st[idx].fuel);
                idx++;
            }

            // 더 이상 갈 수 없는데(= cur < L) 보급 가능한 주유소도 없다면 실패
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            // 가장 많이 채울 수 있는 주유소에서 보급
            cur += pq.poll();
            count++;
        }

        System.out.println(count);
    }
}
