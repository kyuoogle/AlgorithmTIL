import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int max = Integer.MIN_VALUE; // 음수 가능성까지 안전
        int maxR = 1, maxC = 1;      // 1-based 위치

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                while (st == null || !st.hasMoreTokens()) {
                    String line = br.readLine();   // 토큰 없으면 새 줄 입력
                    if (line == null) return;      // 입력 끝났으면 종료(안전장치)
                    st = new StringTokenizer(line);
                }
                int v = Integer.parseInt(st.nextToken());

                if (v > max) {         // 같은 값이면 최초 위치 유지하려고 '>'만 사용
                    max = v;
                    maxR = i + 1;      // 1-based
                    maxC = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxR + " " + maxC);
    }
}
