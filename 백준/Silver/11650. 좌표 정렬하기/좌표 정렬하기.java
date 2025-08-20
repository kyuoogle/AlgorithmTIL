import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] xy = new int[N][2];
        
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	xy[i][0] = Integer.parseInt(st.nextToken());
        	xy[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(xy, (e1, e2) -> {
        	if(e1[0] == e2[0]) {
        		return e1[1] - e2[1];
        	} else {
        		return e1[0] - e2[0];
        	}
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
        	sb.append(xy[i][0] + " " + xy[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}