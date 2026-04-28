import java.util.*;

class Solution {
    // H-Index: 발표 논문 n편 중 h번 이상 인용된 논문이 h편 이상,
    // 나머지 논문이 h번 이하 인용이라면 h의 최댓값이 H-Index
    public int solution(int[] citations) {
        // 예시 이해
        // 5편의 논문 발표, 인용 수 3편의 논문이 3회 이상 인용됨, 나머지는 3회 이하(0, 1) 2편
        // H-Index는 3
        
        Arrays.sort(citations);
        
        int n = citations.length;
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문부터 끝까지
            
            if(citations[i] >= h) {
                ans = h;
                break;
            }
        }
        
        return ans;
    }
}