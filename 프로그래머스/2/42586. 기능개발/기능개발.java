import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 1. 각 기능이 며칠 뒤에 완성되는지 계산해서 저장합니다.
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int workLeft = 100 - progresses[i]; // 남은 작업량
            int day = workLeft / speeds[i];     // 걸리는 일수 (몫)
            
            // 만약 나누어 떨어지지 않는다면 하루가 더 필요합니다.
            if (workLeft % speeds[i] != 0) {
                day = day + 1;
            }
            days[i] = day;
        }

        // 2. 함께 배포될 기능의 개수를 계산합니다.
        List<Integer> resultList = new ArrayList<>();
        
        // 첫 번째 기능을 기준으로 삼습니다.
        int standardDay = days[0]; 
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            // 현재 기능(days[i])이 기준일(standardDay) 이전에 완성된다면?
            if (days[i] <= standardDay) {
                // 함께 배포할 목록에 추가
                count = count + 1;
            } else {
                // 기준일보다 오래 걸리는 기능이 나오면, 지금까지 쌓인 기능을 배포합니다.
                resultList.add(count);
                
                // 이제 이 오래 걸리는 기능을 새로운 기준으로 삼습니다.
                standardDay = days[i];
                count = 1; 
            }
        }
        // 마지막에 남은 기능 뭉치를 추가합니다.
        resultList.add(count);

        // 3. 결과 리스트를 배열로 옮겨 담습니다.
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}