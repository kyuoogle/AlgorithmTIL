import java.util.*;

class Solution {
    public int[] solution(String msg) {

        // 알파벳을 키로, 숫자 순서를 밸류로 맵 만들기
        Map<String, Integer> map = new HashMap<>();

        // 맵에 A부터 Z까지 값 입력
        int number = 1;

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), number);
            number++;
        }

        // A~Z 다음에 추가할 단어의 번호
        int nextNum = 27;

        // 출력되는 숫자를 순서대로 저장할 리스트
        List<Integer> result = new ArrayList<>();

        // 문자열의 현재 위치
        int i = 0;

        // 문자열 끝까지 반복
        while (i < msg.length()) {

            // 현재 위치의 한 글자를 문자열로 저장
            // 예: KAKAO에서 처음에는 "K"
            String word = String.valueOf(msg.charAt(i));

            // 현재 위치 바로 다음 위치부터 확인
            int j = i + 1;

            // 현재 문자열보다 더 긴 문자열이
            // 사전에 존재하는지 계속 확인
            while (j < msg.length()) {

                // 현재 위치 i부터 j까지 문자열을 가져옴
                // 예: "K" 다음에는 "KA" 확인
                String nextWord = msg.substring(i, j + 1);

                // 더 긴 문자열도 이미 사전에 있다면
                if (map.containsKey(nextWord)) {

                    // 현재 가장 긴 문자열을 갱신
                    word = nextWord;

                    // 한 글자 더 붙여서 확인
                    j++;
                }

                // 더 긴 문자열이 사전에 없다면
                else {

                    // 새로운 문자열을 사전에 등록
                    map.put(nextWord, nextNum);

                    // 다음에 등록할 번호 증가
                    nextNum++;

                    // 더 이상 길게 확인할 필요 없으므로 종료
                    break;
                }
            }

            // 사전에 존재했던 가장 긴 문자열의 번호를 결과에 저장
            result.add(map.get(word));

            // 사용한 문자열 길이만큼 다음 위치로 이동
            // 예: word가 "KA"였다면 2칸 이동
            i = i + word.length();
        }

        // List<Integer>를 int[]로 변환
        int[] answer = new int[result.size()];

        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }

        return answer;
    }
}