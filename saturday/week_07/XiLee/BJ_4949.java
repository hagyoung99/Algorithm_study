package week7;

import java.util.Scanner;
import java.util.Stack;

public class BJ_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if(s.equals(".")) break;    // 각 줄은 마침표로 끝낸다!
            String[] input = s.split(""); // 글자 단위로 쪼개기
            Stack<String> stack = new Stack<>();

            for (String str : input) {
                if (str.equals("(") || str.equals("[")) stack.push(str);
                else if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("["))
                    stack.pop();
                else if (str.equals(")") || str.equals("]"))
                    stack.push(str);
            }

            if (stack.empty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

// <접근 방식> 열린 괄호는 스택에 저장해두었다가 닫히는 괄호가 input으로 넘어오면 pop해주는 방식으로 구현

// Stack : LIFO
// push : 값 삽입
// peek : top 조회
// pop : top 삭제
// empty : 비어있으면 true
// contains(n) : n이 있는지 확인 -> boolean
// size : 사이즈 return