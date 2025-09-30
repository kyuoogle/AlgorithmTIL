import java.io.*;
import java.util.*;


public class Main {
	
	static final int INF = 1_000_000_000; // 충분히 큰 값
	static int N, M; // N: 도시의 수, M: 버스의 수
	static int[][] dist;
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        dist = new int[N + 1][N + 1];
        
        // 초기화
        for(int i = 1; i <= N; i++) {
        	Arrays.fill(dist[i], INF);
        	dist[i][i] = 0;
        }
        
        // 간선 정보 입력(중복 간선 -> 최소 비용만을)
        for(int i = 0; i < M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(c < dist[a][b])
        		dist[a][b] = c;
        }
        
        floyedWarshall();
        
        // 출력 (경로 없으면 0)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
    
    public static void floyedWarshall() {
    	for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= N; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}