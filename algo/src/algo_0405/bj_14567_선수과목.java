package algo_0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14567_선수과목 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] gArr = new int[N + 1];
		int[] tArr = new int[N + 1];
		int[] result = new int[N + 1];
		List<Integer>[] list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			gArr[to]++;
		}
		tArr = gArr.clone();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(gArr[i] == 0)
				q.offer(i);
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int a = q.poll();
				result[a] = cnt;
				for(int j = 0; j < list[a].size(); j++) {
					int temp = --tArr[list[a].get(j)];
					if(temp == 0) {
						q.offer(list[a].get(j));
					}
				}
			}
		}


		for(int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}

}
