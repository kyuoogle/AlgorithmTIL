import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {

	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	static protected int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드
	static public void init(int N) { // 요소의 갯수가 N개 일 때에 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	// find-set : x가 속해있는 대표자를 반환하는 메서드 = 경로 압축
	static public int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = findSet(parent[x]);
	}

	// union : x와 y가 속해있는 그룹을 통합하는 메서드
	static public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);

		if (root_x != root_y)
			parent[root_y] = root_x; // root_y를 root_x의 자식으로 편입
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
			
			// 서로소 집합을 원소 N개로 초기화 (사람 번호 1부터 N까지 사용)
			init(N + 1);

			// M개의 관계 정보를 읽고 union 연산 수행
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}

			// 무리의 개수 계산
			int groupCount = 0;
			for (int i = 1; i <= N; i++) {
				// 각 원소의 대표자를 찾아, 대표자 배열의 인덱스와 값이 같은 경우(자기 자신이 대표자인 경우) 카운트
				if (parent[i] == i) {
					groupCount++;
				}
			}

			// 출력
			System.out.println("#" + tc + " " + groupCount);
		}
	}
}