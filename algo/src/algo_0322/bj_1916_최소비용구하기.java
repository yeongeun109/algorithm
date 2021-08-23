package algo_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		
		List<int[]>[] list = new ArrayList[V + 1];
		int distance[] = new int[V + 1];
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<int[]>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer st = null;
		int M = Integer.parseInt(in.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, cost});
		}

		st = new StringTokenizer(in.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()); // 출발점
		int end = Integer.parseInt(st.nextToken()); // 도착점
		
		distance[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int vertex = temp[0];
			int cost = temp[1];
			
			if(cost > distance[vertex])
				continue;
			
			for(int j = 0; j < list[vertex].size(); j++) {
				if(distance[list[vertex].get(j)[0]] > cost + list[vertex].get(j)[1]) {
					distance[list[vertex].get(j)[0]] = cost + list[vertex].get(j)[1];
					pq.offer(new int[] {list[vertex].get(j)[0], distance[list[vertex].get(j)[0]]});
				}
			}
		}
		
		System.out.println(distance[end]);
	}

}
