import java.io.*;
import java.util.*;

public class Main {

    static int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean leap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    static int getDay(int y, int mo, int d) {
        int sum = 0;

        for (int i = 1; i < y; i++) {
            sum += leap(i) ? 366 : 365;
        }

        for (int i = 0; i < mo - 1; i++) {
            sum += m[i];
            if (i == 1 && leap(y)) sum++;
        }

        return sum + d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        if (y2 > y1 + 1000 || (y2 == y1 + 1000 && (m2 > m1 || (m2 == m1 && d2 >= d1)))) {
            System.out.println("gg");
            return;
        }

        System.out.println("D-" + (getDay(y2, m2, d2) - getDay(y1, m1, d1)));
    }
}