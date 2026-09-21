import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer;
        
        int pCnt = 0;
        int yCnt = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(c == 'p') pCnt ++;
            else if(c == 'y') yCnt++;
        }
        
        if(pCnt == yCnt) answer = true;
        else answer = false;

        return answer;
    }
}