import java.io.*;
import java.util.*;

/*
 * MST 문제
 * - 이번엔 Prim 알고리즘으로 풀어보자
 * 간선을 정렬하고 집합을 합치는 Kruskal 방식이 아니라,
 * 하나의 정점에서 시작해 점차 연결해가는 방식으로 MST 완성
 */

public class Solution {

    static int N;                 // 정점의 개수
    static double E;             // 환경 부담 세율
    static double[] xC;     // x좌표
    static double[] yC;     // y좌표
    static boolean[] visited;    // 방문 여부
    static double[] minEdge;     // 최소 연결 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 정점 개수

            xC = new double[N];
            yC = new double[N];

            // x 좌표 입력
            StringTokenizer stX = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                xC[i] = Double.parseDouble(stX.nextToken());
            }

            // y 좌표 입력
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                yC[i] = Double.parseDouble(stY.nextToken());
            }

            // 환경 부담 세율 입력
            E = Double.parseDouble(br.readLine());

            // Prim 알고리즘 수행
            double result = prim();

            // 결과 출력 (소수점 반올림)
            System.out.println("#" + tc + " " + Math.round(result));
        }
    }

    // Prim 알고리즘: MST 구성 시 최소 비용을 반환
    public static double prim() {
        visited = new boolean[N];          // MST 포함 여부
        minEdge = new double[N];           // 최소 연결 비용 저장

        Arrays.fill(minEdge, Double.MAX_VALUE); // 초기값: 무한대
        minEdge[0] = 0;                    // 시작 정점의 비용은 0

        double totalCost = 0;             // MST 총 비용

        // 모든 정점을 연결할 때까지 반복
        for (int i = 0; i < N; i++) {
            double min = Double.MAX_VALUE;
            int minVertex = -1;

            // 아직 방문하지 않은 정점 중에서 가장 비용이 적은 정점 선택
            for (int j = 0; j < N; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            // 해당 정점을 MST에 포함
            visited[minVertex] = true;
            totalCost += min;

            // 선택된 정점과 연결된 다른 정점들의 비용 갱신
            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    double cost = getCost(minVertex, j);
                    if (minEdge[j] > cost) {
                        minEdge[j] = cost;
                    }
                }
            }
        }

        return totalCost;
    }

    /**
     * 두 정점 간의 연결 비용 계산
     * 
     * 비용 = 환경 부담 세율 * 거리의 제곱
     */
    public static double getCost(int i, int j) {
        double dx = xC[i] - xC[j];
        double dy = yC[i] - yC[j];
        return E * (dx * dx + dy * dy);
    }
}
