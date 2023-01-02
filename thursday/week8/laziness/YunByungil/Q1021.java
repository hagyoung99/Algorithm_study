import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 저장할 수
        int m = Integer.parseInt(st.nextToken()); // 내가 찾고 싶은 수의 갯수 3이면 3개 찾는 거임

        // queue 에 n만큼 저장, (n = 10이면 1~10저장)
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        /*
        1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
        2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
        3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.

        2, 3을 최소화할 수 있어야 함.
         */
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            count = checkQueuePeekNumberSameInputNumber(number);
            answer += count;
        }

        System.out.println(answer);

    }

    static int checkQueuePeekNumberSameInputNumber(int inputNumber) {
        if (queue.peek() == inputNumber) {
            popNumber();
            return 0;
        }

        LinkedList<Integer> secondQ = new LinkedList<>(queue);
        LinkedList<Integer> thirdQ = new LinkedList<>(queue);
        int second = popAndOffer(secondQ, inputNumber);
        int third = popLastAndOfferFirst(thirdQ, inputNumber);

        if (second <= third) {
            popAndOffer(queue, inputNumber);
            queue.poll();
        } else {
            popLastAndOfferFirst(queue, inputNumber);
            queue.poll();
        }

        return Math.min(second, third);
    }

    // 1. 메서드
    static void popNumber() { // 내가 입력한 숫자와 큐의 맨 앞 숫자가 일치할 때, 추출
        queue.poll();
    }

    // 2. 메서드
    static int popAndOffer(LinkedList<Integer> q, int inputNumber) { // 처음 값을 맨 뒤로 넘기는 과정
        int count = 0;
        while (q.peek() != inputNumber) {
            count++;
            q.offer(q.pop());
        }
        return count;
    }

    // 3. 메서드
    static int popLastAndOfferFirst(LinkedList<Integer> q, int inputNumber) { // 맨 뒤의 값을 처음으로 넘기는 과정
        int count = 0;

        while (q.peek() != inputNumber) {
            count++;

            q.offerFirst(q.pollLast());
        }
        return count;
    }
}