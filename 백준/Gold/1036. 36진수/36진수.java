import java.io.*;
import java.util.*;

public class Main {
    //36진수의 증가하는 수치 저장하는 클래스
    static class Info implements Comparable<Info>{
        int idx;
        int[] vals;	//각 자릿수 증가하는 수치

        public Info(int idx, int[] vals){
            this.idx = idx;
            this.vals = vals;
        }

        //각 자릿수 증가하는 수치 기준 내림차순 정렬
        @Override
        public int compareTo(Info o) {
            for(int i=54;i>=0;i--){
                if(this.vals[i] > o.vals[i]){
                    return -1;
                }else if(this.vals[i] < o.vals[i]){
                    return 1;
                }
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        //36진수 각 자릿수 증가하는 수치 초기화
        List<Info> infos = new ArrayList<>();
        for(int i=0;i<36;i++){
            infos.add(new Info(i, new int[55]));
        }

        //문자열 입락 받은 후, 각 36진수 증가하는 수치 계산
        for(int i=0;i<N;i++) {
            words[i] = br.readLine().trim();
            int len = words[i].length();
            for(int j=0;j<len;j++){
                char c = words[i].charAt(j);
                //'A' ~ 'Z'일 때
                if(c >= 'A'){
                    infos.get(c-'A'+10).vals[len - j - 1] += 'Z' - c;
                }else{		// 0 ~ 9일 때
                    int temp = Character.getNumericValue(c);
                    infos.get(temp).vals[len - j - 1] += 35 - temp;
                }
            }
        }

        //증가하는 수치가 36이상일 때 올림 적용
        for(Info info : infos){
            for(int i=0;i<55;i++){
                if(info.vals[i] >= 36){
                    //올림 적용
                    info.vals[i+1] += info.vals[i] / 36;
                    //남은 값 계산
                    info.vals[i] %= 36;
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        //각 자릿수 증가하는 수 기준 내림차순 정렬 진행
        Collections.sort(infos);
        //변경해야 하는 값 설정
        Set<Integer> change = new HashSet<>();
        //순서대로 K개 'Z'으로 변경할 36진수 선택
        for(int i=0;i<K;i++){
            change.add(infos.get(i).idx);
        }

        //변경해야 하는 K개 36진수 'Z'으로 변경
        for(int changeVal : change){
            String c;
            if(changeVal >= 10){
                c = String.valueOf((char)(changeVal - 10 + 'A'));
            }else{
                c = String.valueOf((char)(changeVal + '0'));
            }
            for(int i=0;i<N;i++){
                words[i] = words[i].replaceAll(c, "Z");
            }
        }

        int[] result = new int[55];
        //변경한 값에 대해서 36진수의 합 구하기.
        for(int i=0;i<N;i++){
            int len = words[i].length();
            for(int j=0;j<len;j++){
                int temp;
                if(words[i].charAt(j) >= 'A'){
                    temp = words[i].charAt(j) - 'A' + 10;
                }else{
                    temp = Character.getNumericValue(words[i].charAt(j));
                }
                result[len - j - 1] += temp;
            }
        }

        //각 자릿수에 대한 올림 진행
        for(int i=0;i<55;i++){
            if(result[i] >= 36){
                result[i+1] += result[i] / 36;
                result[i] %= 36;
            }
        }
        boolean flag = false;
        //각 자릿수에 맞는 값들을 36진수 형태로 변경
        for(int i=54;i>=0;i--){
            if(result[i] == 0 && !flag){
                continue;
            }
            flag = true;
            if(result[i] >= 10){
                bw.write(String.valueOf((char)(result[i] - 10 + 'A')));
            }else{
                bw.write(String.valueOf(result[i]));
            }
        }
        //만약 결과가 0일 때
        if(!flag){
            bw.write("0");
        }
        bw.flush();	//결과 출력
        bw.close();
        br.close();
    }
}