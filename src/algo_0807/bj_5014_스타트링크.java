package algo_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class bj_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int F = Integer.parseInt(st.nextToken()); // 빌딩높이
		int S = Integer.parseInt(st.nextToken()); // 현재위치
		int G = Integer.parseInt(st.nextToken()); // 목표
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken()) * - 1;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {S, 0});

		boolean flag = false;
		boolean[] visited = new boolean[F+1];
		visited[S] = true;
		int answer = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == G) {
				flag = true;
				answer = tmp[1];
				break;
			}
			
			if(tmp[0] + U <= F && !visited[tmp[0] + U]) {
				q.offer(new int[] {U + tmp[0], tmp[1] + 1});
				visited[tmp[0] + U] = true;
			}
			
			if(tmp[0] + D >= 1 && !visited[tmp[0] + D]) {
				q.offer(new int[] {D + tmp[0], tmp[1] + 1});
				visited[tmp[0] + D] = true;
			}
		}	
		
		if(flag)
			System.out.println(answer);
		else
			System.out.println("use the stairs");
	}

}
