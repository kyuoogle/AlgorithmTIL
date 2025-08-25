import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1평당 자라는 참외 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[6];
		
		int wLongIdx = 5;
		int hLongIdx = 5;
		
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			arr[i] = length;
			
			if(direction == 1 || direction == 2) {
				if(arr[wLongIdx] < arr[i]) {
					wLongIdx = i;
				}
			}
			
			if(direction == 3 || direction == 4) {
				if(arr[hLongIdx] < arr[i]) {
					hLongIdx = i;
				}
			}
		}
		int wMinusIdx = wLongIdx - 1;
		if (wMinusIdx == -1) {
			wMinusIdx = 5;
		}
		
		int hMinusIdx = hLongIdx - 1;
		if (hMinusIdx == -1) {
			hMinusIdx = 5;
		}
		
		int hShort = arr[hLongIdx] - Math.min(arr[wMinusIdx], arr[(wLongIdx + 1)%6]);
		int wShort = arr[wLongIdx] - Math.min(arr[hMinusIdx], arr[(hLongIdx + 1)%6]);
		
		int bigRect = arr[wLongIdx] * arr[hLongIdx];
		int smallRect = hShort * wShort;
		
		System.out.println((bigRect - smallRect) * N);
	}
}