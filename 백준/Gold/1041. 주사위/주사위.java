import java.io.*;
import java.util.*;

//1041.주사위 
public class Main {
	static long n;
	static long[] arr;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new long[6];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long one = Long.MAX_VALUE; // one: 한면의 합의 최솟값 
		long two = Long.MAX_VALUE; // two: 이웃한 두 면의 합의 최솟값 
		long three = 0; // three: 이웃한 세 면의 합의 최솟값 
		long max = 0;
		long sum = 0;
		
		//one구하기: 주사위 6면중 가장 작은 값이 된다. 
		for (int i = 0; i < 6; i++) {
			one = Math.min(one, arr[i]);
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		
		//two 구하기: 이웃한 두 면이 되기 위해서는 마주보는 두면을 고르는 경우만 제외하면 된다. 
		//주사위 전개의 A~E를 0~5라고 보면, 두 면의 인덱스 합이 5인 경우가 마주보는 경우이다. 
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i + j != 5 && i != j)
					two = Math.min(two, arr[i] + arr[j]);
			}
		}

		//three 구하기: 전개도를 보면 마주보는면은 3쌍이 있는데, 각각의 쌍 중에 작은값들을 더하면 이웃한 세 면의 합의 최솟값이 된다.  
		//마주보는 두쌍의 인덱스 합은 5이므로 하나가 i인덱스 일때, 나머지 하나는 5-i번째 인덱스 이다. 
		for (int i = 0; i < 3; i++) {
			three += Math.min(arr[i], arr[5 - i]);
		}
		if (n == 1) { //n=1일경우, 아래 식에는 해당이 안되고, 6면 중 제일 큰 면을 제외하고 다 더한값이 답이 된다. (체크 안했더니 90퍼센트쯤에서 계속 틀림) 
			answer = sum - max;
		} else {

			answer = three * 4 + two * (4 * (n - 1) + 4 * (n - 2)) + one * ((n - 2) * (n - 1) * 4 + (n - 2) * (n - 2));
		}
		System.out.println(answer);

	}

}