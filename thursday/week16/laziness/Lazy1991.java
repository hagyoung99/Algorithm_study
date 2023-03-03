package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy1991 {
    public static Node[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new Node[n];
        for (int i = 0; i < n; i++) arr[i] = new Node((char) (i + 'A'));
        for(int i = 0 ; i < n ; i++) {
            String str = reader.readLine();
            char node = str.charAt(0);
            char leftChild = str.charAt(2);
            char rightChild = str.charAt(4);
            if(leftChild != '.') arr[node - 'A'].left = arr[leftChild - 'A'];
            if(rightChild != '.') arr[node - 'A'].right = arr[rightChild - 'A'];
        }
        preOrder(arr[0]);
        System.out.println();
        inOrder(arr[0]);
        System.out.println();
        postOrder(arr[0]);
    }
    private static void preOrder(Node node) {
        System.out.print(node.data);
        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    }
    private static void inOrder(Node node) {
        if(node.left != null) inOrder(node.left);
        System.out.print(node.data);
        if(node.right != null) inOrder(node.right);
    }
    private static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.print(node.data);
    }
}

class Node {
    char data;
    Node left;
    Node right;
    public Node(char data) {
        this.data = data;
    }
}