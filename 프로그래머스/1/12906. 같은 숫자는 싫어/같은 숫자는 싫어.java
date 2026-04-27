import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int lastNum = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != lastNum) {
                list.add(arr[i]);
                lastNum = arr[i];
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}