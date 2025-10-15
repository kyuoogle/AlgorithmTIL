import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dice1 = Integer.parseInt(st.nextToken());
        int dice2 = Integer.parseInt(st.nextToken());
        int dice3 = Integer.parseInt(st.nextToken());

        int money = 0;

        if (dice1 == dice2 && dice2 == dice3) {                  // 세 개 같음
            money = 10000 + dice1 * 1000;
        } else if (dice1 == dice2 || dice1 == dice3) {           // dice1과 같은 게 하나
            money = 1000 + dice1 * 100;
        } else if (dice2 == dice3) {                             // dice2와 dice3이 같음
            money = 1000 + dice2 * 100;
        } else {                                                 // 모두 다름
            int big = Math.max(dice1, Math.max(dice2, dice3));
            money = big * 100;
        }

        System.out.println(money);
    }
}
