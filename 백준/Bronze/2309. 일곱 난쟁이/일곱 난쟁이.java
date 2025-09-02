
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] seven = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            seven[i] = Integer.parseInt(br.readLine().trim());
            sum += seven[i];
        }

        int target = sum - 100;
        int fk1 = -1, fk2 = -1;

        outer:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {          // i 다음부터, 9 미만
                if (seven[i] + seven[j] == target) {
                    fk1 = i;                            // 찾은 인덱스를 저장
                    fk2 = j;
                    break outer;
                }
            }
        }


        int[] real = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (i == fk1 || i == fk2) continue;        // 가짜 둘 제외
            real[idx++] = seven[i];
        }

        Arrays.sort(real);

        for (int i = 0; i < 7; i++) {
            System.out.println(real[i]);
        }
    }
}
