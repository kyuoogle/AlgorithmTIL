import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int x = b % 10;
        int y = (b / 10) % 10;
        int z = b / 100;

        System.out.println(a * x);
        System.out.println(a * y);
        System.out.println(a * z);
        System.out.println(a * b);
    }
}
