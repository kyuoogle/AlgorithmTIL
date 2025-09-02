import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에 N개

        List<Integer> line = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int k = Integer.parseInt(st.nextToken());
            line.add(line.size() - k, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : line) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }
}
