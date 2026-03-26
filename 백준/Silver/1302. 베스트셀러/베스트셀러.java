import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> m = new HashMap<>();

        int max = 0;
        String ans = "";

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int v = m.getOrDefault(s, 0) + 1;
            m.put(s, v);

            if (v > max || (v == max && s.compareTo(ans) < 0)) {
                max = v;
                ans = s;
            }
        }

        System.out.println(ans);
    }
}