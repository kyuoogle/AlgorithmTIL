//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> list;   // 사이클에 포함되는 숫자 저장
    static boolean[] visited;         // DFS 방문 체크
    static int[] num;                 // 입력된 수열

    // 프로그램 시작점
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        // 수열 입력
        num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        // DFS를 이용해 각 숫자에서 사이클 여부 확인
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        // 결과 출력 (오름차순)
        Collections.sort(list);
        System.out.println(list.size());
        for (int v : list) {
            System.out.println(v);
        }
    }

    // start에서 시작해 target으로 다시 돌아오는 사이클이 있는지 DFS 탐색
    public static void dfs(int start, int target) {
        if (!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }

        // 다시 시작점으로 돌아오면 사이클 성립
        if (num[start] == target) {
            list.add(target);
        }
    }
}