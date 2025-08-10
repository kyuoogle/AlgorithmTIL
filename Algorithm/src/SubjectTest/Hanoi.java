package SubjectTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hanoi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger cnt = new BigInteger("2");

        //이동 횟수 구하는 알고리즘
        System.out.println(cnt.pow(n).subtract(new BigInteger("1")));

        if (n <= 20) {
            hanoi(n, 1, 3, 2);
        }
    }

    private static void hanoi(int n, int start, int goal, int assist) {
        if (n == 1) {
            System.out.println(start + " " + goal);
            return;
        }
        hanoi(n-1, start, assist, goal); // n - 1개의 원판들 보조기둥으로 이동
        System.out.println(start+" "+goal); // 가장 큰 원판 목표기둥으로 이동
        hanoi(n-1, assist, goal, start); // n -1 개의 보조기둥에있는 원판들 목표로 다시 이동
    }
}
