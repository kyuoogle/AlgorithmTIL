import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n >= 5) {
            n /= 5;
            count += n;
        }

        System.out.println(count);
    }
}