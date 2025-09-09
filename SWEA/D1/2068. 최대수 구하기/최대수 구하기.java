import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[] nums = new int[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			System.out.println("#" + tc + " " + nums[9]);
		}
	}
}
