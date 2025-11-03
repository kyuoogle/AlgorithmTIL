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
        int N = Integer.parseInt(br.readLine());

        int[] time = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int prev = 0; // 이전까지의 대기시간 누적합
        int sum = 0; // 사람별 대기시간의 총합
        for(int i = 0; i < N; i++) {
            sum += prev + time[i];
            prev += time[i];
        }
        System.out.println(sum);
    }
}
