import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int R, C;
    static char[][] map;
    static int[][] fireDist, jDist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        jDist = new int[R][C];

        ArrayDeque<int[]> fireQ = new ArrayDeque<>();
        int sr = -1, sc = -1; // J 시작 위치

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireDist[i][j] = INF;
                jDist[i][j] = -1;

                if (map[i][j] == 'F') {
                    fireDist[i][j] = 0;
                    fireQ.add(new int[]{i, j});
                } else if (map[i][j] == 'J') {
                    sr = i; sc = j;
                }
            }
        }

        // 1) 불의 도착 시간 전체 계산
        fireBFS(fireQ);

        // 2) 지훈 탈출 시도
        int ans = jihoonBFS(sr, sc);
        if (ans == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }

    /** 불 BFS: fireDist[r][c] = 불이 처음 도착하는 시각 */
    static void fireBFS(ArrayDeque<int[]> fireQ) {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!in(nr, nc)) continue;
                if (map[nr][nc] == '#') continue;
                if (fireDist[nr][nc] != INF) continue;
                fireDist[nr][nc] = fireDist[r][c] + 1;
                fireQ.add(new int[]{nr, nc});
            }
        }
    }

    /** 지훈 BFS: 탈출에 걸리는 시간(분). 실패 시 -1 반환 */
    static int jihoonBFS(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        jDist[sr][sc] = 0;
        q.add(new int[]{sr, sc});

        // 시작이 경계면, 다음 분에 바로 밖으로
        if (isEdge(sr, sc)) return 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int t = jDist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                // 바깥으로 나가면 성공 (다음 분)
                if (!in(nr, nc)) return t + 1;

                if (map[nr][nc] == '#') continue;
                if (jDist[nr][nc] != -1) continue;

                // 지훈이 t+1에 도착 / 불이 fireDist[nr][nc]에 도착
                // 불과 '같은 시각'도 못 감 -> 반드시 '<'
                if (t + 1 >= fireDist[nr][nc]) continue;

                jDist[nr][nc] = t + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return -1; // 탈출 불가
    }

    static boolean in(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
    static boolean isEdge(int r, int c) {
        return r == 0 || r == R - 1 || c == 0 || c == C - 1;
    }
}
