import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            char first = str.charAt(0);                   // 첫 글자
            char last = str.charAt(str.length() - 1);     // 마지막 글자

            System.out.println("" + first + last);
        }
    }
}
