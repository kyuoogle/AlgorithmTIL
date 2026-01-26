import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		System.out.println(solve(N, M, arr));
	}

	public static int solve(int N, int M, int[][] arr) {
		int result = 0;
		int length = 1;
		while (true) {
			if (length > N || length > M) {
				break;
			}

			for (int i = 0; i < N; i++) {
				if (i + length > N - 1) {
					break;
				}

				for (int j = 0; j < M; j++) {
					if (j + length > M - 1) {
						break;
					}

					int one = arr[i][j];
					int two = arr[i + length][j];
					int three = arr[i][j + length];
					int four = arr[i + length][j + length];

					if (one == two && one == three && one == four) {
						result = length;
					}
				}
			}
			length++;
		}
		if (result == 0) {
			return 1;
		}
		return (result + 1) * (result + 1);
	}
}