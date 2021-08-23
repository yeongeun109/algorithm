package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11866_yoseputh {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			queue.offer(i+1);
		}
		
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < K-1; i++) {
				int n = queue.poll();
				queue.offer(n);
			}
			System.out.print(queue.poll());
			
			if(!queue.isEmpty())
				System.out.print(", ");
		}
		System.out.print(">");
	}

}
