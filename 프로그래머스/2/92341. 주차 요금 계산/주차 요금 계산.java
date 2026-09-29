import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        // 차량별 입차 시간을 저장하는 배열
        // -1이면 현재 주차장에 없는 차량
        int[] inTime = new int[10000];
        Arrays.fill(inTime, -1);

        // 차량별 누적 주차 시간을 저장하는 배열
        int[] totalTime = new int[10000];

        // 한 번이라도 등장한 차량인지 확인하는 배열
        boolean[] used = new boolean[10000];


        // 모든 입출차 기록 확인
        for (int i = 0; i < records.length; i++) {

            // 공백 기준으로 문자열 분리
            String[] parts = records[i].split(" ");

            // 첫 번째 값은 시간
            String time = parts[0];

            // 두 번째 값은 차량번호
            String carString = parts[1];

            // 세 번째 값은 IN 또는 OUT
            String status = parts[2];


            // 차량번호를 정수로 변환
            // "5961" -> 5961
            // "0000" -> 0
            int car = Integer.parseInt(carString);

            // 시간을 분 단위로 변환
            // "05:34" -> 334
            int minute = toMinute(time);

            // 등장한 차량이라고 표시
            used[car] = true;


            // 입차인 경우
            if (status.equals("IN")) {

                // 해당 차량의 입차 시간을 저장
                inTime[car] = minute;
            }

            // 출차인 경우
            else {

                // 현재 출차시간 - 입차시간으로 주차시간 계산
                int parkingTime = minute - inTime[car];

                // 기존 누적 주차시간에 이번 주차시간을 더함
                totalTime[car] = totalTime[car] + parkingTime;

                // 출차했으므로 현재 주차장에 없는 상태로 변경
                inTime[car] = -1;
            }
        }


        // 23:59를 분으로 변환
        int endOfDay = toMinute("23:59");


        // 출차하지 않고 남아있는 차량 확인
        for (int car = 0; car < 10000; car++) {

            // 입차 시간이 -1이 아니면 아직 출차하지 않은 차량
            if (inTime[car] != -1) {

                // 23:59에 출차했다고 가정해서 주차시간 계산
                int parkingTime = endOfDay - inTime[car];

                // 누적 주차시간에 더함
                totalTime[car] = totalTime[car] + parkingTime;
            }
        }


        // 총 몇 대의 차량이 등장했는지 계산
        int count = 0;

        for (int car = 0; car < 10000; car++) {

            // 등장한 차량이면 개수 증가
            if (used[car]) {
                count++;
            }
        }


        // 등장한 차량 수만큼 정답 배열 생성
        int[] answer = new int[count];

        // 정답 배열의 위치
        int index = 0;


        // 차량번호 0000부터 9999까지 순서대로 확인
        // 이렇게 하면 따로 정렬할 필요가 없음
        for (int car = 0; car < 10000; car++) {

            // 등장하지 않은 차량은 넘어감
            if (!used[car]) {
                continue;
            }


            // 해당 차량의 총 주차시간
            int time = totalTime[car];


            // 기본시간 이하라면 기본요금
            if (time <= fees[0]) {

                answer[index] = fees[1];
            }

            // 기본시간을 초과했다면 추가요금 계산
            else {

                // 기본시간을 제외한 초과시간 계산
                int extraTime = time - fees[0];

                // 초과시간을 단위시간으로 나눔
                int unitCount = extraTime / fees[2];

                // 나누어 떨어지지 않으면 한 단위를 추가
                if (extraTime % fees[2] != 0) {
                    unitCount++;
                }

                // 기본요금 + 추가요금 계산
                answer[index] =
                        fees[1] + unitCount * fees[3];
            }


            // 다음 정답 위치로 이동
            index++;
        }


        return answer;
    }


    // "05:34" 같은 시간을 전체 분으로 바꾸는 메서드
    private int toMinute(String time) {

        // ":" 기준으로 시와 분을 분리
        String[] hm = time.split(":");

        // 앞부분을 시간으로 변환
        int hour = Integer.parseInt(hm[0]);

        // 뒷부분을 분으로 변환
        int minute = Integer.parseInt(hm[1]);

        // 시간을 분으로 바꾼 뒤 분을 더해서 반환
        return hour * 60 + minute;
    }
}