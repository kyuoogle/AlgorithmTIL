import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력
		String str = br.readLine();
		// 문자 카운팅 용 배열: 알파벳은 총 26개
		int[] cnt = new int[26];
		
		//문자 개수 카운팅
		for(int i = 0; i < str.length(); i++) {
			if('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				cnt[str.charAt(i) - 97]++;
			} else {
				cnt[str.charAt(i) - 65]++;
			}
		}
		int max = -1;
		char ch = '?';
		for(int i = 0; i < 26; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				ch = (char) (i + 65);
			} 
			else if(cnt[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}
}