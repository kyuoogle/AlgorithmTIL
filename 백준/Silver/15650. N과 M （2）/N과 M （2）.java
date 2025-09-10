import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        
        // 1부터 시작
        dfs(N, M, 0, 1);
        
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth, int start) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 항상 start부터 시작
        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            // 다음 재귀 호출 시, 현재 숫자(i)보다 큰 숫자만 선택하도록 함
            dfs(N, M, depth + 1, i + 1);
        }
    }
}