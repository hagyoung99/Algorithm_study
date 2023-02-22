package Cue_Deck;

import java.util.Scanner;

public class BaekJoon10866 {

    static int front = 10000;
    static int back = 10000;
    static int size = 0;
    static int[] deque = new int[20001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String comand = sc.next();
            switch (comand) {
                case ("push_back"):
                    push_back(sc.nextInt());
                    break;
                case ("push_front"):
                    push_front(sc.nextInt());
                    break;
                case ("pop_front"):
                    sb.append(pop_front()).append('\n');
                    break;
                case ("pop_back"):
                    sb.append(pop_back()).append('\n');
                    break;
                case ("size"):
                    sb.append(size()).append('\n');
                    break;
                case ("empty"):
                    sb.append(empty()).append('\n');
                    break;
                case ("back"):
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push_back(int i) {
        back++;
        size++;
        deque[back] = i;
    }

   static void push_front(int i) {
        deque[front] = i;
        front--;
        size++;
    }

    static int pop_front() {
        if (size == 0) return -1;
        int ret = deque[front + 1];
        front++;
        size--;
        return ret;
    }

    static int pop_back() {
        if (size == 0) return -1;
        int ret = deque[back];
        back--;
        size--;
        return ret;
    }

    static int size() {
        return size;
    }

    static int empty() {
        if (size == 0) return 1;
        return 0;
    }

    static int front() {
        if (size == 0) return -1;
        return deque[front + 1];
    }

    static int back() {
        if (size == 0) return -1;
        return deque[back];
    }

}
