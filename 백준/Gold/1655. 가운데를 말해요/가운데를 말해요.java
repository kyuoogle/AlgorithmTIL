import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 왼쪽(작은 값들) - 최대힙, 오른쪽(큰 값들) - 최소힙
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // min-heap

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            // 1) 크기 균형: 항상 left 크기 >= right 크기가 되도록
            if (left.size() == right.size()) left.offer(x);
            else right.offer(x);

            // 2) 정렬 조건 보정: left의 최대 <= right의 최소를 항상 보장
            if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                int a = left.poll();
                int b = right.poll();
                left.offer(b);
                right.offer(a);
            }

            // 현재 중앙값은 left의 top
            out.append(left.peek()).append('\n');
        }

        System.out.print(out);
    }
}
