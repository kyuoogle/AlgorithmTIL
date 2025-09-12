import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()); // 테이블 걸친 행의 수
		int W = Integer.parseInt(st.nextToken()); // 테이블 개수(열)
		int N = Integer.parseInt(st.nextToken()); // 세로로 띄울 거리
		int M = Integer.parseInt(st.nextToken()); // 가로로 띄울 거리
		
		int result = ((H - 1)/(N + 1) + 1) * ((W - 1) / (M + 1) + 1);
		System.out.println(result);
	}
}
