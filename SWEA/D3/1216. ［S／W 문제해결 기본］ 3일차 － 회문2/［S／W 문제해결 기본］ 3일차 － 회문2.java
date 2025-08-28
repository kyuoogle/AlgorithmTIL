import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for(int tc = 1; tc <= 10; tc++) {
    		int tcNO = Integer.parseInt(br.readLine());
    		//100 x 100 배열 선언
            char[][] palindrome = new char[100][100];
            //배열에 값 입력
            for(int i = 0; i < 100; i++) {
            	String str = br.readLine();
            	for(int j = 0; j < 100; j++) {
            		palindrome[i][j] = str.charAt(j);
            	}
            }
            //최장 길이 회문 저장을 위한 변수 선언
            int maxPalindrome = 1;
            
            OUTER:
            for (int L = 100; L >= 1; L--) {
               	// 가로 탐색
               	for (int r = 0; r < 100; r++) {
               		for (int s = 0; s + L <= 100; s++) {
               			int left = s, right = s + L - 1;
               			boolean ok = true;
               			while (left < right) {
               				if (palindrome[r][left] != palindrome[r][right]) {
               					ok = false;
               					break;
               				}
               				left++;
               				right--;
               			}                			
               			if (ok) {
                			maxPalindrome = L;
                			break OUTER;
               			}
               		}
               	}
               	//세로 탐색
               	for(int c = 0; c < 100; c++) {
               		for(int s = 0; s + L <= 100; s++) {
               			int up = s, down = s + L - 1;
               			boolean ok = true;
               			while(up < down) {
               				if(palindrome[up][c] != palindrome[down][c]) {
               					ok = false;
               					break;
               				}
               				up++; 
               				down--;
               			}
               			if(ok) {
               				maxPalindrome = L;
               				break OUTER;
               			}
               		}
               	}
            }
            sb.append("#").append(tcNO).append(" ").append(maxPalindrome).append('\n');
    	}
    	System.out.print(sb);
    }
}
