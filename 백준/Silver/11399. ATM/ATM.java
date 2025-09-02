
import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 종료 시간이 아니라 "대기 시간의 총합"
	 * 어떻게 배치하던 총 걸리는 시간은 같더라도, 한 사람의 대기 시간은 달라질 수 있음
	 * =>입력 받은 각각의 인출 소요 시간을 오름차순으로 정렬해 대기 시간을 구해주자
	 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 대기하는 사람 수 입력 받기
        int N = Integer.parseInt(br.readLine());
        // 인당 현금 인출 시간 저장할 배열
        int[] time = new int[N];
        // 배열에 인당 인출 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	time[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(time);
        
        int prev = 0; //이전까지의 대기시간 누적 합
        int sum = 0; // 사람별 대기시간 총합
        
        for(int i = 0; i < N; i++) {
        	// 이전까지의 대기 시간과 현재 사람이 걸리는 시간을 더해줌
        	sum += prev + time[i];
        	
        	//이전까지의 누적합에 현재 걸리는 시간을 더해줌
        	prev += time[i];
        }
        System.out.println(sum);
    }
}
