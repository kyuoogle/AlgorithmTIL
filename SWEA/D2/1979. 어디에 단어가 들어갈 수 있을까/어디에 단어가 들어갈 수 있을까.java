import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	// 퍼즐 배열의 크기 N, 단어의 길이 K 입력
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	// 퍼즐 배열 선언
        	int[][] puzzle = new int[N][N];
        	// 퍼즐 정보 입력
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			puzzle[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	int cnt = 0;
        	
        	for(int i = 0; i < N; i++) {
        		int cnt1 = 0;
        		for(int j = 0; j < N; j++) {
        			if(puzzle[i][j] == 1) {
        				cnt1++;
        			} else {
        				if(cnt1 == K) {
        					cnt++;
        				}
        				cnt1 = 0;
        			}
        		}
        		if(cnt1 == K) cnt++;
        	}
        	
        	for(int j = 0; j < N; j++) {
        		int cnt1 = 0;
        		for(int i = 0; i < N; i++) {
        			if(puzzle[i][j] == 1) {
        				cnt1++;
        			} else {
        				if(cnt1 == K) {
        					cnt++;
        				}
        				cnt1 = 0;
        			}
        		}
        		if(cnt1 == K) cnt++;
        	}
        	System.out.println("#" + tc + " " + cnt);
        }
    }
}
