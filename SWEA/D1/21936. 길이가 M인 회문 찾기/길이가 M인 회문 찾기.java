import java.io.*;
import java.util.*;


public class Solution {
	
	// s의 [start .. start+len-1] 구간이 회문인지 확인하는 함수
    private static boolean isPalindrome(String s, int start, int len) {
        int L = start;
        int R = start + len - 1;
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) return false;
            L++;
            R--;
        }
        return true;
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            // N, M 읽기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            																																														
            // 길이 N인 문자열
            String str = br.readLine();

            boolean found = false;

            // 시작 인덱스 s를 0..N-M까지 움직이며 길이 M 구간을 회문 검사
            for (int s = 0; s <= N - M; s++) {
                if (isPalindrome(str, s, M)) {
                    // 회문 발견 시 즉시 출력 형식에 맞춰 기록하고 다음 테스트케이스로
                    out.append('#').append(tc).append(' ')
                       .append(str, s, s + M).append('\n');
                    found = true;
                    break;
                }
            }

            // 끝까지 없으면 NONE
            if (!found) {
                out.append('#').append(tc).append(' ')
                   .append("NONE").append('\n');
            }
        }

        System.out.print(out.toString());
    }
}