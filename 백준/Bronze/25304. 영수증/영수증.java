import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] price = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int thing = Integer.parseInt(st.nextToken());
            int pr = Integer.parseInt(st.nextToken());

            price[i] = thing * pr;
        }

        int ppr = 0;
        for(int i = 0; i < N; i++) {
            ppr += price[i];
        }

        if(total == ppr) System.out.println("Yes");
        else System.out.println("No");

    }
}
