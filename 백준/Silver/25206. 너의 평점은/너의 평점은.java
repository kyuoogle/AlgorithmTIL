import java.io.*;
import java.util.*;

public class Main {

    static double f(String s) {
        switch (s) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F": return 0.0;
        }
        return 0.0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = 0, b = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double x = Double.parseDouble(st.nextToken());
            String s = st.nextToken();

            if (s.equals("P")) continue;

            a += x * f(s);
            b += x;
        }

        System.out.println(a / b);
    }
}