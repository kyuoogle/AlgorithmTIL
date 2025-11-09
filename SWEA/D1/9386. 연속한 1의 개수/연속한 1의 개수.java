import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();

            // 혹시 마지막 테스트케이스에서 줄바꿈이 애매하게 들어올 때 대비
            while (line == null || line.length() < N) {
                String extra = br.readLine();
                if (extra == null) break;
                line += extra;
            }

            int maxRun = 0;   // 가장 긴 1의 길이
            int curRun = 0;   // 지금 세고 있는 1의 길이

            for (int i = 0; i < N; i++) {
                char c = line.charAt(i);
                if (c == '1') {
                    curRun++;
                    if (curRun > maxRun) {
                        maxRun = curRun;
                    }
                } else {
                    curRun = 0; // 0 만나면 연속 끊김
                }
            }

            System.out.println("#" + tc + " " + maxRun);
        }
    }
}
