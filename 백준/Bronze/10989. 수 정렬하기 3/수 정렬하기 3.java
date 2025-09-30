import java.io.*;

public class Main {
    private static final int MAX = 10000;
    private static final InputStream in = System.in;
    private static final byte[] buffer = new byte[1 << 16];
    private static int ptr = 0, len = 0;

    // 빠른 입력: 공백/개행을 건너뛰고 양의 정수 읽기 (10989는 음수/0 없음)
    private static int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    private static int nextInt() throws IOException {
        int c, n = 0;
        // 공백/개행 스킵
        while ((c = read()) <= 32) {
            if (c == -1) return -1;
        }
        // 숫자 읽기
        do {
            n = n * 10 + (c - '0');
            c = read();
        } while (c > 32);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int[] cnt = new int[MAX + 1]; // 1..10000

        for (int i = 0; i < N; i++) {
            cnt[nextInt()]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int v = 1; v <= MAX; v++) {
            int c = cnt[v];
            while (c-- > 0) {
                bw.write(Integer.toString(v));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
