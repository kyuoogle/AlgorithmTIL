import java.util.*;
import java.io.*;

public class Main {

    static int F, S, G; // 가장 높은 층, 스타트 링크 위치, 현재 위치
    static int U, D; // 위로 이동할 층수, 아래로 내려갈 층수
    static boolean[] visited;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        visited = new boolean[F  + 1];
        dist = new int[F + 1];
        
        if(S == G) {
        	System.out.println(0);
        	return;
        }
        int ans = bfs(S);
        
        if(ans == -1) {
        	System.out.println("use the stairs");
        }
        else System.out.println(ans);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] =  true;
        dist[start] = 0;
        
        while(!q.isEmpty()) {
        	int curr = q.poll();
        	
        	if(curr == G) return dist[curr];
        	
        	int up = curr + U;
        	if(U > 0 && up <= F && !visited[up]) {
        		visited[up] = true;
        		dist[up] = dist[curr] + 1;
        		q.add(up);
        	}
        	
        	int down = curr - D;
        	if(D > 0 && down >= 1 && !visited[down]) {
        		visited[down] = true;
        		dist[down] = dist[curr] + 1;
        		q.add(down);
        	}
        }
        
        return -1;
    }
}
