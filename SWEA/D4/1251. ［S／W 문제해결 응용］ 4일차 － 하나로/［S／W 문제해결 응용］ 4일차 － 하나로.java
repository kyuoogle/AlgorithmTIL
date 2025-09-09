import java.io.*;
import java.util.*;

public class Solution {
	//MST 문제: Kruskal 알고리즘 이용해보자
	//강의 시간에 작성한 코드를 바탕으로 문제 해결
	//커스터마이징이 필요할듯...?
	static class Edge implements Comparable<Edge> {
		int from, to; //간선의 양 끝 정점의 인덱스
		double cost; // 비용
		
		//간선의 양 끝 정점 인덱스와 비용을 저장
		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		//비용을 오름차순으로 정렬
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	//각 노드의 부모를 저장할 배열
	static protected int[] parent;
	
	//각 정점의 부모를 자기 자신으로 설정
	static public void init(int N) {
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	//대표 찾기
	static public int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}
	
	//두 집합 합치기
	static public boolean union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);
		
		if (root_x != root_y) { //루트가 서로 다르면 다른 집합이므로 합치기 가능
			parent[root_y] = root_x;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 호출 또 하기 귀찮아서 그냥 X Y 나눠서 토큰화할 용도로 두 개 선언
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			
			double[] xCoords = new double[N]; //x좌표 배열 생성
			double[] yCoords = new double[N]; //y좌표 배열 생성
			
			//x y 좌표 정보 읽어오기
			for (int i = 0; i < N; i++) {
				xCoords[i] = Double.parseDouble(stX.nextToken());
			}
			for (int i = 0; i < N; i++) {
				yCoords[i] = Double.parseDouble(stY.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			// 모든 간선을 저장할 배열
			int edgeCount = N * (N - 1) / 2;
			Edge[] edges = new Edge[edgeCount];
			int edgeIndex = 0;
			
			// 모든 간선 생성
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double dx = xCoords[i] - xCoords[j];
					double dy = yCoords[i] - yCoords[j];
					double L_squared = dx * dx + dy * dy;
					double cost = E * L_squared;
					edges[edgeIndex++] = new Edge(i, j, cost);
				}
			}
			
			// 생성된 모든 간선을 비용 기준으로 정렬
			Arrays.sort(edges);
			
			init(N); // UnionFind 초기화(각 정점의 부모를 자기 자신으로)
			
			double minCost = 0; // MST의 총 비용 저장
			int addedEdgeCount = 0; // 현재까지 MST에 추가된 간선 수
			
			
			//Kruskal 알고리즘
			//비용이 작은 간선부터 검사해 서로 다른 집합이면 선택
			for (int i = 0; i < edgeCount; i++) {
				Edge edge = edges[i];
				// 두 정점이 서로 다른 집합이면, 합치고 비용 누적 및 간선 수 증가
				if (union(edge.from, edge.to)) {
					minCost += edge.cost;
					addedEdgeCount++;
				}
				// MST가 완성되면(간선의 수가 N - 1이면) 종료
				if (addedEdgeCount == N - 1) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(minCost));
		}
	}
}