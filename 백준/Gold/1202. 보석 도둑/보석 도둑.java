import java.io.*;
import java.util.*;

public class Main {
	static class Jewely {
		int w, v;
		Jewely(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewely[] jewelys = new Jewely[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int m = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	jewelys[i] = new Jewely(m, v);
        }
        
        int[] bags = new int[K];
        
        for(int i = 0; i < K; i++)
        	bags[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(jewelys, Comparator.comparingInt(o -> o.w));
        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long ans = 0L;
        int idx = 0; // 아직 처리하지 않은 보석 인덱스

        for (int cap : bags) {
            // 이 가방(cap)으로 담을 수 있는 모든 보석을 힙에 추가
            while (idx < N && jewelys[idx].w <= cap) {
                pq.offer(jewelys[idx].v);
                idx++;
            }
            // 담을 수 있는 보석 중 가장 비싼 것 하나를 담는다
            if (!pq.isEmpty()) ans += pq.poll();
        }

        System.out.println(ans);
    }
}