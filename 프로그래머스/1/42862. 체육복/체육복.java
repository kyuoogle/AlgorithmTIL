class Solution {
    
    // 전체 학생 수 n, 잃어버린 학생 번호 lost, 여벌 체육복 있는 학생 번호 reserve
    public int solution(int n, int[] lost, int[] reserve) {        
        boolean[] lostSt = new boolean[n + 1];
        boolean[] reserveSt = new boolean[n + 1];
        // 도난 당한 학생 상태 체크
        for(int i = 0; i < lost.length; i++) {
            lostSt[lost[i]] = true;
        }
        
        // 여분 체육복 있는 학생 체크
        for (int i = 0; i < reserve.length; i++) {
            reserveSt[reserve[i]] = true;
        }
        
        // 도난 받은 학생 중 여분이 있으면 자기 먼저 해결
        for(int i = 1; i <= n; i++) {
            if(lostSt[i] && reserveSt[i]) {
                lostSt[i] = false;
                reserveSt[i] = false;
            }
        }
        
        // 빌려주기
        for(int i = 1; i <= n; i++) {
            if(lostSt[i]) {
                // 앞 학생이 빌려주기
                if(i > 1 && reserveSt[i - 1]) {
                reserveSt[i - 1] = false;
                lostSt[i] = false;
                }
                
                // 뒷 학생이 빌려주기
                else if(i < n && reserveSt[i + 1]) {
                    reserveSt[i + 1] = false;
                    lostSt[i] = false;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(!lostSt[i]) ans++;
        }
        return ans;
    }
}