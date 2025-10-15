import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[3];
        
        for(int i = 0; i < 3; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < 3; i++) {
        	System.out.print(nums[i] + " ");
        }
    }
}
