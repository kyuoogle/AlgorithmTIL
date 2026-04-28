import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    static int[][][] blocks = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},

            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},

            {{0, 0}, {1, -1}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {1, -1}, {1, 0}, {2, 0}},

            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            line = line.trim();
            if (line.isEmpty()) continue;

            N = Integer.parseInt(line);

            if (N == 0) break;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = solve();

            sb.append(tc).append(". ").append(answer).append('\n');
            tc++;
        }

        System.out.print(sb);
    }

    static int solve() {
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                for (int[][] block : blocks) {
                    int sum = 0;
                    boolean possible = true;

                    for (int[] pos : block) {
                        int nr = r + pos[0];
                        int nc = c + pos[1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            possible = false;
                            break;
                        }

                        sum += map[nr][nc];
                    }

                    if (possible) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        return max;
    }
}