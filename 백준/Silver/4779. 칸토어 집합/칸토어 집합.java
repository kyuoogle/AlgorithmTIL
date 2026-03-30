import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int len = 1;

            for (int i = 0; i < n; i++) len *= 3;

            char[] a = new char[len];
            for (int i = 0; i < len; i++) a[i] = '-';

            f(a, 0, len);
            System.out.println(a);
        }
    }

    static void f(char[] a, int s, int len) {
        if (len == 1) return;

        int t = len / 3;

        for (int i = s + t; i < s + 2 * t; i++) a[i] = ' ';

        f(a, s, t);
        f(a, s + 2 * t, t);
    }
}