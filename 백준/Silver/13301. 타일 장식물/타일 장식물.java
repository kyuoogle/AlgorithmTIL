import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long a = 4, b = 6;

        if (n == 1) {
            System.out.println(a);
            return;
        }

        if (n == 2) {
            System.out.println(b);
            return;
        }

        for (int i = 3; i <= n; i++) {
            long t = a + b;
            a = b;
            b = t;
        }

        System.out.println(b);
    }
}