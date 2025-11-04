import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	boolean[][] map = new boolean[101][101];
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		for(int r = x; r < x + 10; r++) {
    			for(int c = y; c < y + 10; c++) {
    				map[r][c] = true;
    			}
    		}
    	}
    	int cnt = 0;
    	
    	for(int i = 0; i <= 100; i++) {
    		for(int j = 0; j <= 100; j++) {
    			if(map[i][j]) {
    				for(int d = 0; d < 4; d++) {
    					int nx = i + dx[d], ny = j + dy[d];
    					if(nx < 0 || ny < 0 || nx > 100 || ny > 100 || !map[nx][ny]) {
    						cnt++;
    					}
    				}
    			}
    		}
    	}
    	System.out.println(cnt);
    }
}