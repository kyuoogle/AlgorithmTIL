import java.util.*;
import java.io.*;

public class Main {
    static int M, N;          // 가로 M(열), 세로 N(행)
    static int[][] box;       // -1: 빈칸, 0: 익지않음, 1: 익음
    static int[][] dist;      // 익는 데 걸린 일수 (시작 0)
    // 4방향: 상/하/좌/우 (행, 열)
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        // 입력 형식: M N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 차원: [N][M]
        box  = new int[N][M];
        dist = new int[N][M];

        // dist 초기화: 미방문 = -1
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 입력 + 초기 익은 토마토들을 큐에 담기
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(row.nextToken());
                if (box[i][j] == 1) {
                    // 시작점: 이미 익은 토마토들
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                // 경계 체크
                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;

                // 빈칸(-1)은 제외, 익지 않은 칸(0)만 진행
                if (box[ni][nj] != 0) continue;

                // 아직 방문 안 한 칸만
                if (dist[ni][nj] != -1) continue;

                box[ni][nj] = 1;                         // 익음 처리
                dist[ni][nj] = dist[ci][cj] + 1;         // 일수 갱신
                q.offer(new int[]{ni, nj});
            }
        }

        // 결과 계산: 안 익은 토마토(0)가 남아 있으면 -1, 아니면 최대 dist
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {        // 아직 안 익은 토마토가 존재
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);              // 모두 익는 최소 일수 (처음부터 모두 익었으면 0)
    }
}
