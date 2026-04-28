import java.util.*;

class Solution {
    
    ArrayList<String> st = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        // 단어의 길이는 1 이상 5 이하
        dfs("");
        
        for(int i = 0; i < st.size(); i++) {
            if (st.get(i).equals(word)) {
               return i + 1; 
            };
        }
        
        return 0;
    }
    
    // dfs로 모든 경우의 수 고려
    void dfs(String current) {
        if(current.length() > 5) {
            return;
        }
        
        if(!current.equals("")) {
            st.add(current);
        }
        
        for(int i = 0; i < vowels.length; i++) {
            dfs(current + vowels[i]);
        }
    }
}