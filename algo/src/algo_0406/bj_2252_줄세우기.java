package algo_0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N + 1];
		int[] vArr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			list[front].add(back);
			vArr[back]++;
		}

		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (vArr[i] == 0) {
				q.offer(i);
				sb.append(i).append(" ");
			}
		}

		while (!q.isEmpty()) {
			int student = q.poll();

			for (int i = 0; i < list[student].size(); i++) {
				int temp = list[student].get(i);
				if (--vArr[temp] == 0) {
					q.offer(temp);
					sb.append(temp).append(" ");
				}
			}
		}
		
		System.out.println(sb);
	}

}
