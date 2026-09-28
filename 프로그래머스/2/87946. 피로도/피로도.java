import java.util.*;

class Solution {
    // 방문한 던전 체크를 위한 배열 선언
    boolean[] visited;
    // 최대로 방문할 수 있는 던전 갯수 세기 위한 변수 선언
    int max = 0;
    // 현재 피로도 k, 던전들의 최소 필요 피로도와 소모 피로도가 담긴 배열 dungeons
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return max;
    }
    
    public void dfs(int stress, int[][] dungeons, int cnt) {
        // 현재 방문한 던전 수 cnt, 최대로 방문 가능한 던전 수 max 중 큰 것으로 max를 초기화
        max = Math.max(max, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && stress >= dungeons[i][0]) {
                visited[i] = true;
                dfs(stress - dungeons[i][1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}