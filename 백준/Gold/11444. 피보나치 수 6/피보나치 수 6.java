import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long[] res = fib(n);          // res[0] = F(n), res[1] = F(n+1)
        System.out.println(res[0] % MOD);
    }

    // fast doubling: O(log n)
    // 반환: [F(n), F(n+1)]
    static long[] fib(long n) {
        if (n == 0) return new long[]{0L, 1L};

        long[] ab = fib(n >> 1); // n/2
        long a = ab[0];          // F(k)
        long b = ab[1];          // F(k+1)

        // c = F(2k) = F(k) * (2*F(k+1) - F(k))
        long twoB = (2L * b) % MOD;
        long twoBminusA = (twoB - a + MOD) % MOD;
        long c = (a * twoBminusA) % MOD;

        // d = F(2k+1) = F(k)^2 + F(k+1)^2
        long d = ( (a * a) % MOD + (b * b) % MOD ) % MOD;

        if ((n & 1L) == 0L) {
            // n = 2k  -> (F(2k), F(2k+1))
            return new long[]{c, d};
        } else {
            // n = 2k+1 -> (F(2k+1), F(2k)+F(2k+1))
            long e = (c + d) % MOD; // F(2k) + F(2k+1) = F(2k+2)
            return new long[]{d, e};
        }
    }
}
