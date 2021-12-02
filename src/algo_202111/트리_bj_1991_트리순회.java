package algo_202111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_bj_1991_트리순회 {

	static Node[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static public class Node{
		char parent;
		char left;
		char right;
		
		Node(char parent, char left, char right) {
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		arr = new Node[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			char p = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			arr[p - '0' - 17] = new Node(p, l, r);
		}

		preOrder('A');
		sb.append("\n");
		inOrder('A');
		sb.append("\n");
		postOrder('A');
		System.out.println(sb);
	}
	
	static public void preOrder(char p) {
		if(p == '.')
			return;
		
		int index = p - '0' - 17;
		sb.append(p);
		preOrder(arr[index].left);
		preOrder(arr[index].right);
	}

	static public void inOrder(char p) {
		if(p == '.')
			return;
		
		int index = p - '0' - 17;
		inOrder(arr[index].left);
		sb.append(p);
		inOrder(arr[index].right);
	}
	
	static public void postOrder(char p) {
		if(p == '.')
			return;
		
		int index = p - '0' - 17;
		postOrder(arr[index].left);
		postOrder(arr[index].right);
		sb.append(p);
	}
}
