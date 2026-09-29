class Solution {

    public String solution(String m, String[] musicinfos) {

        // 기억하고 있는 멜로디의 # 음계를 한 글자로 변환
        // 예: "ABC#" -> "ABc"
        m = changeMelody(m);

        // 조건에 맞는 곡이 없을 경우 반환할 기본값
        String answer = "(None)";

        // 현재까지 선택된 곡의 재생시간
        int maxPlayTime = -1;


        // 모든 음악 정보를 하나씩 확인
        for (int i = 0; i < musicinfos.length; i++) {

            // "," 기준으로 음악 정보를 분리
            // 0: 시작시간
            // 1: 종료시간
            // 2: 제목
            // 3: 악보
            String[] info = musicinfos[i].split(",");


            // 시작시간을 분 단위로 변환
            int startTime = toMinute(info[0]);

            // 종료시간을 분 단위로 변환
            int endTime = toMinute(info[1]);

            // 실제 음악이 재생된 시간 계산
            int playTime = endTime - startTime;


            // 음악 제목 저장
            String title = info[2];


            // 악보의 # 음계를 한 글자로 변환
            String melody = changeMelody(info[3]);


            // 실제 재생된 전체 멜로디를 만들기 위한 StringBuilder
            StringBuilder played = new StringBuilder();


            // 재생시간만큼 악보를 반복해서 실제 재생 멜로디 생성
            for (int j = 0; j < playTime; j++) {

                // 악보 길이를 넘어가면 처음부터 다시 반복
                // 예: ABC가 7분 재생되면 ABCABCA
                played.append(
                    melody.charAt(j % melody.length())
                );
            }


            // 실제 재생된 멜로디에 기억한 멜로디가 포함되어 있는지 확인
            if (played.toString().contains(m)) {

                // 기존에 선택한 곡보다 재생시간이 더 길면 정답 변경
                if (playTime > maxPlayTime) {

                    // 현재 곡 제목을 정답으로 저장
                    answer = title;

                    // 현재 곡의 재생시간 저장
                    maxPlayTime = playTime;
                }
            }
        }


        // 최종 선택된 곡 제목 반환
        return answer;
    }


    // "12:34" 형태의 시간을 분 단위로 바꾸는 메서드
    private int toMinute(String time) {

        // ":" 기준으로 시와 분을 분리
        String[] parts = time.split(":");

        // 시간 부분을 정수로 변환
        int hour = Integer.parseInt(parts[0]);

        // 분 부분을 정수로 변환
        int minute = Integer.parseInt(parts[1]);

        // 전체를 분 단위로 변환
        return hour * 60 + minute;
    }


    // #이 붙은 음을 한 글자로 바꾸는 메서드
    private String changeMelody(String melody) {

        // C#을 소문자 c로 변환
        melody = melody.replace("C#", "c");

        // D#을 소문자 d로 변환
        melody = melody.replace("D#", "d");

        // F#을 소문자 f로 변환
        melody = melody.replace("F#", "f");

        // G#을 소문자 g로 변환
        melody = melody.replace("G#", "g");

        // A#을 소문자 a로 변환
        melody = melody.replace("A#", "a");

        return melody;
    }
}