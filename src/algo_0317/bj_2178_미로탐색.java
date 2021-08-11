package algo_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178_미로탐색 {

	static int result = 0;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(arr);
		System.out.println(result + 1);
	}

	private static void bfs(int[][] arr) {
		int currX = 0, currY = 0;
		int goalX = N-1, goalY = M-1;
		boolean[][] visited = new boolean[N][M];
		Queue<Node> q = new LinkedList<Node>();
		int[] dx = {0, 1, 0, -1}; //오아왼위
		int[] dy = {1, 0, -1, 0};
		
		q.offer(new Node(currX, currY, null));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.x == goalX && temp.y == goalY) {
				while(true) {
					if(temp.prev != null) {
						result++;
						temp = temp.prev;
					}
					else
						break;
				}	
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tempX = temp.x + dx[i];
				int tempY = temp.y + dy[i];
				
				if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M)
					continue;
				
				if(visited[tempX][tempY])
					continue;
				
				if(arr[tempX][tempY] == 0)
					continue;
				
				q.offer(new Node(tempX, tempY, temp));
				visited[tempX][tempY] = true;
			}
		}
		
	}
	
	public static class Node{
		int x;
		int y;
		Node prev;
		
		public Node(int x, int y, Node prev) {
			super();
			this.x = x;
			this.y = y;
			this.prev = prev;
		}
	}

}
