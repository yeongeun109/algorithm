package algo_0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5643_키순서 {

	static boolean[] visited;
	static int[] nodes;
	static int N, cnt;
	static List<Integer>[] inlist;
	static List<Integer>[] outlist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine()); // 학생수
			int M = Integer.parseInt(in.readLine()); // 비교횟수

			nodes = new int[N + 1];
			inlist = new ArrayList[N + 1];
			outlist = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				inlist[i] = new ArrayList<Integer>();
				outlist[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				inlist[b].add(a);
				outlist[a].add(b);
			}
			cnt = 0;
			int res = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				visited = new boolean[N + 1];
				
				bfs(i);
				nodes[i] = cnt;
				if (nodes[i] == N - 1)
					res++;
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		if (!inlist[i].isEmpty())
			q.offer(i);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int j = 0; j < inlist[curr].size(); j++) {
				if(!visited[inlist[curr].get(j)]) {
					visited[inlist[curr].get(j)] = true;
					q.offer(inlist[curr].get(j));
					cnt++;
				}					
			}			
		}		
		
		if (!outlist[i].isEmpty())
			q.offer(i);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int j = 0; j < outlist[curr].size(); j++) {
				if(!visited[outlist[curr].get(j)]) {
					visited[outlist[curr].get(j)] = true;
					q.offer(outlist[curr].get(j));
					cnt++;
				}					
			}			
		}
	}

}
