import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int P = 2 * (W + H);           // 둘레

        int N = Integer.parseInt(br.readLine());
        int[] shop = new int[N];

        // 가게 위치들을 선형 좌표로 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int pos;
            if (d == 1) pos = x;                           // 북
            else if (d == 4) pos = W + x;                  // 동
            else if (d == 2) pos = W + H + (W - x);        // 남
            else pos = 2 * W + H + (H - x);                // 서
            shop[i] = pos;
        }

        // 경비원 위치
        st = new StringTokenizer(br.readLine());
        int gd = Integer.parseInt(st.nextToken());
        int gx = Integer.parseInt(st.nextToken());
        int guard;
        if (gd == 1) guard = gx;
        else if (gd == 4) guard = W + gx;
        else if (gd == 2) guard = W + H + (W - gx);
        else guard = 2 * W + H + (H - gx);

        // 최단거리 합
        int sum = 0;
        for (int s : shop) {
            int diff = Math.abs(guard - s);
            sum += Math.min(diff, P - diff);
        }

        System.out.println(sum);
    }
}
