import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	String s = st.nextToken();
        	
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < s.length(); i++) {
        		sb.append(String.valueOf(s.charAt(i)).repeat(r));
        	}
        	out.append(sb).append('\n');
        }
        System.out.println(out);
    }
}
