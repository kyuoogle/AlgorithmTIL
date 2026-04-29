import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, n, computers, visited);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next = 0; next < n; next++) {
                if(computers[curr][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}