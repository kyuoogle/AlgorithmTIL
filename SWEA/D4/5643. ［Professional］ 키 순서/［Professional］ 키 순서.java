import java.io.*;
import java.util.*;

public class Solution  {
    static final int INF = 1000000000; // 매우 큰 수로 무한대를 표현
    static int[][] map; // 키 비교 관계를 저장할 인접 행렬
    static int N, M;     // N: 학생 수, M: 키 비교 횟수(간선 수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            // 한 줄에 N과 M 입력 받음 (학생 수와 키 비교 횟수)
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            // 학생 번호가 1부터 시작하므로 배열 크기를 N+1로 설정
            map = new int[N + 1][N + 1];

            // 모든 거리를 무한대로 초기화하고, 자기 자신과의 거리는 0으로 초기화
            for (int i = 1; i <= N; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }

            // 키 비교 결과 입력 (start가 end보다 키가 작다)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); // 키가 작은 학생
                int end = Integer.parseInt(st.nextToken());   // 키가 큰 학생
                map[start][end] = 1;  // 방향 그래프의 간선 추가
            }

            // 모든 학생 간의 키 관계 최단 경로 계산 (플로이드-워셜)
            floydWarshall();

            int ans = 0;
            int[] cnt = new int[N + 1]; // 각 학생별로 키 비교 가능한 학생 수 카운트

            // 각 학생 i에 대해 다른 학생들과 키 관계가 확실한지 확인
            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue; // 자기 자신은 제외
                    
                    // i가 j보다 작거나, j가 i보다 작으면 관계 확실
                    if (map[i][j] != INF || map[j][i] != INF) {
                        count++;
                    }
                }
                cnt[i] = count;
            }

            // 자신을 제외한 모든 학생과 관계가 확실하면 count == N-1
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == N - 1) ans++;
            }

            System.out.println("#" + tc + " " + ans);

        }
    }

    // 플로이드-워셜 알고리즘으로 모든 정점 쌍의 최단 경로를 구함
    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (map[i][k] == INF) continue; // i에서 k로 가는 경로 없으면 스킵
                for (int j = 1; j <= N; j++) {
                    if (map[k][j] == INF) continue; // k에서 j로 가는 경로 없으면 스킵
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        // k를 거치는 경로가 더 짧으면 갱신
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}
