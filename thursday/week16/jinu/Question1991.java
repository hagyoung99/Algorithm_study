package thursday.week16.jinu;

import java.io.*;
import java.util.*;

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

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		graph = new Node[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new Node(i);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int node = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';

			if (left >= 0)
				graph[node].leftchild = graph[left];
			if (right >= 0)
				graph[node].rightchild = graph[right];

			if (left >= 0)
				graph[left].parent = graph[node];
			if (right >= 0)
				graph[right].parent = graph[node];
		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		PostOrder(0);
	}

	private static void PostOrder(int cur) {
		// 왼쪽 노드 확인
		if (graph[cur].leftchild != null)
			PostOrder(graph[cur].leftchild.index);

		// 오른쪽 노드 확인
		if (graph[cur].rightchild != null)
			PostOrder(graph[cur].rightchild.index);

		// 자신 노드 확인
		System.out.print((char) (graph[cur].index + 'A'));
	}

	private static void inOrder(int cur) {
		// 왼쪽 노드 확인
		if (graph[cur].leftchild != null)
			inOrder(graph[cur].leftchild.index);

		// 자신 노드 확인
		System.out.print((char) (graph[cur].index + 'A'));

		// 오른쪽 노드 확인
		if (graph[cur].rightchild != null)
			inOrder(graph[cur].rightchild.index);
	}

	private static void preOrder(int cur) {
		// 자신 노드 확인
		System.out.print((char) (graph[cur].index + 'A'));

		// 왼쪽 노드 확인
		if (graph[cur].leftchild != null)
			preOrder(graph[cur].leftchild.index);

		// 오른쪽 노드 확인
		if (graph[cur].rightchild != null)
			preOrder(graph[cur].rightchild.index);
	}
}
