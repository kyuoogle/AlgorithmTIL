import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {

	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	static protected int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드
	static public void init(int N) { // 요소의 갯수가 N개 일 때에 초기화...!
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	// find-set : x가 속해있는 대표자를 반환하는 메서드
	static public int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = findSet(parent[x]);// 재귀호출로 부모를 통해 다시 대표자 탐색 진행
	}

	// union : x와 y가 속해있는 그룹을 통합하는 메서드
	static public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);

		if (root_x != root_y)
			parent[root_x] = root_y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 원소의 갯수 N, 연산의 갯수 M
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 로직 서로소집합을 생성한 후에, 연산에 따라서 처리 후 결과 생성!
			StringBuilder result = new StringBuilder();

			// 서로소 집합을 원소 N개로 초기화
			init(N + 1);

			// 명령어 M개를 읽고, 명령들을 수행하는 과정...!
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (command == 0) { // x, y 를 합하라 (union)
					union(x, y);
				} else if (command == 1) { // x, y가 같은 그룹인가
					int root_x = findSet(x);
					int root_y = findSet(y);

					if (root_x == root_y) {
						result.append("1"); // 두개 그룹이 서로 같다!
					} else {
						result.append("0"); // 다르다
					}
				}
			}

			// 출력
			System.out.println("#" + tc + " " + result.toString());
		}
	}
}