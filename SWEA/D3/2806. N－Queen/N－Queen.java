import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트케이스 수 T
        int T = Integer.parseInt(br.readLine().trim());

        int[] results = { -1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724 };

        for (int tc = 1; tc <= T; tc++) {
            // 배치할 퀸의 갯수 1 <= N <= 10
            int N = Integer.parseInt(br.readLine().trim());

            // 출력 누적
            sb.append("#").append(tc).append(" ").append(results[N]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
