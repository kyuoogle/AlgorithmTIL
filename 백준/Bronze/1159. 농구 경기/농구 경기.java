import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[26]; // 알파벳 등장 횟수

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char first = name.charAt(0);
            count[first - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                sb.append((char)(i + 'a'));
            }
        }

        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
