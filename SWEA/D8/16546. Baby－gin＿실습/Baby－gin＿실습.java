import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 수 T
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	//카드 숫자 저장
        	String card = br.readLine(); //0도 가능임
        	
        	//0~9까지의 숫자 중 6개에서 각각 어떤 수들이 몇 개 있는지 확인을 위해
        	int[] cnt = new int[10];
        	
        	//숫자 개수 세기
        	for(int i = 0; i < 6; i++) {
        		cnt[card.charAt(i) - '0']++;
        	}
        	/*
        	 * Baby Gin 판단: 입력 받은 카드가 run 과 triplet 로만 구성된 경우
        	 * 6장의 카드를 입력 받고, 임의로 재배열 해 3 + 3 두 그룹으로 만듦
        	 * 이때 각각이 run(연속 3장) 또는 triplet(같은 숫자 3장)이면 baby gin
        	 * 입력 순서에 의존하니까 반례가 자꾸 생겨서 카운팅 배열로 0~9의 각 개수를 세고,
        	 * 첫 번째 그룹으로 가능한 모든 triplet, run을 빼보고
        	 * 남은 3장이 triplet인지, run인지 확인
        	 */
        	boolean isOk = false; //baby gin인 경우가 하나라도 있으면, 그 즉시 true를 반환하면 끝
        	//첫 번째 그룹을 triplet으로 선택
        	for (int i = 0; i <= 9 && !isOk; i++) {
                if (cnt[i] >= 3) {
                    // 첫 그룹으로 i의 triplet 사용
                    cnt[i] -= 3;
                    
                    //남은 3장은 무조건 triplet 또는 run 두 형태만 가능
                    //두 번째 그룹 triplet 체크
                    boolean secondTriplet = false;
                    for (int d = 0; d <= 9; d++) {
                        if (cnt[d] == 3) { secondTriplet = true; break; }
                    }

                    //두 번째 그룹이 run인지(연속된 세 수가 각각 1장씩)
                    boolean secondRun = false;
                    for (int d = 0; d <= 7 && !secondRun; d++) {
                        if (cnt[d] == 1 && cnt[d + 1] == 1 && cnt[d + 2] == 1) {
                            secondRun = true;
                        }
                    }

                    if (secondTriplet || secondRun) isOk = true;

                    // 시도에 사용한 카드 복구
                    cnt[i] += 3;
                }
            }
            
        	//첫 번째 그룹을 run으로 선택
        	//연속된 세 수가 각각 1장 이상일 때 사용
        	for (int i = 0; i <= 7 && !isOk; i++) {
                if (cnt[i] >= 1 && cnt[i + 1] >= 1 && cnt[i + 2] >= 1) {
                    // 첫 그룹으로 run(i, i+1, i+2) 사용
                    cnt[i]--; cnt[i + 1]--; cnt[i + 2]--;

                    //남은 3장이 두 번째 그룹이어야 함
                    //위와 마찬가지로 두 번째 그룹이 triplet인지 체크
                    boolean secondTriplet = false;
                    for (int d = 0; d <= 9; d++) {
                        if (cnt[d] == 3) { secondTriplet = true; break; }
                    }
                    //두 번째 그룹이 run인지 체크
                    boolean secondRun = false;
                    for (int d = 0; d <= 7 && !secondRun; d++) {
                        if (cnt[d] == 1 && cnt[d + 1] == 1 && cnt[d + 2] == 1) {
                            secondRun = true;
                        }
                    }

                    if (secondTriplet || secondRun) isOk = true;

                    // 복구
                    cnt[i]++; cnt[i + 1]++; cnt[i + 2]++;
                }
            }

            System.out.println("#" + tc + " " + (isOk ? "true" : "false"));
        }
    }
}