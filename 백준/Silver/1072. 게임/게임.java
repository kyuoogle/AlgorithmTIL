import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int Z = (int) ((long) Y * 100 / X); // 현재 승률(버림)

        // 이미 더 올릴 수 없는 경우 (99 이상이면 100 만들기 불가능)
        if (Z >= 99) {
            bw.write("-1");
            bw.flush();
            return;
        }

        int answer = -1;
        int left = 1;            // 최소 1판은 더 해야 의미가 있음
        int right = (int) 1e9;   // 범위는 문제에서 주어짐

        while (left <= right) { // left가 right를 넘어서면 종료
            int mid = (left + right) / 2;

            int newRate = (int) ((long) (Y + mid) * 100 / (X + mid)); // mid판 더 했을 때 승률(버림)

            if (newRate > Z) { // 승률이 증가했으면 더 적은 판수로 줄여본다
                answer = mid;
                right = mid - 1;
            } else {           // 승률이 그대로면 더 많이 해야 한다
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}