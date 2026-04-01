import java.io.*;
import java.util.*;

public class Main {

    static boolean a, b, c;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ball = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) {
                if (++ball == 4) {
                    go(0);
                    ball = 0;
                }
            } else if (x == 2) {
                go(0);
                ball = 0;
            } else {
                go(1);
                if (++ball == 4) {
                    go(0);
                    ball = 0;
                }
            }
        }

        System.out.println(ans);
    }

    static void go(int t) {
        if (t == 0) {
            if (a) {
                if (b) {
                    if (c) ans++;
                    else c = true;
                } else b = true;
            } else a = true;
        } else {
            if (c) {
                ans++;
                c = false;
            }
            if (b) {
                c = true;
                b = false;
            }
            if (a) {
                b = true;
                a = false;
            }
        }
    }
}