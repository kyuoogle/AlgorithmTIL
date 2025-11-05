import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] nums = new int[N + 1][N + 1];
        int[][] prefix = new int[N + 1][N + 1];
        
        for(int i = 1; i < N +1; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j < N+1; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        		prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1]
                        - prefix[i - 1][j - 1] + nums[i][j];
        	}
        }
        
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = prefix[x2][y2]
                    - prefix[x1 - 1][y2]
                    - prefix[x2][y1 - 1]
                    + prefix[x1 - 1][y1 - 1];

            System.out.println(sum);
        }
    }
}
