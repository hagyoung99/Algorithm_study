package thursday.week19.jinu;

import java.io.*;
import java.util.*;

// 이 문제는 자료 구조 큐를 이용하여 위에서 주어진 조건에 맞게 최단시간을 구하는 알고리즘
// 트럭들을 보관할 큐와 다리 위에 올라간 트럭들을 저장할 큐를 사용
// 각각의 큐에는 입력받은 자료의 무게와 인덱스를 저장하게 해서 문제를 해결

class Node {
    int index, weight;

    Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}

public class Question13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Node> truck = new LinkedList<>();
        int[] location = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            truck.offer(new Node(i, weight));
        }

        Queue<Node> bridge = new LinkedList<>();
        int count = 0;
        int sum = 0;

        while (!truck.isEmpty()) {
            Node a = truck.peek();
            int idx = a.index;
            int weight = a.weight;

            if (!bridge.isEmpty()) {
                int start = bridge.peek().index;

                for (int i = start; i < idx; i++)
                    location[i]--;

                if (location[start] == 0) {
                    sum -= bridge.poll().weight;
                }
            }

            if (sum + weight <= L) {
                bridge.offer(truck.poll());

                sum += weight;
                location[idx] = W;
            }

            count++;
        }

        System.out.println(count + W);
    }
}
