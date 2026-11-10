class Solution {
    public int solution(int[] mats, String[][] park) {
        int ans = -1;
        // 공원의 세로, 가로 길이
        int h = park.length;
        int w = park[0].length;
        
        // 돗자리 하나 씩 확인
        for(int i = 0; i < mats.length; i++) {
            int size = mats[i]; // 깔아야 할 돗자리의 한 변 길이(정사각형임)
            
            // 돗자리 놓을 시작 행
            for(int row = 0; row + size <= h; row++) {
                // 돗자리 놓을 시작 열
                for(int col = 0; col + size <= w; col++) {
                    // 돗자리 놓을 수 있는지 판단
                    boolean possible = true;
                    
                    // 돗자리 크기 만큼 내부 확인
                    for(int r = row; r < row + size; r++) {
                        for(int c = col; c < col + size; c++) {
                            // 이미 사람이 앉아있으면?
                            if(!park[r][c].equals("-1")) {
                                possible = false;
                                break;
                            }
                        }
                        // 못 앉으면 다음 칸
                        if(!possible) break;
                    }
                    if(possible) {
                        ans = Math.max(size, ans);
                    }
                }
            }
        }
        return ans;
    }
}