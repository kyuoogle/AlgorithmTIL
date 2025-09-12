//package UpologicalSort;

import java.io.*;
import java.util.*;

public class Solution {
    static int V, E; // 정점, 간선의 개수
    static int[] in_degree; // 진입 차수 정보 저장 배열
    static List<Integer>[] adj;
    static Queue<Integer> q; // 위상 정렬 수행을 위한 q 선언
    static int[] order; // 작업순서를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            in_degree = new int[V + 1];
            adj = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            // 문제에 따라 간선 정보가 여러 줄로 주어지므로, M번 반복하며 입력 받음
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                in_degree[v]++;
            }

            q = new LinkedList<>();
            order = new int[V];

            // 위상 정렬 실행
            topologicalSort();

            // 결과 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < V; i++) {
                sb.append(order[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void topologicalSort() {
        // 1. 진입 차수가 0인 모든 정점을 큐에 삽입
        for (int i = 1; i <= V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        // 2. 큐가 빌 때까지 반복
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            order[cnt++] = curr;

            // 3. 현재 정점에서 나가는 간선 제거 및 진입 차수 감소시키기
            for (int neighbor : adj[curr]) {
                in_degree[neighbor]--;
                // 4. 새롭게 진입 차수 0된 놈들 다시 큐에 삽입
                if (in_degree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }
}