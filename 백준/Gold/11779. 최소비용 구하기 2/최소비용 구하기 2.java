import java.io.*;
import java.util.*;

/**
 * BOJ 11779 - 최소비용 구하기 2
 *  - 방향 그래프에서 start -> goal 까지의 최소 비용과, 그 때의 실제 경로를 출력.
 */
public class Main {

    /** 인접 리스트용 간선 구조체: to(다음 정점), w(간선 비용) */
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    /**
     * 우선순위 큐에 넣는 상태(정점 v, 현재까지의 최단거리 dist).
     * dist 오름차순으로 꺼내야 하므로 Comparable 구현.
     */
    static class State implements Comparable<State> {
        int v;        // 현재 정점
        long dist;    // 시작점으로부터 v 까지의 (우리가 알고 있는) 최단거리
        State(int v, long dist) { this.v = v; this.dist = dist; }
        public int compareTo(State o) { return Long.compare(this.dist, o.dist); }
    }

    static final long INF = Long.MAX_VALUE / 4;

    static int N, M;                 // N: 정점(도시) 수, M: 간선(버스) 수
    static List<Edge>[] graph;       // 그래프 인접 리스트
    static long[] dist;              // dist[x] = 시작점 -> x 최단거리
    static int[] prev;               // prev[x] = x 로 오기 직전의 정점(경로 복원용)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 정점 수
        M = Integer.parseInt(br.readLine()); // 간선 수

        // 인접 리스트 초기화 (1..N 사용)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 간선 입력: a -> b 비용 c (방향 그래프)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        // 시작점, 도착점
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal  = Integer.parseInt(st.nextToken());

        // 거리/이전 정점 배열 준비
        dist = new long[N + 1];
        prev = new int[N + 1];

        dijkstra(start);

        List<Integer> path = buildPath(goal);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[goal]).append('\n');      // 최소 비용
        sb.append(path.size()).append('\n');     // 도시 수
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(path.get(i));
        }
        System.out.println(sb.toString());
    }

    /**
     * 다익스트라: 시작점 s 로부터 모든 정점까지의 최단거리 계산.
     * - 방문 확정된 정점은 visited[v] = true 로 표시하고 재처리하지 않음.
     * - 완화(relaxation) 시 prev[to] = v 로 이전 정점을 기록.
     */
    static void dijkstra(int s) {
        Arrays.fill(dist, INF);  // 초기엔 모두 무한대로
        Arrays.fill(prev, -1);   // 경로 복원용 이전 정점 초기화(-1 = 없음)

        PriorityQueue<State> pq = new PriorityQueue<>(); // (거리 오름차순) 최소 힙
        boolean[] visited = new boolean[N + 1];          // 최단거리 확정 여부

        dist[s] = 0;                 // 시작점까지 거리는 0
        pq.add(new State(s, 0));     // 시작점 push

        while (!pq.isEmpty()) {
            State cur = pq.poll();   // 가장 가까운 정점 추출
            int v = cur.v;

            // 이미 더 좋은 경로로 확정된 정점이면 스킵
            if (visited[v]) continue;
            visited[v] = true;       // 이제 v 의 최단거리는 확정

            // v 에서 나가는 모든 간선에 대해 완화 시도
            for (Edge e : graph[v]) {
                long nd = dist[v] + e.w;        // v를 거쳐 e.to 로 가는 비용 후보
                if (nd < dist[e.to]) {          // 더 짧으면 갱신
                    dist[e.to] = nd;
                    prev[e.to] = v;             // 경로 복원: e.to 의 직전은 v
                    pq.add(new State(e.to, nd)); // 갱신된 거리로 큐에 삽입
                }
            }
        }
    }

    /**
     * prev[] 를 이용해 goal 까지의 경로를 복원.
     * - goal 부터 prev 를 타고 거슬러 올라가며 덱 앞에 넣는다(addFirst)
     * - 최종적으로 start -> ... -> goal 순서의 리스트 반환
     *
     * 주의: start 의 prev 는 -1 이므로 루프 종료 조건은 v != -1
     */
    static List<Integer> buildPath(int goal) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int v = goal; v != -1; v = prev[v]) dq.addFirst(v);
        return new ArrayList<>(dq);
    }
}
