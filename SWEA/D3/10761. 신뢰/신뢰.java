import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int TC = Integer.parseInt(br.readLine());
	
	for(int t = 1; t <= TC; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		//눌러야 할 버튼의 수
		int N = Integer.parseInt(st.nextToken());
		
		//출발 위치
		int B_position = 1;
		int O_position = 1;
		
		//이동 시간
		int B_move = 0;
		int O_move = 0;
		
		//총 소요시간(최소 시간을 답으로 출력)
		int minTime = 0; // 일종의 카운트 변수
		
		//main logic
		for(int i = 0; i < N; i++) {
			//target에 로봇, 버튼에 숫자 저장
			String target = st.nextToken();
			int button = Integer.parseInt(st.nextToken());
			
			if(target.equals("B")) {
				//해당 위치로 이동하는 소요시간
				int moving = Math.abs(button - B_position);
				//기존 소요시간과 이번에 이동한 시간과 합해, 누적 소요시간과 이동 시간 중 더 큰 것을 선택
				int moveT = B_move + moving;
				minTime = Math.max(minTime, moveT);
				//소요시간 증가
				minTime++;
				
				//이동 위치로 갱신
				B_move = minTime;
				B_position = button;
				
			}//B와 동일 
			else if(target.equals("O")) {
				int moving = Math.abs(button - O_position);
				int moveT = O_move + moving;
				minTime = Math.max(minTime, moveT);
				
				minTime++;
				
				O_move = minTime;
				O_position = button;
			}
		}
		System.out.println("#" + t + " " + minTime);
		}
	}
}
