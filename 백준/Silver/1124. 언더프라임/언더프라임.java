import java.io.*;
import java.util.*;

public class Main {

    static int A, B;
    static boolean[] isComposite;
    static int[] spf; // smallest prime factor

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        isComposite = new boolean[B + 1];
        spf = new int[B + 1];

        sieve();

        int count = 0;
        for (int num = A; num <= B; num++) {
            int factorCount = countPrimeFactors(num);
            if (factorCount >= 2 && !isComposite[factorCount]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void sieve() {
        if (B >= 1) isComposite[1] = true;

        for (int i = 2; i <= B; i++) {
            if (!isComposite[i]) {
                spf[i] = i;
                for (int j = i + i; j <= B; j += i) {
                    if (!isComposite[j]) {
                        isComposite[j] = true;
                    }
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static int countPrimeFactors(int num) {
        int count = 0;
        while (num > 1) {
            count++;
            num /= spf[num];
        }
        return count;
    }
}