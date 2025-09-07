import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] A = new int[1000000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A.length; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        System.out.println(A[500000]);
    }
}
