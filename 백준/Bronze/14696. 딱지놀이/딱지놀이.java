import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//게임 진행할 라운드 수 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		int A[], B[];
		
		for(int n = 0; n < N; n++) {
			A = new int[4];
			B = new int[4];
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int i = 0; i < a; i++) {
				A[Integer.parseInt(st.nextToken()) - 1]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int i = 0; i < b; i++) {
				B[Integer.parseInt(st.nextToken()) - 1]++;
			}
			
			for(int i = 3; i >= 0; ) {
				if(i == 0 && A[i] == B[i]) {
					System.out.println('D');
					break;
				}
				if(A[i] == B[i]) {
					i--;
					continue;
				}
				if(A[i]>B[i]) {
					System.out.println('A');
					break;
				}
				else if(A[i]<B[i]) {
					System.out.println('B');
					break;
				}
			}
		}
	}
}
