import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(score[i] > max) max = score[i];
		}
		
		double newScore = 0.0;
		for(int i = 0; i < N; i++) {
			newScore += (double) score[i] / max * 100.0;
		}
		System.out.printf("%.6f%n", newScore / N);
	}
}
