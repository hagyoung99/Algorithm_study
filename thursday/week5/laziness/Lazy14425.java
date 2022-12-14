import java.util.HashSet;
import java.util.Scanner;

public class Lazy14425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(); scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++) set.add(scanner.nextLine()); // 집합 s에 대한 입력받음
        int answer = 0;
        for(int i = 0 ; i < m ; i++) {
            if(set.contains(scanner.nextLine())) answer++; // 있는 경우 하나씩 카운트
        }
        System.out.println(answer);
    }
}
