import java.util.*;
import java.io.*;

public class Main {
    // 문제 범위: 위치 0 ~ 100000
    static final int MAX = 100000;

    // 입력값 (필드로 보관: 섀도잉 방지)
    static int N, K;

    // 방문 체크 & 거리(시간)
    static boolean[] visited;
    static int[] dist = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지역변수로 새로 선언하지 말고, 필드에 대입(섀도잉 방지)
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // visited 배열 반드시 생성해야 함 (안 하면 NPE)
        visited = new boolean[MAX + 1];

        // N == K면 0초 (바로 종료)
        if (N == K) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();

        // 시작 상태 세팅
        q.add(N);
        visited[N] = true;
        dist[N] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            // 다음으로 이동 가능한 세 가지 후보
            int[] nxt = { curr - 1, curr + 1, curr * 2 };

            for (int nx : nxt) {
                // 경계 체크: 0 이상 MAX 이하, 아직 방문 X
                if (nx >= 0 && nx <= MAX && !visited[nx]) {
                    visited[nx] = true;          // 방문 처리
                    dist[nx] = dist[curr] + 1;   // 시간(거리) 갱신
                    if (nx == K) return dist[nx]; // 도착 즉시 최소 시간
                    q.add(nx);                   // 큐에 넣고 계속 탐색
                }
            }
        }

        // 문제 조건상 도달 불가는 없음
        return -1;
    }
}
