package 트리.골드.이진검색트리_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    System.out.println("if = " + n);
                    this.left = new Node(n);
                } else {
                    System.out.println("else = " + n);
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
    public static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String str = "";
        int count = 1;
        while (true) {
            count++;
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(str));
            if (count == 9) {
                break;
            }
        }
        System.out.println("root = " + root.num);

        dfs(root);
    }

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        System.out.println(node.num);


    }
}
