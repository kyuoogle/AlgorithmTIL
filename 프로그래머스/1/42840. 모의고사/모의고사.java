import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i % num1.length]) cnt1++;
            if (answers[i] == num2[i % num2.length]) cnt2++;
            if (answers[i] == num3[i % num3.length]) cnt3++;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> result = new ArrayList<>();
        
        if(cnt1 == max) result.add(1);
        if(cnt2 == max) result.add(2);
        if(cnt3 == max) result.add(3);
        
        int[] ans = new int[result.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}