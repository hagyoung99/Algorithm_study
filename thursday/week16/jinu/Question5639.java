package thursday.week16.jinu;

import java.io.*;
import java.util.*;

// 5639번 이진 검색 트리(https://www.acmicpc.net/problem/5639) 
public class Question5639 {

    static ArrayList<Integer> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        tree = new ArrayList<Integer>();
        while (true) {
            String n = br.readLine();
            if (n == null || n.equals(""))
                break;
            // 더이상의 인풋이 존재하지 않으면 break

            tree.add(Integer.parseInt(n));
        }

        postOrder(0, tree.size() - 1);
    }

    public static void postOrder(int idx, int end) {
        if (idx > end)
            return;
        // 리스트 범위를 벗어나면 return

        int mid = idx + 1;
        while (mid <= end && tree.get(mid) < tree.get(idx)) {
            mid++;
        }
        postOrder(idx + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(tree.get(idx));
    }

}
