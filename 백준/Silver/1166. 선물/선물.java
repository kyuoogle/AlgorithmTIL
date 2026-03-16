import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.max(l, Math.max(w, h));

        for (int i = 0; i < 10000; i++) {
            double mid = (left + right) / 2.0;

            long cnt = (long) (l / mid) * (long) (w / mid) * (long) (h / mid);

            if (cnt >= n) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}