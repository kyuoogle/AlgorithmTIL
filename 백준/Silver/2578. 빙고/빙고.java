import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 빙고판(2차원 배열) 입력
        int[][] board = new int[5][5];
        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) 체크 상태(2차원 배열)
        boolean[][] marked = new boolean[5][5];

        int callCount = 0;
        // 사회자가 부르는 25개 숫자 처리
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                callCount++;

                // 2D 탐색으로 숫자 위치 찾아 체크 (라벨 없이 플래그로 탈출)
                boolean found = false;
                for (int r = 0; r < 5 && !found; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (board[r][c] == x) {
                            marked[r][c] = true;
                            found = true;
                            break; // 안쪽 루프만 탈출
                        }
                    }
                }

                // 현재 빙고 줄 수 재계산
                int lines = 0;

                // 가로
                for (int r = 0; r < 5; r++) {
                    boolean ok = true;
                    for (int c = 0; c < 5; c++) {
                        if (!marked[r][c]) { ok = false; break; }
                    }
                    if (ok) lines++;
                }

                // 세로
                for (int c = 0; c < 5; c++) {
                    boolean ok = true;
                    for (int r = 0; r < 5; r++) {
                        if (!marked[r][c]) { ok = false; break; }
                    }
                    if (ok) lines++;
                }

                // 대각선 (왼↘오)
                boolean ok = true;
                for (int k = 0; k < 5; k++) {
                    if (!marked[k][k]) { ok = false; break; }
                }
                if (ok) lines++;

                // 대각선 (오↙왼)
                ok = true;
                for (int k = 0; k < 5; k++) {
                    if (!marked[k][4 - k]) { ok = false; break; }
                }
                if (ok) lines++;

                // 3줄 이상이면 호출 횟수 출력 후 종료
                if (lines >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }

        // 논리상 도달하지 않지만 안전 장치
        System.out.println(callCount);
    }
}
