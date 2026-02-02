import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static boolean[] prime; // 제곱수로 나누어떨어지는지 확인하는 배열

	public static void main(String[] args) throws IOException {
		// 입력값 처리하는 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 결과값 출력하는 BufferedWriter
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력값 max, min 저장
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int size = (int) (max - min); // 제곱수 나누어떨어지는지 확인하는 범위 계산
		prime = new boolean[size + 1]; // 범위에 맞게 확인 배열 크기 설정!
		isPrime(min, max); // 에라토스테네스의 체를 이용한 탐색 진행!
		int result = 0;
		// 제곱수로 나누어 떨어지지 않는 개수를 구하기
		for (int i = 0; i <= size; i++) {
			if (!prime[i])
				result++;
		}
		bw.write(String.valueOf(result)); // 개수 BufferedWriter 저장
		bw.flush(); // 결과 출력
		bw.close();
		br.close();
	}

	// 에라토스테네스의 체를 이용해 제곱수로 나누어 떨어지는지 탐색하는 함수
	static void isPrime(long min, long max) {
		// Math.sqrt()는 나올 수 있는 최대에 제곱근까지만 탐색하도록 범위 설정!
		for (long i = 2; i <= Math.sqrt(max); i++) {
			long temp = i * i; // 현재 제곱수 계산
			// 시작되는 몫의 최소값 구하기!
			long s = (min % temp == 0 ? min / temp : (min / temp) + 1);
			// 시작되는 몫부터 제곱수를 더해가며 나누어 떨어지는 값들 확인
			for (long j = s; j * temp <= max; j++)
				prime[(int) (j * temp - min)] = true;
		}
	}
}