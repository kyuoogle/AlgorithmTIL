import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
                
        for(int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] newArr = new int[j - i + 1];
            for(int h = 0; h < newArr.length; h++) {
                newArr[h] = array[i - 1 + h];
            }
            
            Arrays.sort(newArr);
            
            ans[l] = newArr[k-1];
        }
        
        return ans;
    }
}