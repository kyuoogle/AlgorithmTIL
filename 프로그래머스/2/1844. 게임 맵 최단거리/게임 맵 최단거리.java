import java.util.*;

class Solution {    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if(x == n -1 && y == m - 1) {
                return dist;
            }
            
            for(int d = 0; d < 4; d++) {
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }
}