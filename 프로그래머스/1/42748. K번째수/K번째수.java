import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
                
        for(int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] tmp = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(tmp);
            
            ans[l] = tmp[k - 1];
        }
        
        return ans;
    }
}