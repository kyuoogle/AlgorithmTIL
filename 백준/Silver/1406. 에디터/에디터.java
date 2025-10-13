import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		
		String s = br.readLine();
		
		for(int i = 0; i < s.length(); i++)
			left.addLast(s.charAt(i));
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			char cmd = line.charAt(0);
			switch(cmd) {
				case 'L':
	                if (!left.isEmpty()) right.addFirst(left.removeLast());
	                break;
	            case 'D':
	                if (!right.isEmpty()) left.addLast(right.removeFirst());
	                break;
	            case 'B':
	                if (!left.isEmpty()) left.removeLast();
	                break;
	            case 'P':
	                char x = line.charAt(2);
	                left.addLast(x);
	                break;
			}
		}

	    StringBuilder sb = new StringBuilder(left.size() + right.size());
	    for (char c : left) sb.append(c);
	    while (!right.isEmpty()) sb.append(right.removeFirst());
	    System.out.print(sb.toString());
	}
}
