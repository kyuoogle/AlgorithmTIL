import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            // 1) 완전 분리 체크
            if (x2 < p1 || p2 < x1 || y2 < q1 || q2 < y1) {
                sb.append('d').append('\n');
                continue;
            }

            // 2) 겹치는 구간 크기
            int dx = Math.min(x2, p2) - Math.max(x1, p1);
            int dy = Math.min(y2, q2) - Math.max(y1, q1);

            // dx/dy는 0 이상이 될 거라고 가정 가능 (위에서 분리 안된 걸 걸렀으니까)

            if (dx == 0 && dy == 0) {
                sb.append('c').append('\n'); // 점
            } else if (dx == 0 || dy == 0) {
                sb.append('b').append('\n'); // 선
            } else {
                sb.append('a').append('\n'); // 면
            }
        }

        System.out.print(sb.toString());
    }
}
