import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '<') {
                sb.append(word.reverse());
                word.setLength(0);
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            }
            else {
                if(c == ' ') {
                    sb.append(word.reverse());
                    word.setLength(0);
                    sb.append(' ');
                } else {
                    word.append(c);
                }
            }
        }
        sb.append(word.reverse());
        System.out.println(sb);
    }
}
