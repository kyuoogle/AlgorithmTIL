import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = Integer.MIN_VALUE; //합이 음수가 나올 수도 있음
        
        for (int i = 0; i <= N - K; i++) {
        	int sum = 0;
        	for(int j = i; j < i + K; j++) {
        		sum += nums[j];
        	}
        	max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}