import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int up = 1;
    	int down = 1;    	
    	int maxL = 1;
    	for(int i = 1; i < N; i++) {
    		if(arr[i] >= arr[i - 1]) {
    			up++;
    		} else {
    			up = 1;
    		}
    		
    		if(arr[i] <= arr[i - 1]) {
    			down++;
    		} else {
    			down = 1;
    		}
    		maxL = Math.max(maxL, Math.max(up, down));
    	}
    	System.out.println(maxL);
    }
}