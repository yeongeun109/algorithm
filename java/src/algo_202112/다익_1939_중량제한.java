package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다익_1939_중량제한 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] list = new ArrayList[N + 1];
		int[] d = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[f].add(new int[] {t, c});
			list[t].add(new int[] {f, c});
		}
		
		
		st = new StringTokenizer(in.readLine(), " ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {from, Integer.MAX_VALUE});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int cv = tmp[0];
			int cc = tmp[1];
			
			for(int i = 0; i < list[cv].size(); i++) {
				int tv = list[cv].get(i)[0];
				int tc = list[cv].get(i)[1];
				
				if(d[tv] > Math.min(tc, cc)) {
					d[tv] = Math.min(tc, cc);
					q.offer(new int[] {tv, d[tv]});
				}
			}
		}
		
		System.out.println(d[to]);
	}

}
