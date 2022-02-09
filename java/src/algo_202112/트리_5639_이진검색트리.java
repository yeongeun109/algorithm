package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리_5639_이진검색트리 {
	
	static Node[] list = new Node[1000001];
	static StringBuilder sb = new StringBuilder();
	static int maxIdx = 0;
	
	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int first = 0;

		while (true) {
			str = in.readLine();
			if(str == null) {
				break;
			}
			int n = Integer.parseInt(str);
			
			if(maxIdx != 0)
				findParent(n, first);
			else {
				list[n] = new Node(-1, -1);
				maxIdx++;
				first = n;
			}
		}
		
		postOrder(first);
		System.out.println(sb);
	}

	private static void postOrder(int i) {
		if(i == -1)
			return;
		
		postOrder(list[i].left);
		postOrder(list[i].right);
		sb.append(i).append("\n");
	}

	private static void findParent(int n, int idx) {
		Node p = list[idx];
		
		if(n < idx) {
			if(p.left == -1) {
				list[n] = new Node(-1, -1);
				p.left = n;
				return;
			}else {
				findParent(n, p.left);
			}
		}else {
			if(p.right == -1) {
				list[n] = new Node(-1, -1);
				p.right = n;
				return;
			}else{
				findParent(n, p.right);
			}
		}
	}
}
