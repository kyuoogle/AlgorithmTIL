import java.io.*;
import java.util.*;

/**
 * BOJ 15686 - 치킨 배달
 * BFS 풀이 (멀티 소스 BFS)
 * - 치킨집 중 M개를 조합으로 고르고,
 * - 선택된 치킨집들을 모두 큐에 넣어 멀티 소스 BFS를 수행해
 *   모든 칸의 '가장 가까운 치킨집까지 거리'를 구한다.
 * - 집(1) 위치들의 거리만 합산하여 최솟값을 갱신한다.
 */
public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    static int N, M;
    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int C;

    static int answer = Integer.MAX_VALUE;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader(System.in);
        N = fr.nextInt();
        M = fr.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = fr.nextInt();
                if (map[i][j] == 1) houses.add(new int[]{i, j});
                else if (map[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }
        C = chickens.size();

        // 치킨집 인덱스 중 M개 조합 생성
        combBFS(0, 0, new int[M]);

        System.out.println(answer);
    }

    /** 치킨집 C개 중 M개 고르기 (idx: 현재 치킨 인덱스, cnt: 고른 수) */
    static void combBFS(int idx, int cnt, int[] picked) {
        if (cnt == M) {
            // 선택된 치킨집들로 멀티 소스 BFS 수행 후, 집 거리 합 계산
            int sum = bfsCityChickenDistance(picked);
            if (sum < answer) answer = sum;
            return;
        }
        if (idx == C) return;
        // 남은 개수로도 M개 채울 수 없으면 중단 (가지치기)
        if (cnt + (C - idx) < M) return;

        // 1) 현재 치킨집 선택
        picked[cnt] = idx;
        combBFS(idx + 1, cnt + 1, picked);

        // 2) 현재 치킨집 미선택
        combBFS(idx + 1, cnt, picked);
    }

    /** 멀티 소스 BFS: 선택된 치킨집들을 모두 시작점(거리0)으로 큐에 넣고 확산 */
    static int bfsCityChickenDistance(int[] picked) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 선택된 치킨집들을 모두 시작점으로 세팅
        for (int idx : picked) {
            int[] ch = chickens.get(idx);
            dist[ch[0]][ch[1]] = 0;
            q.offer(new int[]{ch[0], ch[1]});
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d], nj = cj + dj[d];
                if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if (dist[ni][nj] != -1) continue;
                dist[ni][nj] = dist[ci][cj] + 1;
                q.offer(new int[]{ni, nj});
            }
        }

        // 집들의 거리만 합산
        int sum = 0;
        for (int[] h : houses) {
            sum += dist[h[0]][h[1]];
            // 소폭 가지치기: 현재 합이 전역 최솟값 이상이면 조기 종료
            if (sum >= answer) return sum;
        }
        return sum;
    }
}
