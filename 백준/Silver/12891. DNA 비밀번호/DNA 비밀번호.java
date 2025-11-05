import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
		
		String str = br.readLine(); // DNA 문자열 (A,C,G,T로만 구성)
		
		// 필요한 최소 개수 (A C G T 순서)
        st = new StringTokenizer(br.readLine());
        int[] need = new int[4];
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }
        
        // 현재 윈도우(현재 보고 있는 부분 문자열) 안에 들어있는 A C G T 개수
        int[] cur = new int[4];

        // 1) 처음 윈도우를 세팅 (0 ~ P-1까지 문자를 하나씩 보면서 개수 증가)
        for (int i = 0; i < P; i++) {
            char c = str.charAt(i);     // i번째 문자
            cur[toIdx(c)]++;            // 해당 문자가 A,C,G,T 중 뭐냐에 따라 개수++ 
        }

        int answer = 0;

        // 처음 윈도우가 조건을 만족하면 카운트
        if (check(cur, need)) answer++;

        // 2) 윈도우를 오른쪽으로 한 칸씩 미는 구간
        // right는 "새로 들어오는 문자"의 인덱스
        for (int right = P; right < S; right++) {
            int left = right - P; // 빠져나가는 문자 인덱스 = 현재 오른쪽 인덱스 - 윈도우 길이

            // 윈도우의 왼쪽 끝 문자를 하나 빼준다
            char out = str.charAt(left);
            cur[toIdx(out)]--;

            // 새로 오른쪽에서 들어오는 문자를 추가한다
            char in = str.charAt(right);
            cur[toIdx(in)]++;

            // 이 상태가 조건을 만족하면 정답++
            if (check(cur, need)) answer++;
        }

        System.out.println(answer);
    }
	
	// 문자 하나를 0~3으로 바꿔주는 함수
	// A -> 0, C -> 1, G -> 2, T -> 3
	private static int toIdx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1; // 여기 올 일은 없음
    }

    // 현재 윈도우(cur)가 필요한 최소 개수(need)를 만족하는지 확인
    private static boolean check(int[] cur, int[] need) {
        for (int i = 0; i < 4; i++) {
            if (cur[i] < need[i]) return false; // 하나라도 부족하면 실패
        }
        return true; // 네 개 다 만족하면 통과
    }
}
