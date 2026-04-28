import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // 각 사용 횟수(1~8)에 해당하는 결과값을 저장할 Set 배열
        List<Set<Integer>> counts = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            counts.add(new HashSet<>());
        }

        // N을 1번 사용하는 경우
        counts.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            Set<Integer> currentSet = counts.get(i);

            // 1. N을 i번 이어 붙인 숫자 (예: 5, 55, 555...)
            int concatenated = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(concatenated);

            // 2. 사칙연산 조합 (j번 사용한 결과와 i-j번 사용한 결과의 연산)
            for (int j = 1; j < i; j++) {
                for (int a : counts.get(j)) {
                    for (int b : counts.get(i - j)) {
                        currentSet.add(a + b);
                        currentSet.add(a - b);
                        currentSet.add(a * b);
                        if (b != 0) {
                            currentSet.add(a / b);
                        }
                    }
                }
            }

            // 목표 숫자가 포함되어 있다면 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }

        return -1;
    }
}