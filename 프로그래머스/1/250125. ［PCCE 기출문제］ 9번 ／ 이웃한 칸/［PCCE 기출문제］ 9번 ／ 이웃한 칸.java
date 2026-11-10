class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length; // 보드 길이
        int ans = 0; // 이웃한 칸들 중 같은 색의 칸의 수 저장용
        
        // 우, 하, 상, 좌 순서
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if(board[h][w].equals(board[h_check][w_check])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}