package algo_2203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DK_10282_해킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			List<int[]>[] list = new ArrayList[n + 1];
			int[] time = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				list[i] = new ArrayList<int[]>();
				time[i] = Integer.MAX_VALUE;
			}
			
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int sec = Integer.parseInt(st.nextToken());
				
				list[to].add(new int[] {from, sec});
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {c, 0});
			time[c] = 0;
			
			
			while(!q.isEmpty()) {
				int[] com = q.poll();
				int currC = com[0];
				int currV = com[1];
				
				for(int i = 0; i < list[currC].size(); i++) {
					int nextC = list[currC].get(i)[0];
					int nextV = list[currC].get(i)[1];
					
					if(time[nextC] > currV + nextV) {
						time[nextC] = currV + nextV;
						q.offer(new int[] {nextC, time[nextC]});
					}
				}
			}
			
			int maxC = 0, maxV = 0;
			for(int i = 1; i < n + 1; i++) {
				if(time[i] != Integer.MAX_VALUE) {
					maxC++;
					if(time[i] > maxV)
						maxV = time[i];
				}
			}
			
			sb.append(maxC).append(" ").append(maxV).append("\n");
		}
		System.out.println(sb);
	}

}