
import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int num = Integer.parseInt(br.readLine());
        
        int NMAX = 20000;               // 1e9까지 커버 충분
        int[] zip = new int[NMAX + 1];

        for (int i = 1; i <= NMAX; i++) // 1부터 채워서 zip[1]=1
            zip[i] = 1 + 3 * i * (i - 1);

        int floor = 1;
        for (int i = 1; i <= NMAX; i++) {
            if (num <= zip[i]) {        // <= 로 경계 포함
                floor = i;
                break;                  // 찾았으면 즉시 종료
            }
        }
        

        if(num == 1) System.out.println(1);
        else System.out.println(floor);
    }
}
