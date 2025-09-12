import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String[] channelList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        channelList = new String[N];
        for (int i = 0; i < N; i++) {
            channelList[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        // 1) KBS1을 첫 번째로 올리기
        int idx = 0;
        // 화살표를 KBS1에 맞출 때까지 1번 눌러 이동
        while (!channelList[idx].equals("KBS1")) {
            idx++;
            sb.append("1");
        }
        // KBS1이 맨 위로 오도록 4번 눌러 자리를 올림
        while (idx > 0) {
            swap(idx, idx - 1);
            idx--;
            sb.append("4");
        }

        // 2) KBS2를 두 번째로 올리기
        // 현재 화살표는 KBS1(맨 위)에 위치
        // KBS2의 위치를 찾기 위해 아래로 이동
        while (!channelList[idx].equals("KBS2")) {
            idx++;
            sb.append("1");
        }
        // KBS2를 두 번째 자리에 올리기
        while (idx > 1) {
            swap(idx, idx - 1);
            idx--;
            sb.append("4");
        }

        System.out.println(sb.toString());
    }

    // 배열 내 두 채널 위치 교환
    private static void swap(int a, int b) {
        String tmp = channelList[a];
        channelList[a] = channelList[b];
        channelList[b] = tmp;
    }
}
