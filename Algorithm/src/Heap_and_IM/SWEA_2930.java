package Heap_and_IM;

import java.io.*;
import java.util.*;

public class SWEA_2930 {
	
	static int heap[];
	static int size;
	static StringBuilder sb;
	
	// 삽입 연산 — 스왑 방식
	public static void add(int n) {
	    int idx = ++size; 
	    heap[idx] = n;
	
	    while (idx > 1) { // root까지
	        int p = idx / 2;                // 부모 인덱스
	        if (heap[p] < heap[idx]) {      // 부모보다 자식(=현재)이 크면 스왑
	            int tmp = heap[idx];
	            heap[idx] = heap[p];
	            heap[p] = tmp;
	            idx = p;                    // 위로 한 레벨 이동
	        } else break;
	    }
	    heap[idx] = n; // (초기값이 n이라 실질 변화는 없지만, 기존 라인 유지)
	}

	
	public static void remove() {
	    if (size < 1) { // 힙에 원소가 없을 때
	        sb.append("-1 ");
	        return;
	    }

	    sb.append(heap[1]).append(" "); // root 출력
	    int target = heap[size]; // 마지막 원소 저장
	    size--; // 크기 줄이기

	    int idx = 1; // root부터 비교
	    heap[idx] = target; // 스왑 방식으로 내릴 것이므로 먼저 루트에 배치

	    // 왼쪽 자식이 있는 경우 계속 내려간다
	    while (idx * 2 <= size) { 
	        int left = idx * 2;
	        int right = left + 1;

	        int biggerIdx = left;
	        if (right <= size && heap[right] > heap[left]) {
	            biggerIdx = right;
	        }

	        // 현재 노드가 더 큰 자식보다 작으면 스왑하면서 내려감
	        if (heap[idx] < heap[biggerIdx]) {
	            int tmp = heap[idx];
	            heap[idx] = heap[biggerIdx];
	            heap[biggerIdx] = tmp;
	            idx = biggerIdx;
	        } else {
	            break;
	        }
	    }
	    // (스왑 방식이므로 여기서 heap[idx] = target; 필요 없음 — 기존 라인은 제거)
	}

	
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        //테스트케이스 입력
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	//연산 개수 읽기
            int N = Integer.parseInt(br.readLine());
            
            heap = new int[N + 1]; // 힙 배열 초기화
            size = 0; //사이즈 = 힙 원소 개수, 개수도 초기화
            sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                //1은 삽입, 2는 삭제
                int cmd = Integer.parseInt(st.nextToken());
                
                if (cmd == 1) {
                    add(Integer.parseInt(st.nextToken()));
                    
                } else if (cmd == 2) {
                    remove();
                }
            }

            result.append("#").append(t).append(" ").append(sb).append("\n");
        }
        System.out.print(result);
    }
}
