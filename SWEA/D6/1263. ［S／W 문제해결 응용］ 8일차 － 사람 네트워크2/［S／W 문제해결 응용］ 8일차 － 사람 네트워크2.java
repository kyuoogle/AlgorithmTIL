import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = 1_000_000_000; //굉장히 엄청나게 큰 수로
    static int[][] dist; // 거리 저장용 배열
    static int N; // 노드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 노드 수 입력 받기
            
            //주어진 노드 수 N * N 크기의 배열 선언
            dist = new int[N][N];
            
            //배열 초기화: 자기 자신과의 거리는 0으로 초기화하고, 나머지는 무한대로 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
            
            // 인접 행렬 정보 읽기 및 초기화
            // 한 칸씩 읽은 후, 자기 자신이 아닌데 값이 1이면, 
            // dist[i][j] = 1로 가중치 1 부여 (즉, 연결된 간선)
            // 값이 0 또는 자기 자신인 경우는 그대로 INF/0 유지
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (i != j && val == 1) {
                        dist[i][j] = 1;
                    }
                }
            }

            floydWarshall();

            int minCC = getMinCC();

            sb.append("#").append(tc).append(" ").append(minCC).append("\n");
        }
        System.out.print(sb);
    }
    
    // FloydWarshall 알고리즘: 모든 노드 k를 거쳐서 i->j 경로의 거리를 업데이트
    // - dist[i][k] + dist[k][j] < dist[i][j]인 경우 갱신
    // - INF인 경우 건너뛰기
    static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < N; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    // 문제에 주어진 대로 CC 최소값 계산
    // - 각 노드 i별로 모든 노드 j까지 최단거리의 합을 계산
    // - 그 중 문제에서 주어진대로 가장 작은 값을 계산
    static int getMinCC() {
        int minCC = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += dist[i][j];
            }
            minCC = Math.min(minCC, sum);
        }
        return minCC;
    }
}
