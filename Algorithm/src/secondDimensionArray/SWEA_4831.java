package secondDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4831 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int tc = 1; tc <= T; tc++) {
            // 첫 줄: K N M
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 두 번째 줄: M개의 충전기 위치
            int[] station = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int charger = Integer.parseInt(st.nextToken());
                station[charger] = 1;
            }

            // 시뮬레이션 시작
            int now = 0;
            int count = 0;
            boolean success = true;

            while (now + K < N) {
                boolean found = false;
                // K칸 이내에서 가장 멀리 있는 충전기 찾기
                for (int i = K; i >= 1; i--) {
                    if (station[now + i] == 1) {
                        now += i;
                        count++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    success = false;
                    break;
                }
            }

            System.out.println("#" + tc + " " + (success ? count : 0));
        }
    }
}