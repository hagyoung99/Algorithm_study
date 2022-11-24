import java.util.*;

public class Q1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        List<Integer> list = new ArrayList<Integer>();

        while (num > 0) {
            list.add(num % 10);
            num = num / 10;
        }

        Collections.sort(list, Collections.reverseOrder());

        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = result * 10 + list.get(i);
        }

        System.out.println(result);
    }
}
