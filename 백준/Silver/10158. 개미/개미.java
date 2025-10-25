import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

        int x = getPos(p, w, T);
        int y = getPos(q, h, T);

        System.out.println(x + " " + y);
    }

    // 한 축에 대한 최종 위치 계산
    static int getPos(int start, int limit, int time) {
        int len = 2 * limit;                // 왕복 주기 길이
        int tmp = (start + time) % len;     // 펴진 선에서의 위치

        if (tmp > limit) {
            // 거울 구간이면 반사해서 다시 되돌리기
            return len - tmp;
        } else {
            return tmp;
        }
    }
}
