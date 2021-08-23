package algo_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_11779_최소비용구하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int[] d = new int[n + 1];
		int[] way = new int[n + 1];
		StringTokenizer st = null;
		Arrays.fill(d, Integer.MAX_VALUE);
		
		List<int[]>[] list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, cost});
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});		
		
		d[from] = 0;
		pq.offer(new int[] {from, 0});
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int vertex = temp[0]; // 가장 가까운 정점
			int cost = temp[1]; // 거리
			
			if(cost > d[vertex])
				continue;
			
			for(int i = 0; i < list[vertex].size(); i++) {
				int tempV = list[vertex].get(i)[0];
				int tempC = list[vertex].get(i)[1];
				
				if(d[tempV] > cost + tempC) {
					d[tempV] = cost + tempC;
					pq.offer(new int[] {tempV, d[tempV]});
					way[tempV] = vertex;
				}
			}
		}
		
		in.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(to);
		int tempTo = to;
		int cnt = 0;
		while(way[tempTo] != from) {
			stack.push(way[tempTo]);
			tempTo = way[tempTo];
			cnt++;
		}
		stack.push(from);
		
		System.out.println(d[to]);
		System.out.println(cnt + 2);

		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
}
