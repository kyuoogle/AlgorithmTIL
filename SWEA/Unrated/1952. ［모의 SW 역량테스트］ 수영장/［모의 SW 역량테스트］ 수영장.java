import java.io.*;
import java.util.*;

public class Solution {
    static int[] cost;   // 0: 1일, 1: 1달, 2: 3달, 3: 1년
    static int[] plan;   // plan[1..12]
    static int[] dp;     // dp[m] = m월부터 12월까지 최소 비용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            // 가격 입력: 1일, 1달, 3달, 1년
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost = new int[4];
            for (int i = 0; i < 4; i++) cost[i] = Integer.parseInt(st.nextToken());

            // 이용 계획: 1~12월
            st = new StringTokenizer(br.readLine());
            plan = new int[13];
            for (int i = 1; i <= 12; i++) plan[i] = Integer.parseInt(st.nextToken());

            // dp 초기화
            dp = new int[16];
            Arrays.fill(dp, -1);

            // dfs(1)과 1년권 비교
            // 달 단위와 3달 단위 선택의 조합을 모두 고려해 최소를 구하고
            // 마지막으로 1년권과 비교해 더 작은 걸 답으로 선택
            int ans = Math.min(dfs(1), cost[3]);
            System.out.println("#" + tc + " " + ans);
        }
    }
    
    // m월부터 12월까지 최소 비용을 반환
    static int dfs(int m) {
        if (m > 12) return 0; // 기저 조건: 12월 넣으면 추가 비용 없음
        if (dp[m] != -1) return dp[m];
        
        // 이번 달 이용이 없다면
        if (plan[m] == 0) return dp[m] = dfs(m + 1);

        int useDay   = cost[0] * plan[m] + dfs(m + 1); // 1일권
        int useMonth = cost[1] + dfs(m + 1);           // 1달권
        int useTri   = cost[2] + dfs(m + 3);           // 3달권(정액)

        return dp[m] = Math.min(useDay, Math.min(useMonth, useTri));
    }
}
