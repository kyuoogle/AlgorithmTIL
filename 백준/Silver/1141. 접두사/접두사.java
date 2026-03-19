import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.sort(Comparator.comparingInt(String::length));

        int answer = N;

        for (int i = 0; i < N; i++) {
            String now = words.get(i);

            for (int j = i + 1; j < N; j++) {
                if (words.get(j).startsWith(now)) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}