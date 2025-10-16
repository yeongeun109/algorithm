package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13335_트럭_구현 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()); // 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 최대하중
		int res = 0;
		
		st = new StringTokenizer(in.readLine());
		Queue<Integer> waitTruck = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			waitTruck.add(Integer.parseInt(st.nextToken()));
		}
		
		int bridgeWeight = 0;
		Queue<Integer> bridge = new LinkedList<>(); 
		
		for(int i = 0; i < w; i++) {
			bridge.add(0);
		}

		while(!bridge.isEmpty()) {
			res++;
			
			bridgeWeight -= bridge.poll();
			if(!waitTruck.isEmpty()) {
				if(bridgeWeight + waitTruck.peek() <= L) {
					int nextTruck = waitTruck.poll();
					bridgeWeight += nextTruck;
					bridge.add(nextTruck);
				}else {
					bridge.add(0);
				}
			}else {
				
			}
			
		}
		
		System.out.println(res);
	}
}
