import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        // 두 전력망의 송전탑 개수 차이 중 최솟값을 저장하기 위한 변수
        // 처음에는 어떤 값과 비교해도 갱신될 수 있도록 가장 큰 값으로 초기화
        int ans = Integer.MAX_VALUE;
        
        // 전선을 하나씩 끊어보면서 모든 경우를 확인
        // wires.length는 n - 1
        // cut은 현재 끊을 전선의 인덱스
        for(int cut = 0; cut < wires.length; cut++) {
            
            // 현재 전선 하나를 끊은 상태의 그래프를 만들기 위한 인접 리스트
            // 송전탑 번호가 1번부터 n번까지이므로 n + 1 크기로 생성
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            
            // 각 송전탑마다 연결된 송전탑들을 저장할 리스트 생성
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 모든 전선을 순회하면서 그래프 생성
            for(int i = 0; i < wires.length; i++) {
                
                // 현재 끊어보기로 한 전선은 그래프에 추가하지 않음
                if(i == cut) continue;
                
                // 현재 전선이 연결하고 있는 두 송전탑
                int a = wires[i][0];
                int b = wires[i][1];
                
                // 전선은 양방향 연결이므로
                // a -> b, b -> a 모두 저장
                graph[a].add(b);
                graph[b].add(a);
            }
            
            // BFS에서 이미 방문한 송전탑인지 확인하기 위한 배열
            boolean[] visited = new boolean[n + 1];
            
            // 1번 송전탑부터 BFS를 시작해서
            // 1번 송전탑과 연결되어 있는 송전탑의 개수를 구함
            //
            // 전선 하나를 끊었기 때문에 전체 전력망은 두 그룹으로 나뉨
            // 따라서 한쪽 그룹 크기만 알면 다른 그룹 크기도 구할 수 있음
            int cnt = bfs(1, graph, visited);
            
            // 첫 번째 전력망의 송전탑 개수 = cnt
            // 두 번째 전력망의 송전탑 개수 = n - cnt
            //
            // 두 전력망의 송전탑 개수 차이 계산
            int diff = Math.abs(cnt - (n - cnt));
            
            // 지금까지 확인한 차이 중 가장 작은 값을 저장
            ans = Math.min(ans, diff);
        }
        
        // 모든 전선을 한 번씩 끊어본 결과 중
        // 송전탑 개수 차이가 가장 작은 값 반환
        return ans;
    }
    
    public int bfs(int start, ArrayList<Integer>[] graph, boolean[] visited) {
        
        // BFS를 수행하기 위한 Queue
        Queue<Integer> q = new ArrayDeque<>();
        
        // 시작 송전탑을 Queue에 삽입
        q.add(start);
        
        // 시작 송전탑 방문 처리
        visited[start] = true;
        
        // 현재 전력망에 포함된 송전탑 개수
        // 시작 송전탑 자체도 포함하므로 1부터 시작
        int cnt = 1;
        
        // 더 이상 탐색할 송전탑이 없을 때까지 반복
        while(!q.isEmpty()) {
            
            // 현재 탐색할 송전탑을 Queue에서 꺼냄
            int curr = q.poll();
            
            // 현재 송전탑과 연결된 모든 송전탑 확인
            for(int i = 0; i < graph[curr].size(); i++) {
                int next = graph[curr].get(i);
                
                // 아직 방문하지 않은 송전탑이라면
                if(!visited[next]) {
                    
                    // 방문 처리
                    visited[next] = true;
                    
                    // 이후 연결된 송전탑도 탐색하기 위해 Queue에 삽입
                    q.add(next);
                    
                    // 같은 전력망에 속한 송전탑을 하나 발견했으므로 개수 증가
                    cnt++;
                }
            }
        }
        
        // 시작 송전탑과 연결되어 있는
        // 전체 송전탑 개수를 반환
        return cnt;
    }
}