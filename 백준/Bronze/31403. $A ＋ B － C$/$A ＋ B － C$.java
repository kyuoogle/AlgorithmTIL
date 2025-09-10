import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        // 첫 번째 줄 출력: A, B, C를 수로 생각했을 때
        System.out.println(A + B - C);

        // 두 번째 줄 출력: A, B, C를 문자열로 생각했을 때
        // String.valueOf()를 사용하여 숫자를 문자열로 명시적 변환
        String strA = String.valueOf(A);
        String strB = String.valueOf(B);
        String strC = String.valueOf(C);

        // JavaScript와 달리 Java의 '+'는 문자열 결합을, '-'는 숫자 연산만 지원합니다.
        // 따라서 '10' + '20' - '5' 와 같은 형태의 연산은 Java에서 직접 불가능합니다.
        // 이 문제를 해결하기 위해, 문제의 의도에 맞게 String과 int를 명시적으로 변환해야 합니다.
        // strA + strB는 문자열 결합, 그 결과와 strC를 뺄셈하기 위해 다시 정수로 변환합니다.
        int result2 = Integer.parseInt(strA + strB) - Integer.parseInt(strC);
        System.out.println(result2);
    }
}