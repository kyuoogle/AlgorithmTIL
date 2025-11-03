import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 1번 개 활동시간
        int B = Integer.parseInt(st.nextToken()); // 1번 개 휴식시간
        int C = Integer.parseInt(st.nextToken()); // 2번 개 활동시간
        int D = Integer.parseInt(st.nextToken()); // 2번 개 휴식시간

        st = new StringTokenizer(br.readLine());
        int[] times = new int[3]; // 차례대로 우체부, 우유배달원, 신문배달원
        for(int i = 0; i < 3; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++) {
            int t = times[i];
            int dogs = 0;

            int dog1 = t % (A + B);
            if(dog1 >= 1 && dog1 <= A) dogs++;

            int dog2 = t % (C + D);
            if(dog2 >= 1 && dog2 <= C) dogs++;

            System.out.println(dogs);
        }
    }
}
