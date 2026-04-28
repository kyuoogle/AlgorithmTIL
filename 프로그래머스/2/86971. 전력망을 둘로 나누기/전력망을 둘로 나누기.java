import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        
        for(int cut = 0; cut < wires.length; cut++) {
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < wires.length; i++) {
                if(i == cut) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                graph[a].add(b);
                graph[b].add(a);
            }
            
            // BFS
            boolean[] visited = new boolean[n + 1];
            int cnt = bfs(1, graph, visited);
            int diff = Math.abs(cnt - (n - cnt));
            ans = Math.min(ans, diff);
        }
        
        return ans;
    }
    
    public int bfs(int start, ArrayList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i = 0; i < graph[curr].size(); i++) {
                int next = graph[curr].get(i);
                
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}