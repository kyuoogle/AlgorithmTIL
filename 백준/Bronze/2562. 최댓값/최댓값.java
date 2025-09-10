import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] nums = new int[10];
        
        for(int i = 1; i < 10; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        
        int idx = 0;
        int max = 0;
        for(int i = 1; i < 10; i++) {
        	if(max < nums[i]) {
        		max = nums[i];
            	idx = i;
        	}
        }
        System.out.println(max);
        System.out.println(idx);
    }
}