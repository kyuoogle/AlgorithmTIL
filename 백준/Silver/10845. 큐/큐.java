import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>(); // 큐로 사용

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                // "push X"
                int x = Integer.parseInt(line.substring(5));
                q.addLast(x);
            } else if (line.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.removeFirst()).append('\n');
            } else if (line.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (line.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (line.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
            } else if (line.equals("back")) {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
