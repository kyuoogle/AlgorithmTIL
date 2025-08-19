import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		String[] Days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		int[] Months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int n = 0;
		
		for(int i = 0; i < M; i++) {
			n += Months[i];
		}
		n += D - 1;
		
		System.out.print(Days[n%7]);
	}
}
