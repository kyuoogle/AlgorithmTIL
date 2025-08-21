import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] map = new int[1001][1001];
        
        int N = Integer.parseInt(br.readLine());
        
        
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int X = Integer.parseInt(st.nextToken());
        	int Y = Integer.parseInt(st.nextToken());
        	int W = Integer.parseInt(st.nextToken());
        	int H = Integer.parseInt(st.nextToken());
        	
        	for(int j = X; j < X + H; j++) {
        		for(int k = Y; k < Y + W; k++) {
        			if(j >= 0 && j < map.length && k >= 0 && k < map[0].length) {
        				map[j][k] = i;
        			}
        		}
        	}
        }
        for(int i = 1; i <= N; i++) {
        	int cnt = 0;
        	for(int j = 0; j < map.length; j++) {
        		for(int k = 0; k < map.length; k++) {
        			if(map[j][k] == i) cnt++;
        		}
        	}
        	System.out.println(cnt);
        }
    }
}