import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken()); // 사람 수(정점의 수)
        	int M = Integer.parseInt(st.nextToken()); // 친구 관계(간선의 수)
        	// g를 1~N까지 쓰기 위해 크기를 N+1로 만든 후에 각 정점마다 ArrayList 하나씩 준비
        	List<List<Integer>> g = new ArrayList<>();
        	for (int i = 0; i <= N; i++) g.add(new ArrayList<>());
        	// 친구 관계는 양방향이기 때문에 a와 b 모두 추가
        	for (int i = 0; i < M; i++) {
        	    st = new StringTokenizer(br.readLine());
        	    int a = Integer.parseInt(st.nextToken());
        	    int b = Integer.parseInt(st.nextToken());
        	    g.get(a).add(b);
        	    g.get(b).add(a);
        	}
        	//BFS
        	// 너비 우선 탐색은 최단 거리를 구하기 때문에 2단계까지 너비 우선 탐색하면 답 나올듯
        	int start = 1; // 상원이 번호가 1번이라고 가정하고 시작
        	//BFS 깊이 2까지만 진행
        	// 중복 방문 방지 및 간선 수를 세기 위한 배열 선언
        	// dist[v] = -1은 미방문을 의미
        	int[] dist = new int [N + 1];
        	Arrays.fill(dist, -1);
        	Queue<Integer> q = new ArrayDeque<>();
        	q.offer(start);
        	dist[start] = 0;
        	
        	while(!q.isEmpty()) {
        		int curr = q.poll();
        		if(dist[curr] == 2) continue; // 깊이 2까지만 그래프 확장
        		
        		List<Integer> neighbors = g.get(curr);
        		for(int i = 0; i < neighbors.size(); i++) {
        			int nxt = neighbors.get(i);
        			if (dist[nxt] == -1) {
        				dist[nxt] = dist[curr] + 1;
        				q.offer(nxt);
        			}
        		}
        	}
        	int cnt = 0;
        	for(int i = 1; i <= N; i++) {
        		if (i != start && dist[i] != -1 && dist[i] <= 2) {
        			cnt++;
        		}
        	}
        	System.out.println("#" + tc + " " + cnt);
        }
    }
}
