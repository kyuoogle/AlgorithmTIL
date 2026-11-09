class Solution {
    // 택배 상자 갯수 n, 한 층에 놓을 박스 수 w, 꺼낼 택배 상자 번호 num
    public int solution(int n, int w, int num) {
        // 상자 높이
        int h = (n / w);
        if(n % w != 0) h++;
        // 박스 정보 담을 배열
        int[][] boxes = new int[h][w];
        // 꺼내야 하는 박스의 위치
        int targetRow = 0;
        int targetCol = 0;
        
        for(int i = 1; i <= n; i++) {
            int row = (i - 1) / w; // 층
            int col = (i - 1) % w; // 층 내 박스의 위치
            
            if(row % 2 == 1) {
                col = w - 1 - col;
            }
            // 문제에 주어진 순서대로 박스 번호 저장
            boxes[row][col] = i;
            // 빼야하는 박스 위치 저장
            if(i == num) {
                targetRow = row;
                targetCol = col;
            }
        }
        // 빼야 하는 박스의 수(정답)
        int ans = 0;
        for(int i = targetRow; i < h; i++) {
            if(boxes[i][targetCol] != 0) ans++;
        }
        
        return ans;
    }
}