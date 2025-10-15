import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int last = a % 10; // 일의 자리만 중요

            // 0이면 무조건 10번 컴퓨터
            if (last == 0) {
                System.out.println(10);
                continue;
            }

            int result = 1;
            // b번 곱하면서 일의 자리만 유지
            for (int j = 0; j < b; j++) {
                result = (result * last) % 10;
            }

            System.out.println(result);
        }
    }
}
