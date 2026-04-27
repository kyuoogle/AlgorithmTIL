import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        // 우선순위큐는 오름차순으로 자동정렬이 됨
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            int mixed = first + (second * 2);
            
            pq.add(mixed);
            
            cnt = cnt + 1;
        }
        return cnt;
    }
}