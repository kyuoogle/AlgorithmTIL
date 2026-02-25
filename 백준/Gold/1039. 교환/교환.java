import java.io.*;
import java.util.*;

public class Main {
    static int n = 0;
    static int k = 0;
    static int m = 0;
    static int result = -1;
    static boolean[][] visit = new boolean[1000001][11];
    static Queue<point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String first = st.nextToken();
        q.add(new point(first,0));
        n = Integer.parseInt(first);
        visit[n][0] = true;
        m = first.length();
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(result);

        br.close();
    }

    static void bfs()
    {
        while(!q.isEmpty())
        {
            point cur = q.poll();

            if(cur.num==k) // k번째 변환이 완료되었다면
            {
                if(result<Integer.parseInt(cur.str))
                {
                    result = Integer.parseInt(cur.str); // 최댓값을 찾도록 한다.
                }
                continue;
            }
            else if(cur.num>k) // 순번이 넘어간 경우 바로 return
                return;

            for(int i=0;i<m;i++) 
            {
                for(int j=i+1;j<m;j++) // i번째 숫자와 k번째 숫자를 변환하는 경우
                {
                    char[] arr = cur.str.toCharArray();
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp; // 변환 

                    String next = new String(arr);
                    if(arr[0]!='0'&&!visit[Integer.parseInt(next)][cur.num+1])
                    {
                        visit[Integer.parseInt(next)][cur.num+1] = true;
                        q.add(new point(next, cur.num+1));
                    } // 방문 처리 과정에서 해당 순번을 고려하여 처리해줘야 한다.
                }
            }

        }

    }
}
class point
{
    String str; // 해당 숫자
    int num; // 변환 수행 숫자

    point(String str,int num)
    {
        this.str = str;
        this.num = num;
    }
}