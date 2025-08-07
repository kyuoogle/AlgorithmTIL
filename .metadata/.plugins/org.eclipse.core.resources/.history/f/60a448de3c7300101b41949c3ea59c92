import java.util.Scanner;

class SWEA_4835 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int T = sc.nextInt(); 

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 전체
            int M = sc.nextInt(); // 구간

            int[] nums = new int[N]; 
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt(); 
            }

            int maxSum = 0; // 초기값 설정
            int minSum = 2147483647; // int형의 최대값으로 초기값 설정

            // 길이 M인 연속 구간을 순회하며 합을 구함
            for (int i = 0; i <= N - M; i++) {
                int current_sum = 0;

                // i부터 i+M까지 M개의 연속된 값의 합 계산
                for (int j = i; j < i + M; j++) {
                    current_sum += nums[j];
                }

                // 최대값 갱신
                if (current_sum > maxSum) {
                    maxSum = current_sum;
                }

                // 최소값 갱신
                if (current_sum < minSum) {
                    minSum = current_sum;
                }
            }

            // 최대 구간 합 - 최소 구간 합 출력
            System.out.println("#" + t + " " + (maxSum - minSum));
        }
    }
}

