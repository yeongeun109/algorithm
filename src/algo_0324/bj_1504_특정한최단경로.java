package algo_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1504_특정한최단경로 {

	static List<int[]>[] list;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		double[] d = new double[N + 1];
		
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, cost});	
			list[to].add(new int[] {from, cost});
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		double sum = 0;
		int start = 1;
		int end = v1;		
		sum += findPath(start, end, d);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		start = v1;
		end = v2;
		sum += findPath(start, end, d);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		start = v2;
		end = N;
		sum += findPath(start, end, d);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		int sum2 = 0;
		start = 1;
		end = v2;		
		sum2 += findPath(start, end, d);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		start = v2;
		end = v1;
		sum2 += findPath(start, end, d);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		start = v1;
		end = N;
		sum2 += findPath(start, end, d);
		
		
		if(sum >= Integer.MAX_VALUE || sum2 >= Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(Math.min((int)sum, (int)sum2));
		//System.out.println(sum + " " + sum2);
	}

	private static double findPath(int start, int end, double[] d) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		pq.offer(new int[] {start, 0});
		d[start] = 0;
		
		while(!pq.isEmpty()){
			int[] temp = pq.poll();
			int toV = temp[0];
			int fromC = temp[1];
			
			if(fromC > d[toV])
				continue;
			
			for(int i = 0; i < list[toV].size(); i++) {
				int nextV = list[toV].get(i)[0];
				int nextC = list[toV].get(i)[1];
				if(fromC + nextC < d[nextV]) {
					pq.offer(new int[] {nextV, fromC + nextC});
					d[nextV] = fromC + nextC;
				}
				visited[nextV] = true;
			}
		}
		
		return d[end];
	}

}
