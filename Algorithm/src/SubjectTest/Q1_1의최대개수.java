package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Q1_1의최대개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            String str = br.readLine();

            ArrayDeque<Character> array = new ArrayDeque<>();
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);
                if (str.charAt(i) == '1') {
                    array.push(ch);
                } else {
                    if (array.size() > cnt) {
                        cnt = array.size();
                    }
                    array.clear();
                }
            }
            if (array.size() > cnt) {
                cnt = array.size();
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}
