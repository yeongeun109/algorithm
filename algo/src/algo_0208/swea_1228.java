package algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			int N = Integer.parseInt(in.readLine());
			LinkedList list = new LinkedList();
			
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			for(int n = 0; n < N; n++) {
				list.addNode(st.nextToken());
			}
			
			int change = Integer.parseInt(in.readLine());
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			int cnt = 0;
			
			while(cnt < change) {
				if(st2.nextToken().equals("I")) {
					cnt++;
					int index = Integer.parseInt(st2.nextToken());
					int changeNum = Integer.parseInt(st2.nextToken());
					
					if(index == 0) {
						list.addFirstNode(st2.nextToken());
						index++;
						for(int i = 1; i < changeNum; i++) {
							String data = st2.nextToken();
							list.insert(list.getNode(index), data);
							index++;
						}
					}else {
						for(int i = 0; i < changeNum; i++) {
							String data = st2.nextToken();
							list.insert(list.getNode(index), data);
							index++;
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t+1).append(" ").append(list.printList());
			System.out.println(sb);
		}
	}
	
	static public class Node {
		public String data;
		public Node link;
		
		public Node(String data) {
			super();
			this.data = data;
		}
		
		public Node(String data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}

	}


	static public class LinkedList {
		private Node head;
		
		public void addFirstNode(String data) {
			Node newNode = new Node(data, head);
			head = newNode;
		}
		
		public void insert(Node preNode, String data) {
			Node newNode;
			if(preNode.link == null) {
				newNode = new Node(data);
			}
			else {
				newNode = new Node(data, preNode.link);
			}
			preNode.link = newNode;
		}
		
		public Node getNode(int index) {
			Node currNode = head;
			
			if(index != 0) {
				for(int i = 0; i < index-1; i++) {
					currNode = currNode.link;
				}
			}

			return currNode;
		}
		
		public Node getLastNode() {
			Node currNode = head;
			
			if(currNode != null) {
				while(currNode.link != null) {
					currNode = currNode.link;
				}
			}
			
			return currNode;
		}
		
		public void addNode(String data) {
			if(head == null) {
				addFirstNode(data);
				return;
			}
			
			Node lastNode = getLastNode();
			Node newNode = new Node(data);
			lastNode.link = newNode;
		}

		public StringBuilder printList() {
			StringBuilder sb = new StringBuilder();
			Node currNode = head;
			for(int i = 0; i < 10; i++) {
				sb.append(currNode.data).append(" ");
				currNode = currNode.link;
			}
			
			return sb;
		}
	}
}
