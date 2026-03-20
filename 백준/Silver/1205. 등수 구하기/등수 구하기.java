import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] score = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }
        }

        int rank = 1;
        int same = 0;

        for (int i = 0; i < N; i++) {
            if (score[i] > newScore) rank++;
            else if (score[i] == newScore) same++;
            else break;
        }

        if (N == P && score[N - 1] >= newScore) {
            System.out.println(-1);
            return;
        }

        System.out.println(rank);
    }
}