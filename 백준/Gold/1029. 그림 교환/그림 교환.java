import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, max;
    static int[][] map, dp;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            N = Integer.parseInt(br.readLine());

            // map[i][j] : i가 가진 그림을 j가 살 때의 가격(0~9)
            map = new int[N + 1][N + 1];
            for (int i = 1; i <= N; ++i) {
                String input = br.readLine();
                for (int j = 1; j <= N; ++j) {
                    map[i][j] = input.charAt(j - 1) - '0';
                }
            }

            // dp[state][owner] : state(방문 상태)에서 owner(현재 그림 소유자)가 되었을 때,
            // 마지막 거래 가격의 "최소값"을 저장 (더 비싸게 온 경로는 가지치기)
            dp = new int[1 << N][N + 1];

            // 시작: 1번이 그림 소유, 1번 방문 상태(비트 0 on), 방문 수 1
            dfs(1, 1, 1);

            bw.write(max + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int owner, int state, int visitCnt) {
        // 이미 최대로 다 샀으면 더 볼 필요 없음
        if (max == N) return;

        // 최댓값 갱신
        max = Math.max(max, visitCnt);

        // 모두 방문했으면 종료
        if (state == (1 << N) - 1) return;

        // 다음 구매자 후보 탐색
        for (int buyer = 1; buyer <= N; ++buyer) {
            int bit = 1 << (buyer - 1);

            // 아직 방문하지 않았고, 현재 가격 >= 이전에 owner가 산 가격(거래 가능)이라면
            if ((state & bit) == 0 && map[owner][buyer] >= dp[state][owner]) {
                int nextState = state | bit;
                int price = map[owner][buyer];

                // 같은 (nextState, buyer)에 이미 더 싸거나 같은 가격으로 도달한 적 있으면 가지치기
                if (dp[nextState][buyer] != 0 && dp[nextState][buyer] <= price) continue;

                dp[nextState][buyer] = price;
                dfs(buyer, nextState, visitCnt + 1);
            }
        }
    }
}
