import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 3명의 정답 제출 패턴
        int[] giveup1 = new int[]{1, 2, 3, 4, 5};
        int[] giveup2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveup3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 문제를 맞춘 수를 세기 위한 변수
        int g1 = 0;
        int g2 = 0;
        int g3 = 0;
        
        // for문으로 정답과 제출 답안 비교해 개인 별 맞춘 개수 증가
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == giveup1[i % giveup1.length]) g1++;
            if(answers[i] == giveup2[i % giveup2.length]) g2++;
            if(answers[i] == giveup3[i % giveup3.length]) g3++;
        }
        // 가장 많이 맞춘 사람의 정답 수 확인
        int max = Integer.max(g1, Integer.max(g2, g3));
        
        // 가장 맞춘 사람을 출력하기 위한 정답용 리스트
        List<Integer> result = new ArrayList<>();
        
        if(max == g1) result.add(1);
        if(max == g2) result.add(2);
        if(max == g3) result.add(3);
        
        // 정답 배열
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}