import java.util.*;

public class Lazy1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(); scanner.nextLine();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedList<Integer> list = new LinkedList<>(); // 입력 끝
        for (int i = 1; i <= n; i++) list.addLast(i); // 1부터 n까지 list에 넣어줌
        int cnt = 0;
        // 뽑아야 될 숫자들을 순차적으로 순회하며
        for (int i = 0; i < m; i++) {
            // 1번 연산으로(첫 번째 원소) numbers[i]와 같지 않은 경우 작업
            if(numbers[i] != list.getFirst()){
                // 일단 2번(왼쪽 로테이션)이 나을지 3번(오른쪽 로테이션)이 나을지 결정짓기 위해 변수 잡고
                int halfIdx = list.size() / 2;
                // 오른쪽에 가까울 경우(인덱스 절반 넘음) 3번 연산
                if(list.indexOf(numbers[i]) > halfIdx) {
                    // 1번 연산으로 같지 않을 때까지
                    while(numbers[i] != list.getFirst()) {
                        // 카운트 1씩 증가시키며 3번 연산(오른쪽에서 뽑아다 왼쪽에 넣어줌)
                        list.addFirst(list.pollLast()); cnt++;
                    }
                } else { // 왼쪽에 가까울 경우 마찬가지로 1번 연산으로 같지 않을 때까지
                    while(numbers[i] != list.getFirst()) {
                        // 이번에는 카운트 1씩 증가시키며 2번 연산(왼쪽에서 뽑아다 오른쪽에 넣어줌)
                        list.addLast(list.pollFirst()); cnt++;
                    }
                }
            }
            list.pollFirst();
        }
        System.out.println(cnt);
    }
}
