import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int sum = 64;
        int stick = 64;
        int cnt = 1;

        while (sum > X) {
            stick /= 2;                 // 매번 반으로 자름
            if (sum - stick >= X) {     // 한 조각 버려도 되면 버림
                sum -= stick;
            } else {                    // 못 버리면 조각 수만 증가
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}