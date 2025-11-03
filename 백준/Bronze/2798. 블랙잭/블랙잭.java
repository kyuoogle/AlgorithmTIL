import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N: 바닥에 깔리는 카드 수, M: 도달해야 할 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 카드 정보 입력
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 메인 로직
        int best = 0;

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > M) continue;

                    if(sum > best) best = sum;

                    if(best == M) {
                        System.out.println(best);
                        return ;
                    }
                }
            }
        }
        System.out.println(best);
    }
}