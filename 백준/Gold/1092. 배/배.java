import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] cranes;
    static int[] boxes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        cranes = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cranes[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine().trim());
        boxes = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) boxes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cranes);
        Arrays.sort(boxes);
        reverse(cranes);
        reverse(boxes);

        // 가장 센 크레인도 가장 무거운 박스를 못 들면 불가능
        if (cranes[0] < boxes[0]) {
            System.out.println(-1);
            return;
        }

        boolean[] moved = new boolean[M];
        int[] pos = new int[N];       // 각 크레인이 다음에 확인할 박스 인덱스
        int remain = M;
        int time = 0;

        while (remain > 0) {
            for (int i = 0; i < N; i++) {
                if (remain == 0) break;

                // i번 크레인은 pos[i]부터 오른쪽으로 보면서 "아직 안 옮긴 박스" 중 들 수 있는 첫 박스를 찾는다.
                while (pos[i] < M) {
                    int idx = pos[i];

                    if (!moved[idx] && cranes[i] >= boxes[idx]) {
                        moved[idx] = true;
                        remain--;
                        pos[i]++;     // 다음 라운드 때는 그 다음부터 보면 됨
                        break;
                    }
                    pos[i]++;         // 못 들거나 이미 옮겼으면 다음 박스로
                }
            }
            time++;
        }

        System.out.println(time);
    }

    static void reverse(int[] arr) {
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }
}