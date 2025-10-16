import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for(int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	
        	int idx = c - 'a';
        	
        	if(arr[idx] == -1) {
        		arr[idx] = i;
        	}
        }
        for(int i = 0; i < 26; i++)
        	System.out.print(arr[i] + " ");
    }
}
