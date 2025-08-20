import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> num = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int cmd = Integer.parseInt(st.nextToken());
        	
        	switch (cmd) {
        		// 덱 앞에 값 추가
        		case 1: 
        			num.offerFirst(Integer.parseInt(st.nextToken()));
        			break;
        		// 덱 뒤에 값 추가
        		case 2:
        			num.offerLast(Integer.parseInt(st.nextToken()));
        			break;
        		// 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없다면 -1
        		case 3:
        			bw.write((num.isEmpty() ? -1 : num.pollFirst()) + "\n");
        			break;
        		// 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력, 없다면 -1
        		case 4:
        			bw.write((num.isEmpty() ? -1 : num.pollLast()) + "\n");
        			break;
        		//덱에 들어있는 정수의 개수 출력
        		case 5:
        			bw.write(num.size() + "\n");
        			break;
        		//덱이 비어있다면 1, 아니면 0 출력
        		case 6:
        			bw.write((num.isEmpty() ? 1 : 0) + "\n");
        			break;
        		// 덱에 정수가 있다면 맨 앞의 정수 출력, 없다면 -1
        		case 7:
        			bw.write((num.isEmpty() ? -1 : num.peekFirst()) + "\n");
        			break;
        		// 덱에 정수가 있다면 맨 뒤의 정수를 출력, 없다면 -1
        		case 8:
        			bw.write((num.isEmpty() ? -1 : num.peekLast()) + "\n");
        			break;
        	}
        }
        bw.flush();
        bw.close();
        br.close();
    }
}