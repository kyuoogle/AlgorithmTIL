import java.util.*;

class Solution {
    
    // 상, 하, 좌, 우 이동
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int n = maps.length;       // 행의 개수
        int m = maps[0].length;    // 열의 개수
        
        // 이미 방문한 칸인지 확인하기 위한 배열
        boolean[][] visited = new boolean[n][m];
        
        /*
         * Queue에는
         * {x좌표, y좌표, 현재까지 지나온 칸의 개수}
         * 를 저장한다.
         *
         * BFS는 먼저 방문한 위치부터 탐색하기 때문에
         * 가중치가 동일한 격자에서 최단거리를 구할 수 있다.
         */
        Queue<int[]> q = new ArrayDeque<>();
        
        /*
         * 시작 위치는 (0, 0)
         *
         * 문제에서는 "지나간 칸의 개수"를 구하므로
         * 시작 칸도 포함해서 거리를 1로 시작한다.
         */
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            
            // 가장 먼저 들어온 위치를 꺼낸다.
            int[] curr = q.poll();
            
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            /*
             * BFS 특성상 목적지에 처음 도착했을 때의 거리가
             * 최단거리이다.
             */
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            // 현재 위치에서 상하좌우 4방향 탐색
            for (int d = 0; d < 4; d++) {
                
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // 1. 맵의 범위를 벗어나면 이동할 수 없음
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                // 2. 벽(0)이면 이동할 수 없음
                if (maps[nx][ny] == 0) {
                    continue;
                }
                
                // 3. 이미 방문한 위치라면 다시 갈 필요 없음
                if (visited[nx][ny]) {
                    continue;
                }
                
                /*
                 * Queue에 넣는 시점에 방문 처리한다.
                 *
                 * poll()할 때 방문 처리하면
                 * 같은 위치가 Queue에 여러 번 들어갈 수 있다.
                 */
                visited[nx][ny] = true;
                
                // 다음 위치의 거리는 현재 거리 + 1
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        // Queue를 모두 탐색했는데 목적지에 도착하지 못한 경우
        return -1;
    }
}