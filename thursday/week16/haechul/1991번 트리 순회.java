package BOJ.boj1991;

import java.util.*;

public class Main {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] node = sc.nextLine().split(" ");
            char parent = node[0].charAt(0);
            char left = node[1].charAt(0);
            char right = node[2].charAt(0);
            insertNode(head, parent, left, right);
        }

        preOrder(head); // 전위순회
        System.out.println();
        inOrder(head); // 중위순회
        System.out.println();
        postOrder(head); // 후위순회
        System.out.println();
    }

    private static void insertNode(Node temp, char parent, char left, char right) {
        if (temp.value == parent) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (left == '.' ? null : new Node(right, null, null));
        } else {
            if(temp.left != null) insertNode(temp.left, parent, left, right);
            if(temp.right != null) insertNode(temp.right, parent, left, right);
        }
    }

    public static void preOrder(Node node) {
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
