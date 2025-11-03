import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for (int a = 1; a * a <= n; a++) {
            int maxB = n / a;        // a를 고정했을 때 가능한 b의 최댓값
            cnt += (maxB - a + 1); // b는 a부터 maxB까지
        }

        System.out.println(cnt);
    }
}
