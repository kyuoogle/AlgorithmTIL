import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        /*
         * 요세푸스 순열
         * 
         * N(인원 수), K(죽을 사람)을 입력받음
         * K번째 사람을 제거하고, 1번부터 K-1까지의 사람을 다시 뒤로 보냄
         * (큐를 연결리스트로 구현했기 때문에, 처음과 끝이 이어진 것을 이렇게 구현)
         * 그 후, 모든 사람이 제거될 때까지 이 과정을 지속
         * 예를 들어 (7, 3)-요세푸스 순열이라고 했을 때,
         * 1) 1 2 3(죽을 사람) 4 5 6 7
         * 2) 4 5 6(죽을 사람) 7 1 2
         * 3) 7 1 2(죽을 사람) 4 5
         * 4 5 7(죽을 사람) 1 
         * 1 4 5(죽을 사람)
         * 4 1(죽을 사람)
         * 4(죽어!)
         * 결과적으로 죽은 순서는 <3, 6, 2, 7, 5, 1, 4>
         */
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> die = new LinkedList<>();
        
        for(int i = 1; i < N + 1; i++) {
        	die.add(i);
        }
        
        sb.append('<');
        
        while(!die.isEmpty()) {
        	for(int i = 1; i < K; i++) { // K-1번 반복
        		die.add(die.poll()); // 요소를 빼서 뒤로 다시 넣음
        	}
        	sb.append(die.poll()); // K번째 요소 제거 후 결과에 추가
        	
        	if(!die.isEmpty()) {
        	    sb.append(", ");
        	}
        }
        sb.append('>');
        System.out.println(sb);
    }
}