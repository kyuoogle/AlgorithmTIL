
import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 1인당 M번 공을 받으면 종료되는 공 던지기 게임
	 * - N명이 있음
	 * - 공을 받으면 다른 사람에게 던져야 함
	 * - 공을 받은 시점에 받은 횟수가 홀수면, 시계 방향으로 L번째 사람에게 던지기
	 * 					 	   짝수면, 반시계 방향으로 L번째 사람에게 던지기
	 * - 공을 몇 번 던지는지 횟수 출력
	 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //입력
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 인당 공을 받아야만 하는 횟수
        int L = Integer.parseInt(st.nextToken()); // 몇번째 사람에게 던져야 하는지
        
        //인당 몇번 받았는 지 체킹하는 배열
        //1~N까지 있으니까 인덱스를 자리로 사용하기 위해 배열 크기 + 1해서
        //인덱스를 1부터 N까지 모두 사용 가능하게 선언
        int[] ball = new int[N+1];
        
        
     // 메인로직
        int cur = 1;      // 1번이 공을 갖고 시작
        ball[cur] = 1;    // 시작하자마자 1번이 1회 수령
        int cnt = 0;      // 던진 횟수

        while (true) {
            if (ball[cur] == M) break;  // 현재 사람이 M번 받으면 종료

            if (ball[cur] % 2 == 1) {
                // 홀수: 시계 방향(오른쪽) L명
                cur = (cur + L - 1) % N + 1;          // 1-based 모듈러
            } else {
                // 짝수: 반시계 방향(왼쪽) L명
                cur = (cur - L - 1 + N) % N + 1;      // 음수 방지 + 1-based 모듈러
            }

            ball[cur]++;   // 새로 받은 사람 카운트
            cnt++;         // 던진 횟수 증가
        }

        System.out.println(cnt);

    }
}
