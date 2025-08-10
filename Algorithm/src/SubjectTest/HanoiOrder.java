package SubjectTest;

import java.io.*;

public class HanoiOrder {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //원판의 개수

        sb.append((int) (Math.pow(2, N)-1)).append("\n");
        hanoi(N, 1, 2, 3);

        br.close();
        System.out.println(sb);
    }

    //hanoi 솔루션 메소드
    // 파라미터 : 원판 개수(N), 시작 공간(start), 임시 공간(tmp), 목적지(to)
    static void hanoi(int N, int start, int tmp, int to){
        //이동할 원판의 개수가 1개면 start to 출력하면됨(차피 1개니까 로직 처리X)
        if(N == 1){
            sb.append(start + " " + to + "\n");
            return;
        }

        /*
         hanoi(N, start, tmp, to);

         원판이 3이라고 가정하면,
         (1)-1 hanoi(2, 1, 3, 2);
            (1)-2 hanoi(1, 1, 2, 3);
               ** if N=1 print("1 3")
            (2)-2 ** print("1 2");
            (3)-2 hanoi(1, 3, 1, 2);
                if N = 1 ** print("3 2");
         (2)-1 ** print("1 3");
         (3)-1 hanoi(2, 2, 1, 3);
            (1)-2 hanoi(1, 2, 3, 1);
                if N = 1 ** print("2 1");
            (2)-2 ** print("2 3");
            (3)-2 hanoi(1, 1, 2, 3);
                if N = 1 ** print("1 3");
        */

        // start -> to로 옮긴다고 가정하면
        //(1) N-1까지는 tmp로 옮긴다.(start에 있는 요소들)
        hanoi(N-1, start, to, tmp);

        //(2) 1개(숫자 N자체; 가장 큰 숫자)를 start -> to로 이동한다.
        sb.append(start+" " + to + "\n");

        //(3) N-1을 tmp -> to로 옮긴다.(중간에 있는 것 N-1까지 옮긴 것을 to로)
        hanoi(N-1, tmp, start, to);
    }

}