class Solution {
    // 직원 n명의 출근 희망 시각 schedules, 직원들 실제 출근 시각 timelogs, 이벤트 시작 일자 startday
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 직원은 자신이 설정한 출근 희망 시각 + 10분까지 출근해야 함
        // 토요일, 일요일은 제외
        // 모든 시각은 시에 100 곱하고 분을 더한 정수로 표현
        // 평일 5일 모두 정시 출근한 직원의 수를 구해야 함
        int ans = 0; // 선물 받을 직원의 수
        
        for(int i = 0; i < schedules.length; i++) {
            // 직원들의 출근 희망 시간 분 단위로 변경
            int h = schedules[i] / 100; // 시간
            int m = schedules[i] % 100; // 분
            
            // 출근 인정 시각 구하기
            int limit = h * 60 + m + 10;
            
            // 해당 직원의 정시 출근 성공 유무
            boolean success = true;
            
            for(int j = 0; j < 7; j++) {
                // 현재 날짜의 요일 계산
                int day = (startday + j - 1) % 7 + 1;
                
                // 토요일, 일요일은 제외
                if(day == 6 || day == 7) continue;
                
                // 요일 별 출근 시간 분으로 변환
                int workH = timelogs[i][j] / 100;
                int workM = timelogs[i][j] % 100;
                
                int workTime = workH * 60 + workM;
                
                if(workTime > limit) {
                    success = false;
                    break;
                }
            }
            // 평일에 지각하지 않았다면
            if(success == true) ans++;
        }
        return ans;
    }
}