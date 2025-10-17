import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[][] arr = new boolean[100][100];
        
        int N = Integer.parseInt(br.readLine());
        
        int area = 0;
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	for(int j = x; j < x + 10; j++) {
        		for(int k = y; k < y + 10; k++) {
        			if(!arr[j][k]) {
        				arr[j][k] = true;
        				area++;
        			}
        		}
        	}
        }
        System.out.println(area);
    }
}
