package thursday.week16.jinu;

import java.io.*;

// 1991번 트리 순회(https://www.acmicpc.net/problem/1991)
class Node {
	int index;
	Node parent;
	Node leftchild;
	Node rightchild;

	public Node(int index) {
		super();
		this.index = index;
	}
}

public class Question1991 {
	static Node[] graph;

	static int N;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Node((char) (i + 'A'));
		}

		for (int i = 0; i < N; i++) {
			char n, l, r;
			String s = br.readLine();
			n = s.charAt(0);
			l = s.charAt(2);
			r = s.charAt(4);
			if (l != '.') {
				arr[n - 'A'].left = arr[l - 'A'];
			}
			if (r != '.') {
				arr[n - 'A'].right = arr[r - 'A'];
			}
		}

		// 전위 순회
		preOrder(arr[0]);
		sb.append("\n");
		// 중위 순회
		inOrder(arr[0]);
		sb.append("\n");
		// 후위 순회
		postOrder(arr[0]);
		sb.append("\n");

		System.out.println(sb);
	}

	static void preOrder(Node node) {
		sb.append(node.ch);
		if (node.left != null)
			preOrder(node.left);
		if (node.right != null)
			preOrder(node.right);
	}

	static void inOrder(Node node) {
		if (node.left != null)
			inOrder(node.left);
		sb.append(node.ch);
		if (node.right != null)
			inOrder(node.right);
	}

	static void postOrder(Node node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		sb.append(node.ch);
	}

	static class Node {
		char ch;
		Node left;
		Node right;

		public Node(char ch) {
			this.ch = ch;
		}
	}
}
