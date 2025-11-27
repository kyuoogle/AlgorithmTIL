import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim()); // 노선 수

            int[] stop = new int[1001]; // 1~1000 정류장 카운트용

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                // A, B에는 무조건 정차
                stop[A]++;
                stop[B]++;

                // 사이 정류장들만 규칙에 따라 카운트
                if (type == 1) { // 일반
                    for (int s = A + 1; s < B; s++) {
                        stop[s]++;
                    }
                } else if (type == 2) { // 급행
                    // A의 홀짝과 같은 정류장만
                    for (int s = A + 1; s < B; s++) {
                        if (s % 2 == A % 2) {
                            stop[s]++;
                        }
                    }
                } else if (type == 3) { // 광역 급행
                    if (A % 2 == 0) {
                        // A 짝수: 4의 배수 정류장
                        for (int s = A + 1; s < B; s++) {
                            if (s % 4 == 0) {
                                stop[s]++;
                            }
                        }
                    } else {
                        // A 홀수: 3의 배수이면서 10의 배수가 아닌 정류장
                        for (int s = A + 1; s < B; s++) {
                            if (s % 3 == 0 && s % 10 != 0) {
                                stop[s]++;
                            }
                        }
                    }
                }
            }

            // 정류장 중 최대 카운트 찾기
            int max = 0;
            for (int s = 1; s <= 1000; s++) {
                if (stop[s] > max) {
                    max = stop[s];
                }
            }

            sb.append('#').append(tc).append(' ')
              .append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
