package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy5639 {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       Node root = new Node(Integer.parseInt(reader.readLine()));
       while(true) {
            try {
                root.insert(Integer.parseInt(reader.readLine()));
            } catch (Exception e) {
                break;
            }
       }
       postOrder(root);
    }

    private static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
    public static class Node {
        int num;
        Node left, right;
        public Node(int num) {
            this.num = num;
        }
        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
        public void insert(int n) {
            if(n < this.num) {
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
    
}