class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    void dfs(int depth, int sum, int[] numbers, int target) {
        
        // 모든 숫자를 사용했는지
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        // 현재 숫자를 + 하는 경우
        dfs(depth + 1, sum + numbers[depth], numbers, target);
        // 현재 숫자를 - 하는 경우
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}