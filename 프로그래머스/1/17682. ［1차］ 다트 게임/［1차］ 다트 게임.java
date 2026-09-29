class Solution {
    public int solution(String dartResult) {
        // 3라운드의 점수를 담을 배열
        int[] score = new int[3];
        // 현재 몇라운드인지 나타내는 변수
        // 점수 배열은 인덱스 0부터 시작하니까 -1부터 시작
        int round = -1;
        
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            // 현재 문자가 숫자이면 다음 라운드 시작된거니까
            if(Character.isDigit(c)) {
                round++;
                // 문자로 받은 거 정수로 만들기
                int number = c - '0';
                // 만약에 10점을 맞췄다면 10점은 두 글자니까 따로 조건문
                // 다만 i가 3라운드 이내인지도 체크
                if(c == '1' && dartResult.charAt(i + 1) == '0' && i + 1 < dartResult.length()) {
                    number = 10;
                    i++;
                }
                // 해당 라운드의 기본 점수 저장
                score[round] = number;
            } else if(c == 'S') {
                // S는 1제곱
                score[round] = score[round];
            } else if(c == 'D') {
                // D는 제곱
                score[round] = score[round] * score[round];
            } else if(c == 'T') {
                // T는 세제곱
                score[round] = score[round] * score[round] * score[round];
            } else if(c == '*') {
                // *는 이전 점수들을 모두 2배로
                score[round] = score[round] * 2;
                // 첫 라운드가 아니면 해당 라운드 이전 점수도 2배해야 하니까
                if(round > 0) {
                    score[round - 1] = score[round - 1] * 2;
                }
            }
            else if(c == '#') {
                // 아차상은 음수화
                score[round] = score[round] * -1;
            }
        }
        int ans = score[0] + score[1] + score[2];
        return ans;
    }
}