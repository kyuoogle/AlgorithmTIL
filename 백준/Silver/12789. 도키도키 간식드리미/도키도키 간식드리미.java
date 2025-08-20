import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] priority = new int[N];
		
		for(int i = 0; i < N; i++) {
			priority[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int turn = 1;
		
		for(int i = 0; i < priority.length; i++) {
			int curr = priority[i];
			
			if(curr == turn) {
				//현재 차례가 온 사람에게 줄 수 있으면 바로 주고
				turn++;
				//스택 맨 위의 사람에게도 바로 줄 수 있으면(순서가 맞으면) 계속 줌
				while(!stack.isEmpty() && stack.peek() == turn) {
					stack.pop();
					turn++;
				}
			} else {
				//아직 차례가 아니면 스택으로 보내기
				stack.push(curr);
			}
		}
		//남아 있는 사람들도 스택에 담긴 순서대로 줄 수 있는 지 확인
		while(!stack.isEmpty() && stack.peek() == turn) {
			stack.pop();
			turn++;
		}
		if(stack.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}
}
