import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 기둥 개수 입력
        int N = Integer.parseInt(br.readLine());
        
        int[] H = new int[1001];
        
        int minX = 1001;
        int maxX = 0;
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	
        	if(h > H[x]) H[x] = h;
        	
        	if(x < minX) minX = x;
        	if(x > maxX) maxX = x;
        }
        
        int maxH = 0;
        for(int x = minX; x <= maxX; x++) {
        	if(H[x] > maxH) maxH = H[x];
        }
        
        int Lmax = minX, Rmax = maxX;
        for (int x = minX; x <= maxX; x++) {
            if (H[x] == maxH) { Lmax = x; break; }
        }
        for (int x = maxX; x >= minX; x--) {
            if (H[x] == maxH) { Rmax = x; break; }
        }
        
        int area = 0;
        
        int left = 0;
        for(int x = minX; x < Lmax; x++) {
        	if(H[x] > left) left = H[x];
        	area += left;
        }
        
        area += maxH * (Rmax - Lmax + 1);
        
        int right = 0;
        for(int x = maxX; x > Rmax; x--) {
        	if(H[x] > right) right = H[x];
        	area += right;
        }
        System.out.println(area);
    }
}
