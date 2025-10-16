import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K;                // M: 가로(열), N: 세로(행), K: 배추의 위치를 표현하는 줄 개수
    static boolean[][] field;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	field = new boolean[N][M];
        	visited = new boolean[N][M];
        	
        	// 배추가 있는 곳 좌표 입력
        	for(int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		field[y][x] = true;
        	}
        	
        	int worm = 0;
        	for(int r = 0; r < N; r++) {
        		for(int c = 0; c < M; c++) {
        			if(field[r][c] && !visited[r][c]) {
        				bfs(r, c);
        				worm++;
        			}
        		}
        	}
        	System.out.println(worm);	
        }
    }


	private static void bfs(int sr, int sc) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[sr][sc] = true;
		q.add(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(!field[nr][nc] || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
