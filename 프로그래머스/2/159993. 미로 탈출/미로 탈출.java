import java.util.*;

class Solution {
    // 최소 시간 기록을 위한 변수 선언
    // BFS를 메서드로 따로 분리해서 사용할 것이기 때문에
    // 전역 변수로 선언
    int ans;
    
    // 탐색을 위한 dx, dy
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        // 시작점, 레버, 도착점의 x, y좌표
        int sx = 0, sy = 0;
        int lx = 0, ly = 0;
        int ex = 0, ey = 0;
        
        // maps내의 실제 좌표 탐색 후 값 갱신
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                
                if(c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    lx = i;
                    ly = j;
                } else if (c == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        int toLever = bfs(maps, sx, sy, lx, ly);
        if(toLever == -1) return -1;
        
        int toExit = bfs(maps, lx, ly, ex, ey);
        if(toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public int bfs(String[] maps, int sx, int sy, int ex, int ey) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{sx, sy, 0});
        
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            // 목표 지점 도달 시 반환
            if(x == ex && y == ey) return dist;
            
            // 4방향 탐색 시작
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // maps배열의 범위를 벗어난 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽인 경우
                if(maps[nx].charAt(ny) == 'X') continue;
                // 이미 방문했던 경우
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                
                q.offer(new int[] { nx, ny, dist + 1});
            }
        }
        return -1;
    }
}