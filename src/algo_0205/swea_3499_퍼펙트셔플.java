package algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();
			
			
			if(N % 2 == 0) {		
				for(int i = 0; i < N; i++) {
					if(i < N/2)
						queue1.offer(st.nextToken());
					else
						queue2.offer(st.nextToken());
				}
			}else {
				for(int i = 0; i < N/2+1; i++)
					queue1.offer(st.nextToken());
				for(int i = N/2+1; i < N; i++)
					queue2.offer(st.nextToken());
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t+1).append(" ");

			while(!queue1.isEmpty() && !queue2.isEmpty()) {
				sb.append(queue1.poll()).append(" ").append(queue2.poll()).append(" ");
			}
			
			if(N % 2 != 0)
				sb.append(queue1.poll());
			
			System.out.println(sb);
		}
		
	}

}
