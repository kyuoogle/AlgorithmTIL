import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] board;
	
	static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
	
    static boolean[][][][] visited;
    
    // BFS에서 한 상태(state)를 하나의 객체로 묶어서 관리하기 위해 클래스 선언
    static class State {
        int rx, ry, bx, by, d; // d = move count so far
        State(int rx, int ry, int bx, int by, int d){
            this.rx = rx; 
            this.ry = ry; 
            this.bx = bx; 
            this.by = by; 
            this.d = d;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		int rx = 0, ry = 0, bx = 0, by = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = str.charAt(j);
				board[i][j] = c;
				if(c == 'R') {
					rx = i;
					ry = j;
					board[i][j] = '.';
				} else if(c == 'B') {
					bx = i;
					by = j;
					board[i][j] = '.';
				}
			}
		}
		System.out.println(bfs(rx, ry, bx, by));
	}
	
	static int bfs(int rx, int ry, int bx, int by) {
        // 방문 체크
        visited = new boolean[N][M][N][M];
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.d >= 10) continue; // 다음 기울임이 11번째가 되므로 탐색 중단

            for (int dir = 0; dir < 4; dir++) {
                MoveResult r = roll(cur.rx, cur.ry, dir);
                MoveResult b = roll(cur.bx, cur.by, dir);

                // 파랑이 빠지면 실패 케이스 -> 무시
                if (b.inHole) continue;

                // 빨강만 빠지면 성공
                if (r.inHole && !b.inHole) return cur.d + 1;

                int nrx = r.x, nry = r.y;
                int nbx = b.x, nby = b.y;

                // 같은 칸에 멈췄다면(구멍 제외), 더 멀리 이동한 구슬을 한 칸 뒤로
                if (nrx == nbx && nry == nby) {
                    int rDist = r.dist;
                    int bDist = b.dist;
                    if (rDist > bDist) { // 빨강이 더 멀리 굴렀음 -> 빨강을 한 칸 뒤로
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {            // 파랑이 더 멀리 -> 파랑을 한 칸 뒤로
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.d + 1));
                }
            }
        }
        return -1; // 10번 이내 불가능
    }

    // 기울였을 때 한 구슬이 벽 또는 구멍을 만나기 전까지 직진해 멈춘 위치와 이동 칸 수 반환
    static class MoveResult {
        int x, y, dist;
        boolean inHole;
        
        MoveResult(int x, int y, int dist, boolean inHole) {
            this.x = x; 
            this.y = y; 
            this.dist = dist; 
            this.inHole = inHole;
        }
    }
    
    // 지정된 방향으로 구슬을 굴려서, 벽 또는 구멍에 닿을 때까지 이동시킨 후, 최종 위치/거리/구멍 여부를 반환
    static MoveResult roll(int sx, int sy, int dir) {
        int x = sx, y = sy, moved = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            char cell = board[nx][ny];

            if (cell == '#') { // 벽이면 직전 위치에 멈춤
                return new MoveResult(x, y, moved, false);
            }
            if (cell == 'O') { // 구멍에 빠짐
                return new MoveResult(nx, ny, moved + 1, true);
            }
            // 빈 칸이면 계속 진행
            x = nx; y = ny; moved++;
        }
    }
}