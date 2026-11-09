class Solution {
    // 동영상 길이 video_len, 기능 수행 전 현위치 pos, 오프닝 시작 시간 op_start, 오프닝 끝 op_end, 사용자 입력 commands
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 10초 전으로 이동 prev: 현위치가 10초 미만일 시 처음으로 이동
        // 10초 후로 이동 next: 남은 시간이 10초 미만일 시 영상 끝으로 이동
        // 오프닝 건너뛰기 기능 제공: 현 위치가 오프닝 구간일 시 op_end로 이동
        // 사용자 입력이 모두 끝난 후의 동영상 위치를 "mm:ss"형식으로 반환
        
        // 먼저 주어진 시간들 모두 초로 변환
        int video = toSecond(video_len); // 비디오 총 길이
        int current = toSecond(pos); // 현재 위치
        int opStart = toSecond(op_start); // 오프닝 시작 지점
        int opEnd = toSecond(op_end); // 오프닝 끝 지점
        
        // 현재 위치가 오프닝 구간인지 확인
        if(current >= opStart && current <= opEnd) {
            current = opEnd;
        }
        
        // 명령어 실행
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("prev")) {
                current -= 10;
                if(current < 0) current = 0;
            } else if(commands[i].equals("next")) {
                current += 10;
                if(current > video - 10) current = video;
            }
            if(current >= opStart && current <= opEnd) current = opEnd;
        }
        int minute = current / 60;
        int second = current % 60;
        
        return String.format("%02d:%02d", minute, second);
    }
    
    // 초로 변환하기 위한 메서드
    public int toSecond(String time) {
        String[] arr = time.split(":");
        
        int minute = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        
        return minute * 60 + second;
    }
}