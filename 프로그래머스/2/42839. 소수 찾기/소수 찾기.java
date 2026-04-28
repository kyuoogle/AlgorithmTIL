import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        dfs(numbers, "");

        int answer = 0;

        // for-each 대신 index 기반
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    void dfs(String numbers, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}