import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 의상 종류별 개수 파악 (기본 for문)
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 2. Map의 값(Value)들만 뽑아 리스트로 변환
        // 인덱스로 접근하기 위해 List 형태로 만듭니다.
        List<Integer> counts = new ArrayList<>(map.values());
        
        int answer = 1;
        
        // 3. 인덱스 i를 사용하여 모든 경우의 수 계산 (기본 for문)
        for (int i = 0; i < counts.size(); i++) {
            int count = counts.get(i);
            // (해당 종류 의상 개수 + 입지 않는 경우 1)을 곱함
            answer *= (count + 1);
        }
        
        // 4. 아무것도 입지 않은 경우 1을 빼고 반환
        return answer - 1;
    }
}