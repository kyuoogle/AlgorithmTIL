import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') stack.push(c);
                else { // ')'
                    if (stack.isEmpty()) { isValid = false; break; }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) isValid = false;  // ← 여기!

            sb.append(isValid ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}
