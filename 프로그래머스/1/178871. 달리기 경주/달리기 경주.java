import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 현재 순위 배열 순회하여 선수, 등수(인덱스 활용) 맵에 저장
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            // 호출된 선수 이름 저장
            String called = callings[i];
            // 해당 선수의 현재 등수
            int idx = rank.get(called);
            // 호출된 선수 앞에 있는 선수
            String front = players[idx - 1];
            // players 배열에서 호출된 선수와 앞 선수 스왑
            players[idx - 1] = called;
            players[idx] = front;
            // rank 맵에서도 갱신
            rank.put(called, idx - 1);
            rank.put(front, idx);
        }
        return players;
    }
}