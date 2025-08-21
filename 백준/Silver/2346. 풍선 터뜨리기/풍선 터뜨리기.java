import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 풍선 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 풍선 생성
        Queue<Integer> B = new LinkedList<>();
        //풍선은 1부터 N까지 N개 있으므로, N + 1로 설정해 인덱스를 1번부터 사용
        for(int i = 1; i < N + 1; i++) {
        	B.offer(i);
        }
        
        // 풍선에 들어있는 이동 값
        int[] move = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
        	move[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 0;
        
        while(!B.isEmpty()) {
        	//현재 풍선 터뜨리기
        	int curr = B.poll();
        	sb.append(curr).append(" ");
        	
        	if(B.isEmpty()) break;
        	
        	int step = move[curr];
        	
        	//회전 횟수 계산(왼쪽 회전으로 통일)
        	int rotate;
        	int sz = B.size();
        	
        	if (step > 0) {
                // 양수: 오른쪽(시계) step-1칸 이동 == 왼쪽 (step-1)칸 회전
                rotate = (step - 1) % sz;
            } else {
                // 음수: 왼쪽(반시계) |step|칸 이동 == 오른쪽 |step|칸 회전
                // 오른쪽 r칸 회전 == 왼쪽 (sz - (r % sz))칸 회전
                int r = Math.abs(step) % sz;
                rotate = (sz - r) % sz;
            }

            // 왼쪽으로 rotate번 회전: front를 빼서 뒤로 붙이기
            for (int i = 0; i < rotate; i++) {
                B.offer(B.poll());
            }
        }

        System.out.println(sb);
    }
}