class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터는 코드 번호, 제조일, 최대수량, 현재 수량으로 구성
        // 데이터 추출 기준 ext
        // 정보의 기준 값 val_ext
        // 정보 정렬 기준 sort_by
        // 정렬 기준 값보다 작은 데이터만 뽑아서 sort_by로 오름차순 정렬해서 return
        int extIdx = 0;
        int sortIdx = 0;
        
        // 각 값들의 인덱스를 알기 위해 작업
        String[] names = {"code", "date", "maximum", "remain"};
        
        for(int i = 0; i < 4; i++) {
            if(ext.equals(names[i])) {
                extIdx = i;
            }
            if(sort_by.equals(names[i])) {
                sortIdx = i;
            }
        }
        // 조건에 맞는 데이터 개수 세기
        int cnt = 0;
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][extIdx] < val_ext) {
                cnt++;
            }
        }
        
        // 조건에 맞는 데이터만 새 배열에 저장
        int[][] ans = new int[cnt][4];
        int idx = 0;
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][extIdx] < val_ext) {
                for(int j = 0; j < 4; j++) {
                    ans[idx][j] = data[i][j];
                }
                idx++;
            }
        }
        
        // 오름차순 정렬
        for(int i = 0; i < cnt - 1; i++) {
            for(int j = i + 1; j < cnt; j++) {
                if (ans[i][sortIdx] > ans[j][sortIdx]){
                    int[] tmp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = tmp;
                }
            }
        }
        return ans;
    }
}