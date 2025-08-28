import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	//열린 괄호와 닫힌 괄호 배열 선언
    	char[] front = {'(', '[', '{', '<'};
    	char[] rear = {')', ']', '}', '>'};
    	
    	for(int tc = 1; tc <= 10; tc++) {
    		//길이 입력 받기
    		int len = Integer.parseInt(br.readLine());
    		//괄호 입력 받기
    		String str = br.readLine();
    		
    		//괄호를 담아놓은 스택 선언
    		Deque<Character> stack = new ArrayDeque<>();
    		//괄호가 잘 닫혔나 확인할 불리언 변수 선언
    		boolean ok = true;
    		
    		for(int i = 0; i < len; i++) {
    			char ch = str.charAt(i);
    			boolean isOpen = true;
    			
    			//닫는 괄호 체크
    			for(int j = 0; j < 4; j++) {
    				//닫는 괄호가 맞을 때
    				if(ch == rear[j]) {
    					//스택이 비었거나 짝이 맞지 않으면 실패
    					if(stack.isEmpty() || stack.peek() != front[j])
    						ok = false; 
    					else stack.pop();
    					
    					isOpen = false;
    					break;
    				}
    			}
    			
    			//닫는 괄호가 아니면 (=여는 괄호라는 얘기) 스택에 넣어버려
    			if(isOpen) stack.push(ch);
    			if(!ok) break;
    		}
    		ok = ok && stack.isEmpty();
    		
    		sb.append('#').append(tc).append(' ').append(ok ? '1' : '0').append('\n');
    	}
    	System.out.print(sb);
    }
}
