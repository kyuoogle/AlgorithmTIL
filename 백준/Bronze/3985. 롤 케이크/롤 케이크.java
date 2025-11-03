import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine().trim()); // 케이크 길이
        int N = Integer.parseInt(br.readLine().trim()); // 관객 수

        int[] cake = new int[L + 1]; // 1~L 사용, 0은 미배정
        int expectedWinner = 0, expectedMaxLen = -1;

        // 관객별 요청을 읽으면서
        // 1) 기대 최댓값(겹침 무시한 길이) 갱신
        // 2) 실제 배정(빈 칸만 해당 관객 번호로 표기)
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int len = K - P + 1;               // 기대 조각 수
            if (len > expectedMaxLen) {        // 동률이면 앞 번호 유지 (i가 증가하므로 > 만 체크)
                expectedMaxLen = len;
                expectedWinner = i;
            }

            for (int pos = P; pos <= K; pos++) {
                if (cake[pos] == 0) cake[pos] = i; // 비어있을 때만 배정
            }
        }

        // 실제로 받은 조각 수 세기
        int[] cnt = new int[N + 1];
        for (int pos = 1; pos <= L; pos++) {
            if (cake[pos] != 0) cnt[cake[pos]]++;
        }

        // 실제 최다 수혜자 (동률이면 번호 작은 사람 우선: 오름차순 순회 + '>' 비교만 사용)
        int actualWinner = 0, actualMax = -1;
        for (int i = 1; i <= N; i++) {
            if (cnt[i] > actualMax) {
                actualMax = cnt[i];
                actualWinner = i;
            }
        }
        
        System.out.println(expectedWinner);
        System.out.println(actualWinner);
    }
}
