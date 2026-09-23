import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        // int -> String
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        // nums를 정렬할 때
        // a, b 두 원소를 뽑아서 정렬할 때, a + b와 b + a 중 더 큰 순서로 정렬한다
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        // 정렬 후 앞자리가 0이라면 모든 원소가 0이니까 그냥 0 반환
        if (nums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}