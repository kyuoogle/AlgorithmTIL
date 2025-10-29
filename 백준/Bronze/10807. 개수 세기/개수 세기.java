import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N < 1 || N > 100) {
			return;
		}

		int[] array = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {

			array[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i : array) {
			if (i == v) {
				cnt++;
			}
		}
		
		br.close();
		
		System.out.println(cnt);

	}
}