import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	int len = str.length();
    	
    	int R = 0, C = 0;
    	for(int r = 1; r <= len; r++) {
    		if(len % r == 0) {
    			int c = len / r;
    			if(r <= c) {
    				R = r;
    				C = c;
    			}
    		}
    	}
    	char[][] arr = new char[R][C];
    	int idx = 0;
    	for(int c = 0; c < C; c++) {
    		for(int r = 0; r < R; r++) {
    			arr[r][c] = str.charAt(idx++);
    		}
    	}
    	for(int r = 0; r < R; r++) {
    		for(int c = 0; c < C; c++) {
    			System.out.print(arr[r][c]);
    		}
    	}
    }
}