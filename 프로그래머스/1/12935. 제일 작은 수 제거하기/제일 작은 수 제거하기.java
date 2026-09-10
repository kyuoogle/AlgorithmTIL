import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return new int[]{-1};
            
        int[] ans = new int[arr.length - 1];
        
        
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) {
                ans[idx] = arr[i];
                idx++;
            }
        }
        
        return ans;
    }
}