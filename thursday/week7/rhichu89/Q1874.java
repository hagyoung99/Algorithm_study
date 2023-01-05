import java.util.Scanner;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();
        int[] numbers = new int[num];

        for (int i = 0; i < num; i++) {
            numbers[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int value = 1;

        /*
          {1} > {2} +
          {}  > {2} -
          {2} > {3} +
          {}  > {3} -
          {3,4,5} > {6} +++
          {3,4} > {6} -
          {3} > {6}
        * */
        for (int i = 0; i < num; i++) {
            int current = numbers[i];

            if (current >= value) {
                while (current >= value) {
                    stack.push(value++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();
                if (pop > current) {
                    System.out.println("NO");
                    return;
                } else {
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb);
    }
}
