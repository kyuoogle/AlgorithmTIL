class Solution {
    public int[] solution(String s) {
        int[] ans = new int[s.length()];
        
        // 문자열 내 글자가 마지막 등장 위치를 저장할 배열
        int[] last = new int[26];
        
        // 처음에는 모두 등장하지 않았음으로 -1로 초기화
        for(int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        
        // 문자열 탐색
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            if(last[idx] == -1) {
                ans[i] = -1;
            } else {
                ans[i] = i - last[idx];
            }
            last[idx] = i;
        }
        return ans;
    }
}