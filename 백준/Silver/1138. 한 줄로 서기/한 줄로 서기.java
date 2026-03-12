import java.io.*;
import java.util.*;

public class Main {

    static final int BLANK = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        Arrays.fill(line, BLANK);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int height = 1; height <= N; height++) {
            int leftCount = Integer.parseInt(st.nextToken());
            int blankCount = 0;

            for (int i = 0; i < N; i++) {
                if (line[i] != BLANK) continue;

                if (blankCount == leftCount) {
                    line[i] = height;
                    break;
                }

                blankCount++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(line[i]).append(' ');
        }

        System.out.print(sb);
    }
}