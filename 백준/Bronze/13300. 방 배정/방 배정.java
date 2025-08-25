import java.io.*;
import java.util.*;

/**
 * 규칙
 *  - 같은 방에는 "같은 성별" + "같은 학년" 학생만 들어갈 수 있다.
 *  - 한 방의 최대 인원은 K명이다.
 *  - 필요한 최소 방 개수를 출력한다.
 *
 * 아이디어
 *  - (성별 0/1) × (학년 1..6) → 총 12개 그룹으로 학생 수를 세어 둔다.
 *  - 각 그룹별로 필요한 방의 수 = ceil(그룹 인원 / K)
 *    = (그룹 인원 + K - 1) / K  (정수 나눗셈으로 올림 효과를 주는 전형적인 방식)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N(학생 수), K(방 최대 인원)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 1000
        int K = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 1000

        // cnt[s][y] : 성별 s(0=여, 1=남), 학년 y(1..6) 에 해당하는 학생 수
        // 학년 인덱스 0은 사용하지 않기 위해 크기를 7로 잡음(1~6 사용)
        int[][] cnt = new int[2][7];

        // 다음 N줄: 각 학생의 성별 S(0=여, 1=남), 학년 Y(1..6)
        for (int i = 0; i < N; i++) {
            // 매 학생마다 한 줄을 새로 읽고 토크나이저를 새로 만들어야 함
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 0 or 1
            int Y = Integer.parseInt(st.nextToken()); // 1..6

            // 해당 그룹 카운트 증가
            cnt[S][Y]++;
        }

        // 각 그룹별로 필요한 방 수를 올림하여 합산
        int rooms = 0;
        for (int s = 0; s <= 1; s++) {
            for (int y = 1; y <= 6; y++) {
                int people = cnt[s][y];
                if (people == 0) continue; // 해당 그룹에 학생이 없으면 건너뜀
                rooms += (people + K - 1) / K; // 정수 올림 나눗셈
            }
        }

        // 정답 출력
        System.out.println(rooms);
    }
}
