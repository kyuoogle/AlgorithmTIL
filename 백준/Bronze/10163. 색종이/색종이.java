import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[][] map = new int[1001][1001]; // [row=y][col=x]

        int N = Integer.parseInt(br.readLine()); //색종이 개수

        // ------------------------------------------------------------
        // [핵심 변경점 1] 채우는 구간의 축 해석 수정
        //  - 원래 코드: for (j = X; j < X + H)  // X에 H를 더함 (축 뒤섞임)
        //               for (k = Y; k < Y + W)  // Y에 W를 더함
        //  - 정정 코드: row = Y .. Y + H - 1 (세로 이동), col = X .. X + W - 1 (가로 이동)
        //    즉, 바깥 루프는 '행(r=y)', 안쪽 루프는 '열(c=x)' 로 도는 것이 맞다.
        // ------------------------------------------------------------
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 왼쪽 아래 x
            int Y = Integer.parseInt(st.nextToken()); // 왼쪽 아래 y
            int W = Integer.parseInt(st.nextToken()); // 너비 (가로 길이, x 증가)
            int H = Integer.parseInt(st.nextToken()); // 높이 (세로 길이, y 증가)

            // [변경점] r은 row=y축(세로), c는 col=x축(가로)
            // 문제 입력은 보드 범위를 벗어나지 않으므로 경계 체크(if ...)는 생략해도 안전
            for (int r = Y; r < Y + H; r++) {      // 세로로 H칸
                for (int c = X; c < X + W; c++) {  // 가로로 W칸
                    map[r][c] = i; // 뒤에 온 색종이가 앞의 것을 덮어씀
                }
            }
        }

        // ------------------------------------------------------------
        // [핵심 변경점 2] 면적 집계를 효율적으로 변경
        //  - 원래 코드: 색종이 i마다 전체 보드(1001×1001)를 매번 스캔 → O(N * 1000^2)
        //  - 정정 코드: 보드를 '한 번만' 스캔하면서 area[번호]++ 누적 → O(1000^2)
        //    (그 후 1..N 출력)
        // 또한, 이중 루프의 두 번째 조건은 map[0].length가 맞다.
        // (원래 코드에선 두 루프 모두 map.length 사용 → 열 크기 착오)
        // ------------------------------------------------------------
        int[] area = new int[N + 1];
        for (int r = 0; r < map.length; r++) {          // r: 행(=y)
            for (int c = 0; c < map[0].length; c++) {   // c: 열(=x)  ← [변경점] 열 크기 참조 수정
                int v = map[r][c];
                if (v != 0) area[v]++;
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            sb.append(area[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
