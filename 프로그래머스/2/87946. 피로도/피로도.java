import java.util.*;

class Solution {
    boolean[] visited;
    int max = 0;
    
    public  void dfs(int stress, int[][] dungeons, int cnt) {        
        max = Math.max(max, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && stress >= dungeons[i][0]) {
                visited[i] = true;
                dfs(stress - dungeons[i][1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return max;
    }
}