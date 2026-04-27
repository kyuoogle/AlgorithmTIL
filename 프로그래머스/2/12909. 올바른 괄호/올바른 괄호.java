import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                cnt = cnt + 1;
            } else {
                cnt = cnt - 1;
            }
            if(cnt < 0) return false;
        }
        
        if(cnt == 0) return true;
        else return false;
    }
}