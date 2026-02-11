import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long modPowIter(long a, long b, long mod) {
        long result = 1 % mod;   // 누적 정답
        a %= mod;                // 밑을 먼저 mod로 줄임

        while (b > 0) {
            if ((b & 1) == 1) {              // b가 홀수(마지막 비트가 1)면
                result = (result * a) % mod; // 현재 a를 결과에 곱함
            }
            a = (a * a) % mod;  // a를 제곱해서 다음 비트 자리 준비
            b >>= 1;            // b를 2로 나눔 (비트 이동)
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(modPowIter(A, B, C));
    }
}
