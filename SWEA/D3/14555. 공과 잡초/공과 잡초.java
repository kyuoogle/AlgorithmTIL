import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();        // 예: "(|..|)"
            char[] s = line.toCharArray();

            int cnt = 0;
            for (int i = 0; i + 1 < s.length; i++) {   // i < length-1 로 제한
                char a = s[i], b = s[i + 1];
                // 카운트하는 패턴: "()", "(|", "|)"
                if ((a == '(' && b == ')') || (a == '(' && b == '|') || (a == '|' && b == ')')) {
                    cnt++;
                }
            }
            sb.append('#').append(tc).append(' ').append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
