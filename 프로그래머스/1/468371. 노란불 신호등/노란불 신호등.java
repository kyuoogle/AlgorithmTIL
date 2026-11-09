class Solution {
    public int solution(int[][] signals) {
        
        int limit = 1; // 몇 초까지 계산할 지 판단하기 위한 변수
        
        for(int i = 0; i < signals.length; i++) {
            int green = signals[i][0];
            int yellow = signals[i][1];
            int red = signals[i][2];
            
            int cycle = green + yellow + red;
            
            limit = limit * cycle;
        }
        
        for(int time = 1; time <= limit; time++){
            boolean allY = true;
            
            for(int i = 0; i < signals.length; i++) {
                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];
                
                int cycle = green + yellow + red;
                
                int position = (time - 1) % cycle;
                
                if(position < green || position >= green + yellow) {
                    allY = false;
                    break;
                }
            }
            if(allY) return time;
        }
        
        return -1;
    }
}