import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 문제에서 열 행 순으로 입력 받음
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 좌석 번호
		int K = Integer.parseInt(br.readLine());
		
		if(K > C * R) {
			System.out.println(0);
			return;
		}
		
		int[][] seat = new int[R][C];
		// 상 우 하 좌 순서로 델타 선언
		int[] dx = {-1, 0, 1, 0}; 
		int[] dy = {0, 1, 0, -1};
		
		// 시작점이 왼쪽 아래
		int x = R - 1;
		int y = 0;
		int dir = 0; // 0: 상, 1: 우, 2: 하, 3: 좌
		
		for(int i = 1; i <= K; i++) {
			seat[x][y] = i;
			
			if(i == K) {
				int  X = y + 1; // 열 
				int Y = R - x; // 행
				System.out.println(X + " " + Y);
				break;
			}
			//다음 칸 계산
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			//방향 전환: 범위 밖이거나 이미 찬 경우
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || seat[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
		}
	}
}
