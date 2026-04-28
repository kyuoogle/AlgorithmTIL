class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;        
        
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            int bigger = Math.max(w, h);
            int smaller = Math.min(w, h);

            maxW = Math.max(maxW, bigger);
            maxH = Math.max(maxH, smaller);
        }
        
        return maxW * maxH;
    }
}