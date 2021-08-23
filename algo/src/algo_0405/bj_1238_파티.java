package algo_0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1238_파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<int[]>[] list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, cost});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int go[] = new int[N + 1];
		int back[] = new int[N + 1];
		
		for(int j = 1; j <= N; j++) {
			int[] d = new int[N + 1];
			Arrays.fill(d, Integer.MAX_VALUE);
			
			pq.offer(new int[] {j, 0});
			d[j] = 0;
			while(!pq.isEmpty()) {
				int tempArr[] = pq.poll();
				int currV = tempArr[0];
				int currC = tempArr[1];
				
				for(int i = 0; i < list[currV].size(); i++) {
					int tempV = list[currV].get(i)[0];
					int tempC = list[currV].get(i)[1];
					
					if(d[tempV] > currC + tempC) {
						d[tempV] = currC + tempC;
						pq.add(new int[] {tempV, d[tempV]});
					}
				}
			}
			
			if(j != X)
				go[j] = d[X];
			else {
				back = d.clone();
			}
		}
		
		/*System.out.println(Arrays.toString(go));
		System.out.println(Arrays.toString(back));*/
		int max = 0;
		for(int i = 1; i <= N; i++) {
			int temp = go[i] + back[i];
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}

}
