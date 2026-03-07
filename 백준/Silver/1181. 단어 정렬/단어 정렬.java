import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        List<String> list = new ArrayList<>(words);

        list.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo));

        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.print(sb);
    }
}