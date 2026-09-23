import java.util.*;

class Solution {

    public String[] solution(String[] record) {

        // uid를 key로, 최종 닉네임을 value로 저장할 HashMap 생성
        // 예: "uid1234" -> "Muzi"
        Map<String, String> map = new HashMap<>();


        // 1차 순회:
        // 모든 기록을 확인하면서 각 uid의 "최종 닉네임"을 HashMap에 저장한다.
        for (int i = 0; i < record.length; i++) {

            // record[i]에는 다음과 같은 문자열 하나가 들어있다.
            // 예: "Enter uid1234 Muzi"
            //
            // 공백(" ")을 기준으로 문자열을 나눈다.
            //
            // 결과:
            // parts[0] = "Enter"
            // parts[1] = "uid1234"
            // parts[2] = "Muzi"
            String[] parts = record[i].split(" ");


            // 명령어를 저장한다.
            // Enter, Leave, Change 중 하나가 들어간다.
            String command = parts[0];


            // 사용자의 고유 ID를 저장한다.
            // uid는 닉네임이 바뀌어도 변하지 않는다.
            String uid = parts[1];


            // Enter와 Change 명령에는 닉네임 정보가 존재한다.
            //
            // Enter  uid1234 Muzi
            // Change uid1234 Prodo
            //
            // 반면 Leave는
            //
            // Leave uid1234
            //
            // 처럼 닉네임이 없기 때문에 parts[2]에 접근하면 안 된다.
            if (command.equals("Enter") || command.equals("Change")) {

                // Enter 또는 Change인 경우 세 번째 값이 닉네임이다.
                String nickname = parts[2];


                // uid를 key, nickname을 value로 HashMap에 저장한다.
                //
                // 예:
                // map.put("uid1234", "Muzi");
                //
                // 만약 같은 uid가 이미 존재한다면 기존 닉네임을 덮어쓴다.
                //
                // 예:
                // 기존: uid1234 -> Muzi
                //
                // map.put("uid1234", "Prodo");
                //
                // 결과: uid1234 -> Prodo
                //
                // 이 특징을 이용해서 "최종 닉네임"을 저장한다.
                map.put(uid, nickname);
            }
        }


        // 결과 메시지를 저장할 List 생성
        //
        // 최종적으로 String[]을 반환해야 하지만,
        // 결과 메시지가 몇 개인지 미리 계산하기 번거롭기 때문에
        // 크기가 자유롭게 늘어나는 ArrayList를 사용한다.
        List<String> answer = new ArrayList<>();


        // 2차 순회:
        // 다시 record를 처음부터 읽으면서 실제 출력 메시지를 만든다.
        for (int i = 0; i < record.length; i++) {

            // 현재 기록을 공백 기준으로 다시 나눈다.
            String[] parts = record[i].split(" ");


            // 현재 명령어를 가져온다.
            String command = parts[0];


            // 현재 사용자의 uid를 가져온다.
            String uid = parts[1];


            // Enter 명령이면 입장 메시지를 만들어야 한다.
            if (command.equals("Enter")) {

                // map.get(uid)를 사용하면 해당 uid의 "최종 닉네임"을 가져올 수 있다.
                //
                // 예:
                // map.get("uid1234")
                // -> "Prodo"
                //
                // 최종 닉네임 + 입장 문구를 합쳐서 answer에 추가한다.
                answer.add(map.get(uid) + "님이 들어왔습니다.");
            }


            // Leave 명령이면 퇴장 메시지를 만들어야 한다.
            else if (command.equals("Leave")) {

                // Leave 기록 자체에는 닉네임이 없지만,
                // uid를 이용해 HashMap에서 최종 닉네임을 찾을 수 있다.
                answer.add(map.get(uid) + "님이 나갔습니다.");
            }


            // Change는 닉네임만 변경하는 명령이므로
            // 채팅방 메시지에는 출력되지 않는다.
            //
            // 따라서 Change인 경우에는 아무 작업도 하지 않는다.
        }


        // 현재 answer의 타입은 List<String>이다.
        //
        // 하지만 문제에서 요구하는 반환 타입은 String[]이다.
        //
        // 따라서 List<String>을 String[] 배열로 변환해서 반환한다.
        return answer.toArray(new String[0]);
    }
}