package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SWEA_1222 {

    // 중위 표기식을 후위 표기식으로 변환하는 메서드
    public static String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // 숫자는 바로 후위 표기식에 추가
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            }
            // 연산자는 스택에 추가
            else if (ch == '+') {
                stack.push(ch);
            }
        }

        // 스택에 남은 모든 연산자를 후위 표기식에 추가
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // 후위 표기식을 계산하는 메서드
    public static int calculatePostfix(String postfix) {
    	ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (char ch : postfix.toCharArray()) {
            // 피연산자(숫자)이면 스택에 넣기
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            // 연산자이면 스택에서 피연산자 두 개를 꺼내 연산
            else if (ch == '+') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            int length = Integer.parseInt(br.readLine());
            String infixExpression = br.readLine();

            String postfixExpression = toPostfix(infixExpression);
            int result = calculatePostfix(postfixExpression);

            System.out.println("#" + testCase + " " + result);
        }
    }
}