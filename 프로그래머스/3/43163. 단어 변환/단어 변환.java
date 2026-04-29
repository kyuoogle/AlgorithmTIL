import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Deque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.pollFirst();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(cur.word, words[i])) {
                    visited[i] = true;
                    q.addLast(new Node(words[i], cur.count + 1));
                }
            }
        }

        return 0;
    }

    boolean canChange(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}