import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int word = 0;
        boolean inWord = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ' && !inWord) {
                inWord = true; // 단어의 시작
                word++;
            } else if (c == ' ') {
                inWord = false; // 단어가 끝남
            }
        }

        System.out.println(word);
    }
}
