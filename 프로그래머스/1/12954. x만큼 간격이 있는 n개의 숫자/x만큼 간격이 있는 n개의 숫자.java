class Solution {
    public long[] solution(int x, int n) {
        
        long[] ans = new long[n];
        
        for(int i = 1; i <= n; i++) {
            ans[i - 1] = (long) x * i;
        }
        
        return ans;
    }
}