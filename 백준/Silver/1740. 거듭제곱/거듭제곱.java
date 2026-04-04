import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long ans = 0;

        while (n > 0) {
            long x = 1;
            long p = 1;

            while (n >= x << 1) {
                x <<= 1;
                p *= 3;
            }

            n -= x;
            ans += p;
        }

        System.out.println(ans);
    }
}