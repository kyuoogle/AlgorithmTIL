class Solution {
    public int solution(String name) {
        int cnt = 0; // 조이스틱 조작 횟수 카운트
        int move = name.length() - 1; // 기본 좌우 이동: 오른쪽으로 끝까지 이동

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int joy = c - 'A';

            // 위/아래 이동
            if (joy > 13) {
                cnt += 26 - joy;
            } else {
                cnt += joy;
            }

            // 좌우 이동 최적화
            int next = i + 1;

            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우
            move = Math.min(move, i * 2 + name.length() - next);

            // 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
            move = Math.min(move, i + 2 * (name.length() - next));
        }

        cnt += move;

        return cnt;
    }
}