import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int jm = Integer.parseInt(st.nextToken());
        int hs = Integer.parseInt(st.nextToken());

        int count = 1;

        while (true){
            jm = jm/2+jm%2;
            hs = hs/2+hs%2;

            if(hs == jm) break;
            count++;
        }
        if(hs == jm) System.out.println(count);
    }
}