import java.io.*;
import java.util.*;

public class Main {
    static class Req {
        int a, b;
        Req(int a, int b) { this.a = a; this.b = b; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 책 개수 (1..N)
            int M = Integer.parseInt(st.nextToken()); // 학생 수

            Req[] reqs = new Req[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                reqs[i] = new Req(a, b);
            }

            // 끝점 b 오름차순, 시작점 a 오름차순
            Arrays.sort(reqs, (r1, r2) -> {
                if (r1.b != r2.b) return r1.b - r2.b;
                return r1.a - r2.a;
            });

            // 아직 배정되지 않은 책 번호를 관리
            TreeSet<Integer> books = new TreeSet<>();
            for (int i = 1; i <= N; i++) books.add(i);

            int assigned = 0;
            for (Req r : reqs) {
                Integer pick = books.ceiling(r.a); // r.a 이상인 가장 작은 책 번호
                if (pick != null && pick <= r.b) {
                    assigned++;
                    books.remove(pick);             // 배정된 책 제거
                }
            }

            out.append(assigned).append('\n');
        }

        System.out.print(out);
    }
}
