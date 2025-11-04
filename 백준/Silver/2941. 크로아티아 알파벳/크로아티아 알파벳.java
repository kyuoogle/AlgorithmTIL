import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	
    	String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    	
    	for(int i = 0; i < croatia.length; i++) {
    		str = str.replace(croatia[i], "*");
    	}
    	
    	System.out.println(str.length());
    }
}