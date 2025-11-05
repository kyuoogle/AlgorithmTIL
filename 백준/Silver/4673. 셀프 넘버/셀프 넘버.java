//import java.io.*;
//import java.util.*;

public class Main{
	
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] selfNum = new boolean[10001];
		
		for(int i = 1; i <= 10000; i++) {
			int n = d(i);
			if(n <= 10000) {
				selfNum[n] = true;
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(!selfNum[i]) System.out.println(i);
		}
	}
	
	static int d(int n) {
		int sum = n;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}