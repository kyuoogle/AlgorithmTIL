import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    static void hanoi(int TopNum, int x, int y)
    {
        if (TopNum > 1) hanoi(TopNum - 1, x, 6 - x - y);
        sb.append(x + " " + y ).append("\n");
        if (TopNum > 1) hanoi(TopNum - 1, 6 - x - y, y);
    }
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	System.out.println((int)Math.pow(2, n) - 1);
    	hanoi(n, 1, 3);
    	sb.toString();
    	System.out.println(sb);
    }
}