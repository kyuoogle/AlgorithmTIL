package linkedList;

import java.io.*;
import java.util.*;

public class SWEA_23667_암호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스
        for (int tc = 1; tc <= T; tc++) {
            // 숫자 개수 N
            // 지정 위치부터 M 번째 칸 추가
            // 작업을 K 번 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> pw = new LinkedList<Integer>();
 
            // pw에 초기 숫자들 집어넣기
            for (int i = 0; i < N; i++) {
                pw.add(Integer.parseInt(st.nextToken()));
            }
 
            // 현재 위치 curr
            int curr = 0;
            // K 번 반복
            for (int i = 0; i < K; i++) {
                curr = (curr + M) % pw.size();
                int sum;
                // 삽입 위치가 리스트의 맨 끝일 때
                if (curr == 0) {
                    curr = pw.size();
                    sum = pw.getLast() + pw.getFirst();
                } else
                    sum = pw.get(curr - 1) + pw.get(curr);
 
                pw.add(curr, sum);
            }
 
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = pw.size() - 1; i >= 0 && count < 10; i--) {
                sb.append(" ").append(pw.get(i));
                count++;
            }
            System.out.println("#" + tc + sb);
 
        }
	}
}