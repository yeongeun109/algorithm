package algo_2202;

import java.util.*;
import java.io.*;

public class 구현_1655_가운데를말해요 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(in.readLine());
			if(pq1.size() == pq2.size()) {
				pq1.add(n);
			}else if(pq1.size() == pq2.size() + 1) {
				pq2.add(n);
			}
			
			if(!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
				int a = pq1.poll();
				int b = pq2.poll();
				pq1.add(b);
				pq2.add(a);
			}
			
			sb.append(pq1.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}