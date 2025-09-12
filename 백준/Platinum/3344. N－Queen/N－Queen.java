import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        if (N % 6 != 2 && N % 6 != 3) {
            // 일반 케이스: 짝수열 먼저, 그 다음 홀수열
            for (int i = 2; i <= N; i += 2) {
                sb.append(i).append("\n");
            }
            for (int i = 1; i <= N; i += 2) {
                sb.append(i).append("\n");
            }
        } else if (N % 6 == 2) {
            // N % 6 == 2 특수 조정
            // 짝수 먼저
            for (int i = 2; i <= N; i += 2) {
                sb.append(i).append("\n");
            }
            // 홀수 조정
            // swap 1과 3, 그리고 마지막에 5
            sb.append(3).append("\n");
            sb.append(1).append("\n");
            for (int i = 5; i <= N; i += 2) {
                if (i == 5) continue;
                sb.append(i).append("\n");
            }
            sb.append(5).append("\n");
        } else if (N % 6 == 3) {
            // N % 6 == 3 특수 조정
            // 짝수열 쪽은 2를 맨 뒤로
            for (int i = 2; i <= N; i += 2) {
                if (i == 2) continue;
                sb.append(i).append("\n");
            }
            sb.append(2).append("\n");
            // 홀수 조정: 1,3을 맨 뒤로
            for (int i = 1; i <= N; i += 2) {
                if (i == 1 || i == 3) continue;
                sb.append(i).append("\n");
            }
            sb.append(1).append("\n");
            sb.append(3).append("\n");
        }

        System.out.print(sb.toString());
    }
}
